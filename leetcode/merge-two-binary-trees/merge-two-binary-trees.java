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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


// 처음시도했던 방법....
//     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//         return merge(t1, t2);
//     }

//     public static TreeNode merge(TreeNode t1, TreeNode t2){
//         if(t1 == null && t2 == null) return null;

//         int val = 0;

//         if(t1 != null) val += t1.val;
//         if(t2 != null) val += t2.val;

//         TreeNode tn = new TreeNode(val);
        
//         if(t1 != null && t2 != null){
//             tn.left = merge(t1.left, t2.left);
//             tn.right = merge(t1.right, t2.right);
//         } else if(t1 != null){
//             tn.left = merge(t1.left, t2);
//             tn.right = merge(t1.right, t2);
//         } else if(t2 != null){
//             tn.left = merge(t1, t2.left);
//             tn.right = merge(t1, t2.right);
//         }

//         return tn;
//     }
}
