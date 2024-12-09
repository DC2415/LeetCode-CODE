class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        
        if (n == 1) {
            boolean[] ans = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = true;
            }
            return ans;
        }
        
        int[] same = new int[n];
        for (int i = 1; i < n; i++) {
            same[i] = same[i - 1] + ((nums[i] % 2) == (nums[i - 1] % 2) ? 1 : 0);
        }
        
        boolean[] ans = new boolean[queries.length];
        
        for (int q = 0; q < queries.length; q++) {
            int s = queries[q][0];
            int e = queries[q][1];
            int ParityCount = same[e] - same[s];
            ans[q] = (ParityCount == 0);
        }
        
        return ans;
    }
}
