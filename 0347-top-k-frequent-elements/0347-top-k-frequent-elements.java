import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min-heap with custom comparator to maintain top k elements
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(new Pair(entry.getKey(), entry.getValue()));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Extracting top k elements
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll().key;
        }

        return ans;
    }
}
    // Pair class to hold the key and value
    class Pair {
        int key;
        int val;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
        }