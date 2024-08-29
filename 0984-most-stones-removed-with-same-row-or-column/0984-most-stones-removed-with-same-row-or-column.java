class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int[] vis=new int[n];
        int g=0;
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                g+=1;
                dfs(stones,i,vis);
            }
        }
        return n-g;
    }
    public void dfs(int[][] s,int ind,int[] vis){
        vis[ind]=1;
        for(int i=0;i<s.length;i++){
            if(vis[i]!=1 && (s[i][0]==s[ind][0] || s[i][1]==s[ind][1])){
                dfs(s,i,vis);
            }
        }
    }
}