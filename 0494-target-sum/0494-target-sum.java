class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        
        int s1=(sum+target)/2;
        if((sum+target)%2==1){
            return 0;
        }
        return recur(nums.length-1,nums,s1);
    }
    public int recur(int i,int[] nums,int k){
      if(i==0){
          if(k==0 && nums[0]==0){
              return 2;
          }
          if(nums[0]==k || k==0){
              return 1;
          }
          else{
              return 0;
          }
      }
      int nt=recur(i-1,nums,k);
      int tk=0;
      if(nums[i]<=k){
          tk=recur(i-1,nums,k-nums[i]);
      }
      return nt+tk;
    }
}