class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var counter = new HashMap<Integer, Integer>();
        for (int n: nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        final int length = nums.length + 1;
        var freq = new List[length];
        for (var key: counter.keySet()) {
            final int value = counter.get(key);
            if (freq[value] == null)
                freq[value] = new ArrayList<Integer>();
            freq[value].add(key);
        }

        var topRank = new int[k];
        int added = 0;
        outer:
        for (int n = length - 1; ; n--) {
            if (freq[n] == null)
                continue;
            for (var num: freq[n]) {
                topRank[added++] = (Integer)num;
                if (added == k)
                    break outer;
            }
        }
        return topRank;
    }
}
