class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count the occurrences of each element in arr1
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int i = 0;
        
        // Place elements of arr2 in arr1 according to their order and frequency in arr2
        for (int num : arr2) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                for (int j = 0; j < count; j++) {
                    arr1[i++] = num;
                }
                map.remove(num);
            }
        }
        
        // Place remaining elements not in arr2, sorted in ascending order
        int[] remainingElements = new int[arr1.length - i];
        int k = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            for (int j = 0; j < count; j++) {
                remainingElements[k++] = key;
            }
        }
        Arrays.sort(remainingElements);
        
        for (int num : remainingElements) {
            arr1[i++] = num;
        }
        
        return arr1;
    }
}
