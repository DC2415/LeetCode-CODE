class Solution {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;
        int vis[][] = new int[rows][cols];

        // Check the first and last column
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(board, vis, i, 0);
            }
            if (board[i][cols - 1] == 'O' && vis[i][cols - 1] == 0) {
                dfs(board, vis, i, cols - 1);
            }
        }

        // Check the first and last row
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O' && vis[0][i] == 0) {
                dfs(board, vis, 0, i);
            }
            if (board[rows - 1][i] == 'O' && vis[rows - 1][i] == 0) {
                dfs(board, vis, rows - 1, i);
            }
        }

        // Flip all unvisited 'O's to 'X'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int[][] vis, int r, int c) {
        vis[r][c] = 1;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dRow[i];
            int nc = c + dCol[i];

            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && vis[nr][nc] == 0 && board[nr][nc] == 'O') {
                dfs(board, vis, nr, nc);
            }
        }
    }
}
