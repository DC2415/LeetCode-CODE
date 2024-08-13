class Solution {
    public List<List<Integer>> combinationSum2(int[] can, int target) {
        List<Integer> ds= new ArrayList();
       List<List<Integer>> ans= new ArrayList();
       Arrays.sort(can);
        helper(0,target,can,ds,ans);
        return ans;
    }
    public void helper(int i,int tar,int[] can,List<Integer> ds,List<List<Integer>> ans){
        if(tar==0){
            ans.add(new ArrayList(ds));
            return ;
        }
        for(int ind =i;ind<can.length;ind++){
            if(ind >i && can[ind]==can[ind-1]){
                continue;
            }
            if(can[ind]>tar){
                break;
            }
            ds.add(can[ind]);
            helper(ind+1,tar-can[ind],can,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}