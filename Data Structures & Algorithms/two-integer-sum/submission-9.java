class Solution {
    public int[] twoSum(int[] nums, int target) {
        var cache = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int idx = cache.indexOf(target - nums[i]);
            if (idx != -1) {
                return new int[] {idx, i};
            }
            cache.add(i, nums[i]);
        }
        return null;
    }
}
