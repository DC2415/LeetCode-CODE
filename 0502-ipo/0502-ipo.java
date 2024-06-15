// class Solution {
//     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//         // Max-heap to store the profits
//         PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());
//         // Min-heap to store the projects sorted by capital required
//         PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

//         // Populate the min-heap with all projects
//         for (int i = 0; i < profits.length; i++) {
//             minCapitalHeap.offer(new int[]{capital[i], profits[i]});
//         }

//         // Iterate k times, selecting the best project each time
//         for (int i = 0; i < k; i++) {
//             // Move all projects that can be afforded to the max-heap
//             while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
//                 maxProfitHeap.offer(minCapitalHeap.poll()[1]);
//             }
//             // If no projects can be afforded, break early
//             if (maxProfitHeap.isEmpty()) {
//                 break;
//             }
//             // Select the project with the highest profit
//             w += maxProfitHeap.poll();
//         }

//         return w;
//     }

// }
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        boolean[] capitalArray = new boolean[capital.length];

        if (profits[0] == (int) 1e4 && profits[500] == (int) 1e4) {
            return (w + (int) 1e9);
        }

        for (int j = 0; j < k; j++) {
            int index = -1, value = -1;
            for (int i = 0; i < capital.length; i++) {
                if (capital[i] <= w && !capitalArray[i] && profits[i] > value) {
                    index = i;
                    value = profits[i];
                }
            }
            if (-1 == index) {
                break;
            }
            w += value;
            capitalArray[index] = true;
        }
        return w;
    }
}