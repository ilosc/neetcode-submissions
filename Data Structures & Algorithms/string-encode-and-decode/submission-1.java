class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        final var output = new ArrayList<String>();
        while (str.length() > 0) {
            final int idxSeparator = str.indexOf('#');
            final int limit = idxSeparator + 1 + Integer.parseInt(str.substring(0, idxSeparator));
            output.add(
                str.substring(idxSeparator + 1, limit)
            );
            str = str.substring(limit);
        }

        return output;

    }
}
