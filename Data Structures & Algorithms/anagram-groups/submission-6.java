class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> previous = new HashMap<>();
        for (String word: strs) {
            int[] counter = new int[26];
            for (char c: word.toCharArray()) {
                counter[c - 'a']++;
            }
            var key = Arrays.toString(counter);
            var idx = previous.get(key);
            if (idx == null) {
                var list = new ArrayList<String>();
                list.add(word);
                result.add(list);
                previous.put(key, result.size() - 1);
            } else {
                result.get(idx).add(word);
            }
        }

        return result;
    }
}
