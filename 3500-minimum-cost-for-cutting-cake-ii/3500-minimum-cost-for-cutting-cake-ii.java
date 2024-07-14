class Solution {
    public long minimumCost(int m, int n, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);
        long ans = 0;
        int hor = 1, ver = 1;
        int i = h.length - 1, j = v.length - 1;
        while (i >= 0 && j >= 0) {
            if (h[i] > v[j]) {
                ans += (long) h[i] * ver;
                hor++;
                i--;
            } else {
                ans += (long) v[j] * hor;
                ver++;
                j--;
            }
        }
        while (i >= 0) {
            ans += (long) h[i] * ver;
            i--;
        }
        while (j >= 0) {
            ans += (long) v[j] * hor;
            j--;
        }

        return ans;
    }
}