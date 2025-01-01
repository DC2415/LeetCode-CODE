class Solution {
    public int maxScore(String s) {
        char[] ar= s.toCharArray();
        int ans=0,one=0,zero=0,ones=0;
        for(char q: ar){
            if(q=='1'){
                one++;
            }
        }

        for(int i=0;i<ar.length-1;i++){
            if(ar[i]=='0'){
                zero++;
            }else{
                ones++;
            }
            ans=Math.max(ans,(zero+(one-ones)));
        }
        return ans;
    }
}