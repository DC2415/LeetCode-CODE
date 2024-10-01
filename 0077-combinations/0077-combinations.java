class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr=new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        HashSet<List<Integer>> ans =new HashSet();
        List<Integer> ds=new ArrayList();
        List<List<Integer>> res=new ArrayList();
        recur(arr,k,0,ans,ds);
        for(List<Integer> q: ans){
            res.add(q);
        }
        return res;
    }
    public void recur(int[] arr, int k,int i,HashSet<List<Integer>> ans,List<Integer> ds){
        if(ds.size()==k){
            Collections.sort(ds);
            ans.add(new ArrayList(ds));
        }
        if(i>=arr.length){
            return;
        }
        recur(arr,k,i+1,ans,ds);
        ds.add(arr[i]);
        recur(arr,k,i+1,ans,ds);
        ds.remove(ds.size()-1);
    } 
}