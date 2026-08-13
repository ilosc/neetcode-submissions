class Solution {
    public boolean hasDuplicate(int[] nums) {
        var record = new HashSet<Integer>();
        for (var item: nums) {
            if (record.contains(item)) {
                return true;
            }
            record.add(item);
        }
        return false;
    }
}