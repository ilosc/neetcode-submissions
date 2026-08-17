class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int size = nums.length;
        
        final int[] prefix = new int[size];
        int prev = 1;
        for (int i = 0; i < size; i++) {
            prefix[i] = prev;
            prev *= nums[i];
        }

        final int[] result = new int[size];
        int suffix = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }
        return result;        
    }
}  
