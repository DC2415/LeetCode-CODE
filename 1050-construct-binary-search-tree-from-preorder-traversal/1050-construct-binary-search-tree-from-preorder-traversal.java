/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        //public static int i=0;
        return helper(preorder,Long.MAX_VALUE);
    }
    public TreeNode helper(int[] pre,long b){
        if(i==pre.length || pre[i]>b){
            return null;
        }
        TreeNode root=new TreeNode(pre[i++]);
        root.left=helper(pre,root.val);
        root.right=helper(pre,b);
        return root;
    }
}