class Solution {
    public String longestPalindrome(String s) {
        return check(s);
    }
    public String check(String s){
        String ans="";
       int ma=Integer.MIN_VALUE;
        
        for(int i=0;i<s.length();i++){
             int cnt=1;
            if(ma<cnt){
                ma=cnt;
                System.out.print(cnt);
                cnt=0;
                ans=s.charAt(i)+"";
            }
            int j=1;
            while(i-j>=0 && i+j<s.length()){
                if(s.charAt(i-j)==s.charAt(i+j)){
                    String se=s.substring(i-j,i+j+1);
                  
                    if(ma<se.length()){ 
                        ma=se.length();
                        ans=se;
                         // System.out.print(ma);
                       
                    }
                }else{
                    break;
                }
                j++;
            }
        }
         for(double i=0.5;i<s.length();i++){
        
            double j=0.5;
            while(i-j>=0 && i+j<s.length()){
                if(s.charAt((int)(i-j))==s.charAt((int)(i+j))){
                    String se=s.substring((int)(i-j),(int)(i+j+1));
                    if(ma<se.length()){
                        ans=se;
                        //System.out.println(se);
                        ma=se.length();
                    }
                }else{
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}