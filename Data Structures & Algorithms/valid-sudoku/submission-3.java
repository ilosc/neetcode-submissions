class Solution {
    public boolean isValidSudoku(char[][] board) {
        var rows = new HashMap<Integer, HashSet<Character>>();
        for (int n = 0; n < 9; n++) {
            rows.put(n, new HashSet<>());
        }
        var cols = new HashMap<Integer, HashSet<Character>>();
        for (int n = 0; n < 9; n++) {
            cols.put(n, new HashSet<>());
        }

        var quadrants = new HashSet<Key>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }

                if (rows.get(i).contains(value)) {
                    return false;
                }
                rows.get(i).add(value);

                if (cols.get(j).contains(value)) {
                    return false;
                }
                cols.get(j).add(value);

                final var key = new Key(i / 3, j / 3, value);
                if (quadrants.contains(key)) {
                    return false;
                }
                quadrants.add(key);
            }
        }
        return true;
    }

    private static record Key(int i, int j, char value) {}
}
