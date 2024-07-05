class Solution {
    public void nextPermutation(int[] nums) {
      int ind  = -1, n =nums.length;
      for ( int i=n-2;i>=0;i--){
          if(nums[i]<nums[i+1]){
              ind =i;
              break;
          }
      }
      if(ind ==-1){
          reverse(nums,0,n-1);
      }
      else{
          for (int j=n-1;j>ind;j--){
              if(nums[j]>nums[ind]){
                  int temp =nums[j];
                  nums[j]=nums[ind];
                  nums[ind]=temp;
                  break;
              }
          }
          reverse(nums,ind+1,n-1);
      }
    }
    public static void reverse(int[] arr, int start,int end){
        while(start <=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}