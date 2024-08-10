class Solution {
    public int regionsBySlashes(String[] grid) {
        int r=grid.length;
        int c=grid[0].length();
        int[][] mat=new int[r*3][c*3];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i].charAt(j)=='/'){
                    mat[i*3][j*3+2]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3]=1;
                }else if(grid[i].charAt(j)=='\\'){
                    mat[i*3][j*3]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3+2]=1;
                }
            }
        }
        int ans=0;
        for(int a=0;a<r*3;a++){
            for(int b=0;b<c*3;b++){
                if(mat[a][b]==0){
                    ans++;
                    dfs(mat,a,b);
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] mat,int i,int j){
        if(i<0 || j<0 || i>=mat.length||j>=mat.length|| mat[i][j]==1){
            return;
        }
        mat[i][j]=1;
        dfs(mat,i+1,j);
        dfs(mat,i-1,j);
        dfs(mat,i,j+1);
        dfs(mat,i,j-1);
    }
}