class Solution {
    Map<String,Boolean> memo=new HashMap();
    public boolean checkValidString(String s) {
         return helper(s,0,0);
    }
    public boolean helper(String s, int i,int bal){
        if(i==s.length()){
            if(bal==0){
                return true;
            }
            return false;
        }
        if(bal<0){
            return false;
        }
        String k= bal+":"+i;
        if(memo.containsKey(k)){
            return memo.get(k);
        }
        boolean ans=false;
        if(s.charAt(i)=='('){
            ans= helper(s,i+1,bal+1);
        }else if (s.charAt(i)==')'){
            ans= helper(s,i+1,bal-1);
        }else if (s.charAt(i)=='*'){
            ans=helper(s,i+1,bal+1) || helper(s,i+1,bal-1) || helper(s,i+1,bal);
        }
        memo.put(k,ans);
        return ans;
    }
}