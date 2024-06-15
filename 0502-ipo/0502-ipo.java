class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Max-heap to store the profits
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // Min-heap to store the projects sorted by capital required
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Populate the min-heap with all projects
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Iterate k times, selecting the best project each time
        for (int i = 0; i < k; i++) {
            // Move all projects that can be afforded to the max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }
            // If no projects can be afforded, break early
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            // Select the project with the highest profit
            w += maxProfitHeap.poll();
        }

        return w;
    }

}