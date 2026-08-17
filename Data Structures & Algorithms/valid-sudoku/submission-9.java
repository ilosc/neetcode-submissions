class Solution {
    public boolean isValidSudoku(char[][] board) {
        var rows = new boolean[9][9];
        var cols = new boolean[9][9];
        var quads = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final char c = board[i][j];
                if (board[i][j] == '.') {
                    continue;
                }
                final int value = c - '1';
                if (rows[i][value] || cols[j][value]) {
                    return false;
                }
                rows[i][value] = true;
                cols[j][value] = true;

                int idxQuad = ((i / 3) * 3) + (j / 3);
                if (quads[idxQuad][value]) {
                    return false;
                }
                quads[idxQuad][value] = true;
            }
        }
        return true;
    }
}
