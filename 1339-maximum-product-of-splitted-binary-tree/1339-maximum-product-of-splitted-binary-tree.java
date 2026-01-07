class Solution {
    long totalSum;
    long maxProduct = 0;
    int mod = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = maxSum(root);   
        maxProd(root);              
        return (int)(maxProduct % mod);
    }
    private long maxProd(TreeNode root) {
        if (root == null) return 0;

        long left = maxProd(root.left);
        long right = maxProd(root.right);

        long subtree = root.val + left + right;

        maxProduct = Math.max(
            maxProduct,
            subtree * (totalSum - subtree)
        );

        return subtree;
    }

    private long maxSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + maxSum(root.left) + maxSum(root.right);
    }
}
