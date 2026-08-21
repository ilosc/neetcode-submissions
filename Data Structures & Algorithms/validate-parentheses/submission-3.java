class Solution {
    public boolean isValid(String s) {
        var symbols = new HashMap<Character, Character>();
        symbols.put(')', '(');
        symbols.put('}', '{');
        symbols.put(']', '[');

        var openSymbols = new HashSet<Character>(symbols.values());
        var stack = new ArrayList<Character>();

        for (char c: s.toCharArray()) {
            if (openSymbols.contains(c)) {
                stack.add(c);
            } else if (stack.isEmpty() || stack.removeLast() != symbols.get(c)) {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
