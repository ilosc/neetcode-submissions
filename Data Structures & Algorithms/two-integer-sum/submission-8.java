class Solution {
    public int[] twoSum(int[] nums, int target) {
        var diffMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = diffMap.get(target - nums[i]);
            if (j != null) {
                return new int[] {j, i};
            }
            diffMap.put(nums[i], i);
        }
        return null;
    }
}
