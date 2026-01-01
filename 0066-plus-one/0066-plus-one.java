class Solution {
    public int[] plusOne(int[] digits) {
        int []ans =new int[digits.length+1];
        // if(digits[0]==9){
        //    ans[0]=1;
        //    for(int i=1 ;i<digits.length+1;i++){
        //        ans[i]=0;
        //    } 
        //    return ans; 
        // }
        // if(digits[digits.length-1]<9){
        //     int x= digits[digits.length-1]+1;
        //     digits[digits.length-1]=x;
        //     return digits;
        // }
        // for(int i=0 ;i<digits.length;i++){
        //     if(digits[i]==9 && digits.length > 1){
        //        int x= digits[i-1]+1;
        //        digits[i-1]=x;
        //        break;
        //     }
        // }
        // for(int i=1 ;i<digits.length;i++){
        //     if(digits[i]==9){
        //        digits[i]=0;
        //        //break;
        //     }
        // }
        // return digits;
        for(int i= digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }
            else{
                digits[i]+=1;
                return digits;
            }
        }
        ans[0]=1;
        return ans;
    }

}