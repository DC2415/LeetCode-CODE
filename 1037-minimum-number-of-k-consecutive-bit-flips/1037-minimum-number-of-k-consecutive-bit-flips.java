class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length, flip = 0, res = 0;
        int[] isFlip = new int[n];
        for (int i = 0; i < nums.length; ++i) {
            if (i >= k)
                flip ^= isFlip[i - k];
                if (flip == nums[i]) {
                    if (i + k > nums.length)
                        return -1;
                isFlip[i] = 1;
                flip ^= 1;
                res++;
            }
        }
        return res;
    }
}