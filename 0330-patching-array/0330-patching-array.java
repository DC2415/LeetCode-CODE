// class Solution {
//     public int minPatches(int[] nums, int n) {
//         int sum=0;
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
//             if(map.containsKey(nums[i])){
//                 map.put(nums[i],map.get(nums[i])+1);
//             }else{
//                 map.put(nums[i],1);
//             }
//         }
//         int ans=0;
//         for(int j=1;j<n;j++){
//             if(map.containsKey(j)){
//                 continue;
//             }else{
//                 if(sum+j<=n){
//                     sum+=j;
//                     ans+=1;
//                 }
//             }
//         }
//         return ans;

        

//     }
// }
class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;  // the smallest number that cannot be formed
        int patches = 0, i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }
}
