class Solution {
    public int maxProfit(int[] prices) {
       int ans=0,buy=prices[0];
       for(int i=1;i<prices.length;i++){
           if(prices[i]<buy){
            buy=prices[i];
           }else{
            ans=Math.max(ans,prices[i]-buy);
           }
        }
        return ans;
    }
}