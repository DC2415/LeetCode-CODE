class Solution {
    public int findCircleNum(int[][] isConnected) {
        int vis[] = new int[isConnected.length];
        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) { 
            if (vis[i] == 0) {
                ans++;
                dfs(i, vis, isConnected);
            }
        }
        return ans; 
    }

    public static void dfs(int node, int[] vis, int[][] grf) {
        vis[node] = 1;
        for (int i = 0; i < grf.length; i++) {
            if (vis[i] == 0 && grf[node][i] == 1) { 
                dfs(i, vis, grf);
            }
        }
    }
}
