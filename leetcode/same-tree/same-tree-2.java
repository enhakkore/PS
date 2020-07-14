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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pNodes = new LinkedList<>();
        Queue<TreeNode> qNodes = new LinkedList<>();

        pNodes.offer(p);
        qNodes.offer(q);

        while(!pNodes.isEmpty() && !qNodes.isEmpty()){
            TreeNode pChild = pNodes.poll();
            TreeNode qChild = qNodes.poll();

            if(pChild == null && qChild == null) continue;
            if(pChild == null || qChild == null) return false;

            if(pChild.val != qChild.val) return false;

            pNodes.offer(pChild.left);
            pNodes.offer(pChild.right);

            qNodes.offer(qChild.left);
            qNodes.offer(qChild.right);
        }

        return true;
    }
}
