class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans =new ArrayList<>();
        int ele1=0,ele2=0,c1=0,c2=0;
        for(int i=0;i<nums.length;i++){
            if(c1==0 && ele2!=nums[i]){
                c1=1;
                ele1=nums[i];
            }
           else if(c2==0 && ele1!=nums[i]){
                c2=1;
                ele2=nums[i];
            }else if(nums[i]==ele1){
                c1++;
            }
            else if(nums[i]==ele2){
              c2++;}else{
                c1--;c2--;
              }
                      
        } 
        int s=0,a=0;
        for( int i=0; i<nums.length;i++){
            if(nums[i]==ele1){
                s++;
            }
            if(nums[i]==ele2){
                a++;
            }
        }
        if(s>=nums.length/3+1){
            ans.add(ele1);
        }
        if(a>=nums.length/3 +1 && ele1!=ele2){
            ans.add(ele2);
        }
        return ans;
    }
}