class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb=new StringBuilder(s);
        int ans=0;
        if(x>y){
           ans+=remove(sb,"ab",x);
           ans+=remove(sb,"ba",y);
           
        }else{
               ans+=remove(sb,"ba",y);
           ans+=remove(sb,"ab",x);
            }
        
        return ans;
    }
      public int remove(StringBuilder sb, String sub, int score) {
        int totalScore = 0;
        Stack<Character> st=new Stack();
        for(int i=0;i<sb.length();i++){
            if(st.isEmpty()){
                st.push(sb.charAt(i));
            }else if(st.peek()==sub.charAt(0) && sb.charAt(i)==sub.charAt(1)){
                totalScore+=score;
                st.pop();
            }else{
                st.push(sb.charAt(i));
            }
        }
         sb.setLength(0);
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
      //  sb=r;
        return totalScore;
    }
}