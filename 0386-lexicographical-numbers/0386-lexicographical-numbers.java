class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans =new ArrayList();
        for(int i=1;i<=9;i++){
            helper(i,n,ans);
        }
        return ans;
    }
    public void helper(int a,int n,List<Integer> ans){
        if(a > n){
            return;
        }
        ans.add(a);
        for(int i=0;i<=9;i++){
            int nn=(a*10)+i;
            if(nn> n){
                return ;
            }
            helper(nn,n,ans);
        }
    }
}