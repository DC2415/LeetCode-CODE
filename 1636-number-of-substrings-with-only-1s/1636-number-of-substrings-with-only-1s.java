class Solution {
    public int numSub(String s) {
      return countSubstrings(s);
    }
    int countSubstrings(String s) {
    final int MOD = 1_000_000_007;
    long ans = 0;
    String[] segments = s.split("0"); 
    for (String seg : segments) {
        int len = seg.length();
        if (len > 0) {
            ans = (ans + (long) len * (len + 1) / 2) % MOD;
        }
    }
    return (int) ans;
}
}