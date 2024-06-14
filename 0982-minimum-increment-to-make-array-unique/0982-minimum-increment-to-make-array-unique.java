class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                continue;
            }else{
                if(nums[i-1]==nums[i]){
                    nums[i]=nums[i]+1;
                    ans+=1;
                }else{
                    int b=nums[i-1]-nums[i];
                    nums[i]=nums[i]+b+1;
                    ans+=(b+1);
                }
            }
        }
        return ans;
    }
}