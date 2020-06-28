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
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        findDepth(root);
        return result;
    }

    public int findDepth(TreeNode node){
        if(node.left == null && node.right == null) return 1;

        int tl = 1, tr = 1;

        if(node.left != null) tl += findDepth(node.left);
        if(node.right != null) tr += findDepth(node.right);

        boolean midRs = Math.abs(tl-tr) <= 1 ? true : false;
        result &= midRs;

        return Math.max(tl,tr);
    }
}
