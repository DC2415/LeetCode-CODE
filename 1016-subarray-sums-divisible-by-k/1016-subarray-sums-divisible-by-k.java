// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int r = 0, c = 0, sum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//             if (sum % k == 0) {
//                 c++;
//             }
//             int remp = sum;
//             while(r<i && remp>=k) {
//                 remp -= nums[r++];
//                 if (remp % k == 0) {
//                     c++;
//                 }
//             }
//         }
//         return c;
//     }
// }
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int c = 0, sum = 0;
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1); 
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = ((sum % k) + k) % k; 
            if (remainderMap.containsKey(remainder)) {
                c += remainderMap.get(remainder);
            }
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }
        return c;
    }
}
