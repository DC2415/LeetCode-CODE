class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);
    }
    public List<Integer> helper(String s){
        List<Integer> ans =new ArrayList();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*' || s.charAt(i)=='-' || s.charAt(i)=='+'){
                List<Integer> ls=helper(s.substring(0,i));
                List<Integer> rs=helper(s.substring(i+1,s.length()));
                for(int a : ls){
                    for(int b : rs){
                        if(s.charAt(i)=='+'){
                            ans.add(a+b);
                        }else if(s.charAt(i)=='*'){
                            ans.add(a*b);
                        }else{
                            ans.add(a-b);
                        }
                    }
                }
                
            }
        }
        if(ans.isEmpty()){
            ans.add(Integer.parseInt(s));
        }
        return ans;
    }
}