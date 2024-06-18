// class Solution {
//     public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//         int i=1,ans=0;
//         int j=0;
//         while(j<worker.length){
//             if(difficulty[i] < worker[j]){
//                 i++;
//                 continue;
//             }else if (difficulty[i] == worker[j]){
//                 j++;
//                 ans+=profit[i];
//             }
//             else{
//                 if(difficulty[i-1] <= worker[j]){
//                     ans+=profit[i-1];
//                     j++;
//                 }else{
//                 j++;}
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int i = 0, ans = 0;
        int j = 0, m=0;
        
        // Sorting the difficulty and profit arrays based on difficulty
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int k = 0; k < n; k++) {
            jobs[k][0] = difficulty[k];
            jobs[k][1] = profit[k];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sorting workers
        Arrays.sort(worker);
        
        while (j < worker.length) {
            while (i < n && jobs[i][0] <= worker[j]) {
               m=Math.max(m,jobs[i][1]);
                i++;
            }
            if (i == 0) {
                j++;
                continue;
            }
            ans += m;
            j++;
        }
        return ans;
    }
}
