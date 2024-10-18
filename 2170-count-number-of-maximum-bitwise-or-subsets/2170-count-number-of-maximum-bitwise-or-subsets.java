class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int  maxOr=0;
        for(int a : nums){
            maxOr|=a;
        }
        List<Integer> ds =new ArrayList();
        int ans=helper(0,nums,maxOr,ds);
        return ans;
    }
    public int helper(int i,int[] nums,int maxOr,List<Integer> ds){
        if(i==nums.length){
            if(Oring(ds)==maxOr){
                return 1;
            }
            return 0;
        }

        int pick=0,np=0;
        np+=helper(i+1,nums,maxOr,ds);

        ds.add(nums[i]);
        pick+=helper(i+1,nums,maxOr,ds);
        ds.remove(ds.size()-1);
        
        return np+pick;
    }
    public int Oring(List<Integer> ds){
        int m=0;
        for(int a:ds){
            m|=a;
        }
        return m;
    }
}