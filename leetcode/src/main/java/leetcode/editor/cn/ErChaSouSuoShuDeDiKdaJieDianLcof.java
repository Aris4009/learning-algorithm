//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 220 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args){
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        TreeNode root = new TreeNode(3,new TreeNode(1,null,new TreeNode(2)),new TreeNode(4));
        System.out.println(solution.kthLargest(root,1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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

    private int k;

    private int n;

    private int index;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return n;
    }

    private void helper(TreeNode node){
        if (node==null){
            return;
        }
        if (index<k){
            helper(node.right);
            if (index<k){
                n = node.val;
            }
            this.index ++;
            helper(node.left);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}