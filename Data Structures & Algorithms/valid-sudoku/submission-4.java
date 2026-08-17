class Solution {
    public boolean isValidSudoku(char[][] board) {
        var store = new HashSet<Key>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }

                var key = new Key(i, -1, -1, value);
                if (store.contains(key)) {
                    return false;
                }
                store.add(key);

                key = new Key(-1, j, -1, value);
                if (store.contains(key)) {
                    return false;
                }
                store.add(key);

                key = new Key(-1, -1, (i / 3) * 3 + j/3, value);
                if (store.contains(key)) {
                    return false;
                }
                store.add(key);
            }
        }
        return true;
    }


    private static record Key(int i, int j, int q, char value) {}        

}