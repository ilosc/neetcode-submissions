class Solution {

    public String encode(List<String> strs) {
        String s = "";
        for (String str: strs) {
            s += str.length() + "#" + str;
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        final var output = new ArrayList<String>();
        int currentPos = 0;
        final int length = str.length();
        while (currentPos < length) {
            final int idxSeparator = str.indexOf('#', currentPos);
            final int limit = idxSeparator + 1 + Integer.parseInt(str.substring(currentPos, idxSeparator));
            output.add(
                str.substring(idxSeparator + 1, limit)
            );
            currentPos = limit;
        }

        return output;
    }
}
