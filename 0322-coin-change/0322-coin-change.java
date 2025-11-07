class Solution {
    public int coinChange(int[] coins, int amount) {
       int[] dp= new int[amount+1];
       Arrays.fill(dp,-1);
       int ans= helper(coins,coins.length,amount,dp);
       if(ans==Integer.MAX_VALUE){
        return -1;
       }
        return ans;
        
    }
    public static int helper(int[] coins,int n,int amount ,int[] dp){
        if(amount==0){
            return 0;
        }
        int mini = Integer.MAX_VALUE;
       
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
         if(dp[amount] != -1){
            return dp[amount];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans= helper(coins,n,amount-coins[i],dp); 
            if(ans != Integer.MAX_VALUE){
            mini=Math.min(ans+1,mini);}
        }
        return dp[amount]=mini;
    }
}