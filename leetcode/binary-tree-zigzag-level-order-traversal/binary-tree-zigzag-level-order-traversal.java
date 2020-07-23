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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        int level = 1;
        Map<Integer, LinkedList<Integer>> stock = new HashMap<>();

        walker(root, level, stock);

        while(stock.containsKey(level)){
            ans.add(stock.get(level));
            level++;
        }

        return ans;
    }

    public void walker(TreeNode node, int level, Map<Integer, LinkedList<Integer>> stock){
        LinkedList<Integer> list = stock.getOrDefault(level, new LinkedList<>());

        if(level % 2 == 0)
            list.addFirst(node.val);
        else
            list.addLast(node.val);

        stock.put(level, list);

        if(node.left != null)
            walker(node.left, level+1, stock);

        if(node.right != null)
            walker(node.right, level+1, stock);
    }
}
