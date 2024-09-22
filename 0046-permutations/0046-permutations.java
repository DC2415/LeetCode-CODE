class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Boolean freq[] =new Boolean[nums.length];
        Arrays.fill(freq,false);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        check(nums,ds,ans,freq);
        return ans;
    }
    public void check(int[] nums,List<Integer> ds,List<List<Integer>>ans,Boolean[] freq){

        if(ds.size()==nums.length){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                check(nums,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}