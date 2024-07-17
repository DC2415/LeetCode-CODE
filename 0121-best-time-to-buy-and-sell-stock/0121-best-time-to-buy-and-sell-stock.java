class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            int a=0;
            if(mini<=prices[i]){
                a=prices[i]-mini;
                profit=Math.max(profit,a);
            }else{
                mini=prices[i];
            }
        }
        return profit;
    }
}