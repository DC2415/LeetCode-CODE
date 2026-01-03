class Solution {
     static String[] arr = {
    "RYR",
    "YRY",
    "GRY",
    "RYG",
    "YRG",
    "GRG",
    "RGR",
    "YGR",
    "GYR",
    "RGY",
    "YGY",
    "GYG"
};
static int mod =1000000007;
    public int numOfWays(int n) {
    int[][] dp = new int[n+1][12];
    for(int[] a : dp){
        Arrays.fill(a,-1);
    }
      int res =0;
      for(int i=0;i<12;i++){
        res= (res+generate(n-1,i,dp) )% mod;
      }
      return res;
    }
    static int generate(int n,int pre,int[][] dp) {
        if(n==0){
            return 1;
        }
        if(dp[n][pre]!=-1){
            return dp[n][pre];
        }
        String prev= arr[pre];
        int res=0;
        for (int cur = 0; cur < 12; cur++) {
            if(cur==pre){
                continue;
            }
            String curSt = arr[cur];
            boolean con =false;
            for(int i=0;i<3;i++){
                if(prev.charAt(i)==curSt.charAt(i)){
                    con=true;
                    break;
                }
            }
            if(!con){
                res=(res+generate(n-1,cur,dp)) % mod;
            }
        }
        return dp[n][pre]=res;
    }
}