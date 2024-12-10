class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int max_len = -1;

        for (int len = 1; len <= n; ++len) {
            Map<String, Integer> freq = new HashMap<>();

            for (int i = 0; i <= n - len; ++i) {
                String sub = s.substring(i, i + len);

                boolean isSpecial = true;
                for (int j = 1; j < len; ++j) {
                    if (sub.charAt(j) != sub.charAt(0)) {
                        isSpecial = false;
                        break;
                    }
                }

                if (isSpecial) {
                    freq.put(sub, freq.getOrDefault(sub, 0) + 1);
                    if (freq.get(sub) >= 3) {
                        max_len = Math.max(max_len, len);
                    }
                }
            }
        }

        return max_len;
    }
}