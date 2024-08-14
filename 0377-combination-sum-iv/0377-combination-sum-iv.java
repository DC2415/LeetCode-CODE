// class Solution {
//     public int combinationSum4(int[] nums, int target) {
//         return helper(0,target,nums);
//     }
//     public int helper(int i,int t,int[] can){
//         if(i>=can.length || t<0){
//             return 0;
//         }
//         if(t==0){
//             return 1;
//         }
      
//         int in=0,ex=0;
//         in = helper(i,t-can[i],can);
//         ex = helper(i+1,t,can);
//         return in+ex;
//     }
// }



class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[]dp=new int[target+1];
        Arrays.fill(dp,-1);
        return helper(target, nums,dp);
    }

    private int helper(int target, int[] nums,int[] dp) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int count = 0;
        for (int num : nums) {
            // Include the number and recursively solve for the reduced target
            count += helper(target - num, nums,dp);
        }

        return dp[target]=count;
    }
}
