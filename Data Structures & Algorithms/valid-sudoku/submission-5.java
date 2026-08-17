class Solution {
    public boolean isValidSudoku(char[][] board) {
        var store = new HashSet<Key>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }

                if (!store.add(new Key(i, -1, -1, value)) ||
                    !store.add(new Key(-1, j, -1, value)) ||
                    !store.add(new Key(-1, -1, (i / 3) * 3 + j/3, value))) {
                    return false;
                }
            }
        }
        return true;
    }


    private static record Key(int i, int j, int q, char value) {}        

}