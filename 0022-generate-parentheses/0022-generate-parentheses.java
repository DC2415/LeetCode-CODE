class Solution {
    public List<String> generateParenthesis(int n) {
     List<String> ans=new ArrayList<>();
        check(n,0,0,"",ans);
        return ans;
    }
    public void check(int n ,int op,int col, String a,List<String> ans){
      if(op+col==2*n){
            if(op==col){
            ans.add(a);
            return;
            }
        }
        
      if(col>op || op>n || col>n){
        return;
      }
        check(n,op+1,col,a+'(',ans);
      
        check(n,op,col+1,a+')',ans);
    }
}