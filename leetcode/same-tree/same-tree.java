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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<Integer> pVal = new ArrayDeque<>();
        ArrayDeque<Integer> qVal = new ArrayDeque<>();

        collectVal(p, pVal);
        collectVal(q, qVal);

        if(pVal.size() != qVal.size()) return false;

        while(pVal.size() > 0){
            if(pVal.removeLast().intValue() != qVal.removeLast().intValue())
                return false;
        }

        return true;
    }

    public void collectVal(TreeNode n, ArrayDeque<Integer> stock){
        if(n == null) {
            stock.addFirst(Integer.MAX_VALUE);
            return ;
        }

        stock.addFirst(n.val);
        collectVal(n.left, stock);
        collectVal(n.right, stock);
    }
}
