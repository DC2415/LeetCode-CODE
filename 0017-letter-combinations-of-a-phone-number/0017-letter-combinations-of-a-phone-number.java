class Solution {
    public void solve(int ind,String digits,StringBuilder output,String[] map,List<String> ans){
        // base case
        if(ind>=digits.length()){
            ans.add(output.toString());
            return;
        }
        int val=(digits.charAt(ind)-'0');
        String no=map[val];
       
        for(int i=0;i<no.length();i++){
            output.append(no.charAt(i));
            solve(ind+1,digits,output,map,ans);
            output.deleteCharAt(output.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        String[] map=new String[10];
        map[0]=" ";
        map[1]="";
        map[2]="abc";
       map[3]="def";
        map[4]="ghi";
        map[5]="jkl";
        map[6]="mno";
        map[7]="pqrs";
          map[8]="tuv";
          map[9]="wxyz";
          StringBuilder output=new StringBuilder();
          solve(0,digits,output,map,ans);
        return ans;
    }
}