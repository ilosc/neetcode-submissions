class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a'] += 1;
            counter[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
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
        /*
        var record = new TreeMap<Integer, Integer>();
        s.chars().forEach(c -> record.put(c, record.getOrDefault(c, 0) + 1));
        t.chars().forEach(c -> record.put(c, record.getOrDefault(c, 0) - 1));
        for (var value: record.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
        */
    }
}
