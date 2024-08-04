/*class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        int dp[][]=new int[matrix.length][matrix.length];
        for(int j=0;j<matrix.length;j++){
            Arrays.fill(dp[j],-1);
        }
        int n=matrix.length;
        for(int i=0;i<matrix.length;i++){
            min=Math.min(min ,tabulation(0,i,matrix));
        }

        return min;
    }
    public int recur(int row,int col,int[][]matrix){
        if(row==matrix.length-1){
            return matrix[row][col];
        }
        int dow=matrix[row][col]+recur(row+1,col,matrix);
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(col-1>=0){
             left=matrix[row][col]+recur(row+1,col-1,matrix);
        }
        if(col+1<=matrix.length-1){
             right=matrix[row][col]+recur(row+1,col+1,matrix);
        }
        return Math.min(Math.min(left,right),dow);
    }
       public int memo(int row,int col,int[][]matrix,int[][] dp){
        if(row==matrix.length-1){
            return matrix[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int dow=matrix[row][col]+memo(row+1,col,matrix,dp);
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(col-1>=0){
             left=matrix[row][col]+memo(row+1,col-1,matrix,dp);
        }
        if(col+1<=matrix.length-1){
             right=matrix[row][col]+memo(row+1,col+1,matrix,dp);
        }
        return dp[row][col]=Math.min(Math.min(left,right),dow);
    }

  public int tabulation(int row, int col, int[][] matrix) {
    int dp[][] = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix[0].length; i++) {
        dp[matrix.length - 1][i] = matrix[matrix.length - 1][i];
    }

    for (int i = matrix.length - 2; i >= 0; i--) {
        for (int j = 0; j < matrix[0].length; j++) {
            int down = matrix[i][j] + dp[i + 1][j];
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            
            if (j - 1 >= 0) {
                left = matrix[i][j] + dp[i + 1][j - 1];
            }
            if (j + 1 < matrix[0].length) {
                right = matrix[i][j] + dp[i + 1][j + 1];
            }

            dp[i][j] = matrix[i][j] + Math.min(Math.min(left, right), down);
        }
    }

    return dp[0][col];
}

}*/


public class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        if (m == 1 || n == 1) return A[0][0];

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; ++i) {
            ans = Math.min(ans, minFallingPathSum(A, 0, i, dp));
        }

        return ans;
    }

    private int minFallingPathSum(int[][] A, int row, int col, int[][] dp) {
        int m = A.length;
        int n = A[0].length;

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        if (row == m - 1)
            return dp[row][col] = A[row][col];

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (col > 0)
            left = minFallingPathSum(A, row + 1, col - 1, dp);

        int straight = minFallingPathSum(A, row + 1, col, dp);

        if (col < n - 1)
            right = minFallingPathSum(A, row + 1, col + 1, dp);

        dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];

        return dp[row][col];
    }
}
