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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return findMaxDepth(root);
    }

    public int findMaxDepth(TreeNode node){

        if(node.left == null && node.right == null) return 1;

        int tl = 1, tr = 1;

        if(node.left != null) tl += findMaxDepth(node.left);
        if(node.right != null) tr += findMaxDepth(node.right);

        return Math.max(tl, tr);
    }
}
