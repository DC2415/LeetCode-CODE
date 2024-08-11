class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //    int[] ans= new int[nums1.length];
    //    //for(int u=0)
    //    for (int i=0 ;i<nums1.length;i++){
    //        ans[i]=-1;
    //        for(int j=0;j<nums2.length-1;j++){
    //            if(nums1[i]==nums2[j] && nums1[i]<nums2[j+1]){
    //                ans[i]=nums2[j+1];
    //            }
    //        }
    //        }
    //    return ans;

        for(int i=0; i<nums1.length; i++){
            int key = 0;
            int max = nums1[i];
            for(int j=0; j<nums2.length; j++){
                if(nums1[i]==nums2[j]){
                    key = 1;
                }
                if(key == 1 && nums1[i]<nums2[j]){
                    nums1[i] = nums2[j];
                    break;
                }
            }
            if(nums1[i]==max){
                nums1[i]=-1;
            }
        }
        return nums1;
    }
}