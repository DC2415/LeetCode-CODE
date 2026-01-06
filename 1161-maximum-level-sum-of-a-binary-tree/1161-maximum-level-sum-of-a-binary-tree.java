class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1, ans = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int levelQSize = q.size();
            int levSum = 0;

            for (int i = 0; i < levelQSize; i++) {
                TreeNode curr = q.poll();
                levSum += curr.val;

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }

            if (maxSum < levSum) {
                maxSum = levSum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}
