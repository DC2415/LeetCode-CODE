class Solution {
    public int minOperations(int n) {
       int ans=0;
       for(int i=0;i<n;i++){
        if((i*2)+1 >= n){
            break;
        }else{
            ans+=n-((i*2)+1);
        }
       }
       return ans;
    }
}