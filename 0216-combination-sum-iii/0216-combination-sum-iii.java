class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ds= new ArrayList();
       List<List<Integer>> ans= new ArrayList();
        helper(1,n,k,ds,ans);
        return ans;
    }
    public void helper(int i,int tar,int k,List<Integer> ds,List<List<Integer>> ans){
        if(tar==0 && ds.size()==k){
            ans.add(new ArrayList(ds));
            return ;
        }
        for(int ind =i;ind<=9;ind++){
            if(ind>tar){
                break;
            }
            ds.add(ind);
            helper(ind+1,tar-ind,k,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}
