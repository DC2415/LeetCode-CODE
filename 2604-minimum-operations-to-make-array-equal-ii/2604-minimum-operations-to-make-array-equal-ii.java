class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != nums2[i]) {
                    return -1;
                }
            }
            return 0;
        }
        
        long positiveDiff = 0;  // Total increments needed
        long negativeDiff = 0;  // Total decrements needed
        
        for (int i = 0; i < nums1.length; i++) {
            int diff = nums1[i] - nums2[i];
            if (diff % k != 0) {
                return -1;  // If diff is not divisible by k, it's impossible to equalize them
            }
            if (diff > 0) {
                negativeDiff += diff / k;
            } else if (diff < 0) {
                positiveDiff += -diff / k;
            }
        }
        
        // To make nums1 equal to nums2, total positive and negative adjustments must be the same
        if (positiveDiff == negativeDiff) {
            return positiveDiff;
        } else {
            return -1;
        }
    }
}
