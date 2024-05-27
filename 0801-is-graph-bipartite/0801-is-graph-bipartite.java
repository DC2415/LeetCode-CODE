class Solution {
    public boolean isBipartite(int[][] graph) {
    int[] vis=new int[graph.length];
    Arrays.fill(vis,-1);
    for(int i=0;i<graph.length;i++){
        if(vis[i]==-1){
            if(dfs(graph,i,0,vis)==false){
                return false;
            }
        }
    }
    return true;
    }
    public boolean dfs(int[][] graph,int node ,int col, int[] vis){
        if (vis[node] != -1) {
            return vis[node] == col;
        }
        vis[node] = col;
        for(int a:graph[node]){
            if(!dfs(graph,a,1-col,vis)){
                return false;
            }else if(vis[a]==col){
                return false;
            }
        }
        return true;
    }
}