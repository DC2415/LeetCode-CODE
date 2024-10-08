class Solution {
    public int minSwaps(String s) {
        Stack<Character> st= new Stack();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek()=='[' && s.charAt(i)==']'){
                st.pop();
            }else{
                st.push('[');
            }
        }
        return (st.size()+1)/2;
    }
}