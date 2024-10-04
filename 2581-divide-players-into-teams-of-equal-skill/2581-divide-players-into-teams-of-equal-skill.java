class Solution {
    public long dividePlayers(int[] skills) {
        Arrays.sort(skills);
        int sum=skills[0]+skills[skills.length-1];long ans=0;
        for(int i=0;i<skills.length/2;i++){
            int s=skills[i]+skills[skills.length-i-1];
            if(s==sum){
                ans+=(skills[i]*skills[skills.length-i-1]);
            }else{
                return -1;
            }
        }
        return ans;
    }
}