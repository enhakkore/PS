class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int max = 1;
        ArrayDeque<TreeNode> stock = new ArrayDeque<>();
        root.val = 1;
        stock.offer(root);
        while(!stock.isEmpty()){
            ArrayDeque<TreeNode> level = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();

            while(!stock.isEmpty()){
                TreeNode node = stock.poll();
                if(node.left != null){
                    int val = node.val*2;
                    node.left.val = val;
                    list.add(val);
                    level.offer(node.left);
                }

                if(node.right != null){
                    int val = node.val*2+1;
                    node.right.val = val;
                    list.add(val);
                    level.offer(node.right);
                }

            }
            if(!list.isEmpty())
                max = Math.max(max, list.get(list.size()-1)-list.get(0)+1);

            stock.addAll(level);
        }

        return max;
    }
}
