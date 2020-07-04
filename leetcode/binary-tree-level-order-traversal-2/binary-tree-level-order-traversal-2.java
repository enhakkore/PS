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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        ArrayDeque<TreeNode> stock = new ArrayDeque<>();

        if(root != null)
            ans.addFirst(Arrays.asList(root.val));
         else
             return ans;

        stock.offer(root);
        while(!stock.isEmpty()){
            ArrayDeque<TreeNode> stock2 = new ArrayDeque<>();
            List<Integer> val = new LinkedList<>();
            TreeNode node = stock.poll();

            while(node != null){

                if(node.left != null){
                    stock2.offer(node.left);
                    val.add(node.left.val);
                }

                if(node.right != null){
                    stock2.offer(node.right);
                    val.add(node.right.val);
                }

                node = stock.poll();
            }

            if(!val.isEmpty())
                    ans.addFirst(val);

            stock.addAll(stock2);
        }

        return ans;
    }
}
