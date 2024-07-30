class Solution {
    // using stack
    // public int minimumDeletions(String s) {
    //     Stack<Character> st=new Stack();
    //     int ans=0;
    //     for(int i=0;i<s.length();i++){
    //         if(! st.isEmpty() ){
    //             if(st.peek()=='b' && s.charAt(i)=='a'){
    //                 st.pop();
    //                 ans+=1;
    //             }else{
    //                 st.push(s.charAt(i));
    //             }
    //         }
    //         else{
    //             st.push(s.charAt(i));
    //         }
    //     }
    //     return ans;
    // }

    // without using stack 
     public int minimumDeletions(String s) {
        int right_a=0;
        int left_b=0;
        for(int a =0;a<s.length();a++){
            if(s.charAt(a)=='a'){
                right_a++;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                right_a--;
                ans=Math.min(ans,right_a+left_b);
            }else{
                ans=Math.min(ans,right_a+left_b);
                left_b++;
            }
        }
        return ans;
    }
}