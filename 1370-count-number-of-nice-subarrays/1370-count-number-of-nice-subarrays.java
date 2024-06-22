class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixCounts = new int[n + 1];
        prefixCounts[0] = 1; // Base case: there's one way to have zero odds initially
        int oddCount = 0, result = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                oddCount++;
            }
            if (oddCount >= k) {
                result += prefixCounts[oddCount - k];
            }
            prefixCounts[oddCount]++;
        }

        return result;
    }
}
