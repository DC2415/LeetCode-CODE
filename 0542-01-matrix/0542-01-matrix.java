class pair{
    int row ;
    int col;
    int dist;
    public pair(int r,int c,int d){
        row=r;
        col=c;
        dist=d;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<pair> qu=new LinkedList<>();
        int vis[][] =new int[mat.length][mat[0].length];
        int dis[][] =new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    qu.add(new pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }

        int[] drow={-1,0,1,0};
        int[] dcol={0,-1,0,1};

        while(!qu.isEmpty()){
            pair a=qu.poll();
            int r=a.row;
            int c=a.col;
            int d=a.dist;
            System.out.print(d);
            dis[r][c]=d;
            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length && vis[nr][nc]==0){
                    qu.add(new pair(nr,nc,d+1));
                    vis[nr][nc]=1;
                }
            }
        }
        return dis;
    }
}