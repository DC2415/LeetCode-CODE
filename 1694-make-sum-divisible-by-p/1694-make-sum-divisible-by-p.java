// class Solution {
//     public int minSubarray(int[] nums, int p) {
//         long summ=0;
//         for(int a: nums){
//             summ+=a;
//         }
//         System.out.println(summ);
//         if(summ%p==0){
//             return 0;
//         }
//         if(summ < p){
//             return -1;
//         }
//         HashMap<Long,Integer> map=new HashMap();
//         long tar =summ % p;
//         long sm=0;int r=0,ans=Integer.MAX_VALUE;
//         for(int i=0;i<nums.length;i++){
//             sm+=nums[i];
//            if(sm==tar){
//             ans=Math.min(ans,i-r+1);
//            }
//            long rem=sm-tar;
//            if(map.containsKey(rem)){
//                 int x=i-map.get(rem);
//                 ans=Math.min(ans,x);
//            }
//            map.put(sm,i);
//         }
//         if(ans==nums.length || ans == Integer.MAX_VALUE){
//             return -1;
//         }
//         return ans;
//     }
// }
class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long targetMod = totalSum % p;
        if (targetMod == 0) {
            return 0; 
        }

        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1); 
        long prefixSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int neededMod = (int)((prefixSum % p - targetMod + p) % p); 
            if (prefixModMap.containsKey(neededMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(neededMod));
            }

            prefixModMap.put((int)(prefixSum % p), i); 
        }

        return minLength < nums.length ?  minLength : -1;
    }
}
