class Solution {
    public boolean isValidSudoku(char[][] board) {
        var store = new HashSet<String>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final char value = board[i][j];
                if (value == '.') {
                    continue;
                }

                if (!store.add(i + "-1,-1," + value) ||
                    !store.add("-1," + j + ",-1," + value) ||
                    !store.add("-1,-1," + ((i / 3) * 3 + j/3) + "," + value)) {
                    return false;
                }
            }
        }
        return true;
    }
}