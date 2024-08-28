class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        int[][] vis = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && vis[i][j] == 0) {
                    if (dfs(i, j, grid2, grid1, vis)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public boolean dfs(int r, int c, int[][] grid2, int[][] grid1, int[][] vis) {
        if (r < 0 || c < 0 || r >= grid2.length || c >= grid2[0].length || vis[r][c] == 1 || grid2[r][c] == 0) {
            return true;
        }

        vis[r][c] = 1;

        boolean isSubIsland = true;
        if (grid1[r][c] == 0) {
            isSubIsland = false;
        }

        isSubIsland &= dfs(r + 1, c, grid2, grid1, vis);
        isSubIsland &= dfs(r - 1, c, grid2, grid1, vis);
        isSubIsland &= dfs(r, c + 1, grid2, grid1, vis);
        isSubIsland &= dfs(r, c - 1, grid2, grid1, vis);

        return isSubIsland;
    }
}
