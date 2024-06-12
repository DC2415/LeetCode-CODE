class Solution {
    public void sortColors(int[] nums) {
        int low =0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(low,mid,nums);
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(mid,high,nums);
                    high--;   
            }
        }
    }
    public static void swap(int a,int b,int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}