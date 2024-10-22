class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int si = qu.size();
            long sum = 0;  
            for (int i = 0; i < si; i++) {
                TreeNode s = qu.poll();  
                sum += s.val;          
                if (s.left != null) {
                    qu.add(s.left);
                }
                if (s.right != null) {
                    qu.add(s.right);
                }
            }
            minheap.add(sum);
        if(minheap.size()>k)
        minheap.poll();
    }    
      return minheap.size()<k ? -1 : minheap.peek(); 
    }
}
