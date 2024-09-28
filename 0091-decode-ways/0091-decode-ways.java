class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return recur(s,0,dp);
    }
    public int recur(String s,int i,int[] dp){
        if(i>=s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
                return 0;
            }
            if(dp[i]!=-1){
                return dp[i];
            }
        
      
        int ans=0;
        ans+=recur(s,i+1,dp);
        if(i+1<s.length()){
            int n=Integer.parseInt(s.substring(i,i+2));
            if(n>=10 && n<=26){
                ans+=recur(s,i+2,dp);
            }
        }
        return dp[i]=ans;
    }
}