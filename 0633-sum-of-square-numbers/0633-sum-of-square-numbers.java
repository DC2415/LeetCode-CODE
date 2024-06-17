class Solution {
    public boolean judgeSquareSum(int c) {
        int i=0;
        int j=(int)(Math.sqrt(c));
        while(i<=j){
            long a= (long)(i*i)+(long)(j*j);
            if(a==c){
                return true;
            }else if(a>c){
            j--;}else{
            i++;}
        }
        return false;
    }
}