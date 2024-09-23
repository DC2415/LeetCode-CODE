class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        // int rever;
        int ans=0;
        if(x<0){
            return false;
        }
        while(temp>0){
            int last=temp%10;
            ans= ans*10+ last;
            temp=temp/10;
        }
        if (x== ans){
            return true;
        }
        else{
            return false;
        }
}
}