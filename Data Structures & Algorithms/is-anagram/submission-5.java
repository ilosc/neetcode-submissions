class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        var record = new HashMap<Character, Integer>();
        for (int n = 0; n < s.length(); n++) {
            char c = s.charAt(n);
            record.put(c, record.getOrDefault(c, 0) + 1);
        }
        for (int n = 0; n < t.length(); n++) {
            char c = t.charAt(n);
            record.put(c, record.getOrDefault(c, 0) - 1);
        }
        */
        var record = new TreeMap<Integer, Integer>();
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
