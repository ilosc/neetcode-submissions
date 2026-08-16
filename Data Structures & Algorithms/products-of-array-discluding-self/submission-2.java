class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int size = nums.length;
        
        final int[] prefix = new int[size];
        int prev = 1;
        for (int i = 0; i < size; i++) {
            prefix[i] = prev;
            prev *= nums[i];
        }

        final int[] suffix = new int[size];
        prev = 1;
        for (int i = size - 1; i >= 0; i--) {
            suffix[i] = prev;
            prev *= nums[i];
        }

        final int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
