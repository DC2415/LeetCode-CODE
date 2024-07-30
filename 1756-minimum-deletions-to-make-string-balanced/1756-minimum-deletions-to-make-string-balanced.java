class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st=new Stack();
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(! st.isEmpty() ){
                if(st.peek()=='b' && s.charAt(i)=='a'){
                    st.pop();
                    ans+=1;
                }else{
                    st.push(s.charAt(i));
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return ans;
    }
}