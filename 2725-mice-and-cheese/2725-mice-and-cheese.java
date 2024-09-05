// class Solution {
//     public int miceAndCheese(int[] reward1, int[] reward2, int k) {
//       Arrays.sort(reward1);
//       PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)-> b-a);
  
//     int i=0,ans=0;
//     for(i=0;i<k;i++){
//         ans+=reward1[reward1.length-1-i];
//     }
//     int n = reward2.length;
//     while (n > k && !maxheap.isEmpty()) {
//             ans += maxheap.poll();
//     //        System.out.println("Added from reward2 (max heap): " + ans);
//             n--;
//         }
//         return ans;
//         }
// }
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[][] r1 = new int[n][2];
        // storing the indices along with the differences
        // because we'll need to fetch the reward using the indices
        // from the two given arrays
        for (int i = 0; i < n; i++) {
            r1[i] = new int[] {reward1[i] - reward2[i], i};
        }
        
        // sort on the basis of difference (in descending order)
        Arrays.sort(r1, (a, b) -> b[0] - a[0]);
        int reward = 0;
        
        // feed the first top 'k' rewarding cheese to the first mouse
        for (int i = 0; i < k; i++) {
            reward += reward1[r1[i][1]];
        }
        // feed the leftover to the second mouse
        for (int i = k; i < n; i++) {
            reward += reward2[r1[i][1]];
        }
        
        return reward;
    }
}