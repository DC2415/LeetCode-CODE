class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
         int n = nums.length;
        if (n % k != 0) {
            return false;
        }
        int loop1 = n / k;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < loop1; i++) {
            int x = map.firstKey();
            for (int j = 0; j < k; j++) {
                if (!map.containsKey(x + j)) {
                    return false;
                }
                map.put(x + j, map.get(x + j) - 1);
                if (map.get(x + j) == 0) {
                    map.remove(x + j);
                }
            }
        }
        return true;
    }
}