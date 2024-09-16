class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> ds= new HashSet();
        int ans1=-1,ans2=-1;
        for(int i=0;i<nums.length;i++){
            if(ds.contains(nums[i])){
                if(ans1 < 0){
                    ans1=nums[i];
                }else{
                    ans2=nums[i];
                }
            }else{
                ds.add(nums[i]);
            }
        }
        return new int[]{ans1,ans2};
    }
}