class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < len; i++) {
            counter[sc[i] - 'a'] += 1;
            counter[tc[i] - 'a'] -= 1;
        }
        for (var c: counter) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
