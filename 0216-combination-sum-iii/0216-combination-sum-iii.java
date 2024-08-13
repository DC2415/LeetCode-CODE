class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ds= new ArrayList();
       List<List<Integer>> ans= new ArrayList();
       int[] can=new int[]{1,2,3,4,5,6,7,8,9};
       //Arrays.sort(can);
        helper(0,n,k,can,ds,ans);
        return ans;
    }
    public void helper(int i,int tar,int k,int[] can,List<Integer> ds,List<List<Integer>> ans){
        if(tar==0 && ds.size()==k){
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
            helper(ind+1,tar-can[ind],k,can,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}
