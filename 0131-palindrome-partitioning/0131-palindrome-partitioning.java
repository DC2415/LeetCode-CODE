class Solution {
    public boolean palindrome(String s, int i, int j){
        int l=i,r=j;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false ;
            }
            l++;
            r--;
        }
        return true;
    }
    public void check(int ind,String s ,List<String> ds,List<List<String>> ans){
        if(ind>=s.length()){
            ans .add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind ;i<s.length();i++){
            if(palindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                check(i+1,s,ds,ans);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<String> ds =new ArrayList<>();
        List<List<String>> ans =new ArrayList<>();
        check(0,s,ds,ans);
        return ans;
    }
}