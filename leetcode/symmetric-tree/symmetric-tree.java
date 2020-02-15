/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;

        if(leftRoot == null && rightRoot == null) return true;
        else if(leftRoot == null || rightRoot == null) return false;

        ArrayDeque<Integer> leftVals = new ArrayDeque<>();
        ArrayDeque<Integer> rightVals = new ArrayDeque<>();

        leftFirst(leftRoot, leftVals);
        rightFirst(rightRoot, rightVals);

        if(leftVals.size() != rightVals.size()) return false;

        while(leftVals.size() > 0){
            if(leftVals.removeLast().intValue() != rightVals.removeLast().intValue())
                return false;
        }

        return true;

    }

    public void leftFirst(TreeNode node, ArrayDeque<Integer> stock){
        if(node == null) {
            stock.addFirst(Integer.MAX_VALUE);
            return;
        }

        stock.addFirst(node.val);
        leftFirst(node.left, stock);
        leftFirst(node.right, stock);

    }

    public void rightFirst(TreeNode node, ArrayDeque<Integer> stock){
        if(node == null) {
            stock.addFirst(Integer.MAX_VALUE);
            return;
        }

        stock.addFirst(node.val);
        rightFirst(node.right, stock);
        rightFirst(node.left, stock);
    }
}
