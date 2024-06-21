import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair> Heap = new PriorityQueue<>(
                (a, b) -> a.val == b.val ? a.name.compareTo(b.name) : b.val - a.val
        );

        for (String word : map.keySet()) {
            Heap.add(new Pair(word, map.get(word)));
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(Heap.poll().name);
        }
        
        return ans;
    }

    class Pair {
        String name;
        int val;

        public Pair(String name, int val) {
            this.name = name;
            this.val = val;
        }
    }
}
