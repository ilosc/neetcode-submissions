class Solution {
    public boolean isAnagram(String s, String t) {
        var record = new HashMap<Integer, Integer>();
        s.chars().forEach(c -> record.put(c, record.getOrDefault(c, 0) + 1));
        t.chars().forEach(c -> record.put(c, record.getOrDefault(c, 0) - 1));
        for (var value: record.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
