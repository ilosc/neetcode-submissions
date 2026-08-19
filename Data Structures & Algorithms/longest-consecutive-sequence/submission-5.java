class Solution {
    public int longestConsecutive(int[] nums) {
        var numsSet = new HashSet<Integer>();
        for (var n: nums) {
            numsSet.add(n);
        }

        int longest = 0;
        for (var n: numsSet) {
            if (!numsSet.contains(n - 1)) {
                int length = 1;
                while (numsSet.contains(n + length)) {
                    length++;
                }
                if (length > longest) {
                    longest = length;
                }
            }
        }

        return longest;
    }
}
