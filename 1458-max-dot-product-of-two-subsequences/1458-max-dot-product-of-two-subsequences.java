class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return solve(0, 0, nums1, nums2, dp);
    }

    public int solve(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i >= nums1.length || j >= nums2.length) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int takeBoth =
                nums1[i] * nums2[j] +
                Math.max(0, solve(i + 1, j + 1, nums1, nums2, dp));

        int skipNums1 = solve(i + 1, j, nums1, nums2, dp);
        int skipNums2 = solve(i, j + 1, nums1, nums2, dp);

        dp[i][j] = Math.max(takeBoth, Math.max(skipNums1, skipNums2));
        return dp[i][j];
    }
}
