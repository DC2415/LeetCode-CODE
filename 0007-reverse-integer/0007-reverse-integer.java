class Solution {
    public int reverse(int x) {
        int ans=0;
       int  flag =0;
       int a=x;
        if(x<0){
            a=Math.abs(x);
        flag=1;
        }
        while(a!=0){
            int rem =a %10;
             if (ans > (Integer.MAX_VALUE - rem) / 10) {
                return 0; // Overflow check
            }
         
            // System.out.println(rem);
            ans=ans*10;
            // if(ans>Math.pow(2,31)-1 || ans<Math.pow(-2,31)){
            // return 0;
            //  }
            ans+=rem;
            // System.out.println(ans);
            a=a/10;
            // System.out.println(a);
        }
        // System.out.println(ans);
        if(flag==1){
            return -(ans);
        }
        
        return ans;
    }
}