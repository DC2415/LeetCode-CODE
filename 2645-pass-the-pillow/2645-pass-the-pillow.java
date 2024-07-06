class Solution {
    public int passThePillow(int n, int time) {
      int  ans=0;
        if(n>time){
            return time+1;
        }
        ans=time/(n-1);
        if (ans%2==0){
            return time%(n-1)+1;
        }
      return  n- (time%(n-1));
    }
}