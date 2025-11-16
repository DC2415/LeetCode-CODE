class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans =new int[nums.length];
        int c=0,i=0,j=n;

        while(c<nums.length){
            if(c%2==0){
            ans[c]=nums[i];
            i++;}else{
                ans[c]=nums[j];
                j++;
            }
            c++;
        }
        return ans;
    }
}