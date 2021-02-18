/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
const rangeSumBST = function(root, low, high) {
  let sum = 0;
  const stock = [root];
  
  while(stock.length > 0) {
      const node = stock.shift();
      
      if(!node) continue;
      
      if(node.val >= low && node.val <= high) {
          sum += node.val;
          
          stock.push(node.left);
          stock.push(node.right);
      } else if(node.val < low) stock.push(node.right);
      else if(node.val > high) stock.push(node.left);
  }
  
  return sum;
};
