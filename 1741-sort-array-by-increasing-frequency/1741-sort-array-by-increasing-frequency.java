import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list from elements of the hashmap
        List<Map.Entry<Integer, Integer>> listOfEntry = new ArrayList<>(map.entrySet());

        // Step 3: Sort the list based on frequency (ascending) and then value (descending)
        Collections.sort(listOfEntry, (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o2.getKey() - o1.getKey(); // descending order of values
            }
            return o1.getValue() - o2.getValue(); // ascending order of frequencies
        });

        // Step 4: Build the result array based on the sorted list
        int[] result = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : listOfEntry) {
            int count = entry.getValue();
            int num = entry.getKey();
            for (int i = 0; i < count; i++) {
                result[index++] = num;
            }
        }

        return result;
    }

    
}
