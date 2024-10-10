class Solution {
    public int maxWidthRamp(int[] nums) {
        int maxi=0;
        Stack<Integer>  st=new Stack();
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty() || nums[st.peek()]>=nums[i]){
                st.push(i);
            }
        }
        for(int j=nums.length-1;j>=0;j--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[j]){
                maxi=Math.max(maxi,j-st.pop());
            }
            if(st.isEmpty()){
                break;
            }
        }
        return maxi;
    }
}