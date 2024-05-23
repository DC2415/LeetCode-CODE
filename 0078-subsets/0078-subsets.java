class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans =new ArrayList<>();
       List<Integer> ds =new ArrayList<>();
        check(0,nums,ans,ds);
        return ans;
    }
    public void check(int i,int[] nums,List<List<Integer>> ans,List<Integer> ds){

        if(i==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        check(i+1,nums,ans,ds);
        ds.add(nums[i]);
        check(i+1,nums,ans,ds);
        ds.remove(ds.size()-1);
        
    }
}