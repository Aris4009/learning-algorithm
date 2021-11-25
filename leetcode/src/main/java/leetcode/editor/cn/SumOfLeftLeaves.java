//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 365 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class SumOfLeftLeaves {
	public static void main(String[] args) {
		Solution solution = new SumOfLeftLeaves().new Solution();
		TreeNode root = new TreeNode(1, null, new TreeNode(2));
		System.out.println(solution.sumOfLeftLeaves(root));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 * 
	 * 左叶子定义：如果左节点不为空，且左节点没有左右孩子，那么这个节点就是左叶子。
	 */
	class Solution {
		public int sumOfLeftLeaves(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int left = sumOfLeftLeaves(root.left);
			int right = sumOfLeftLeaves(root.right);
			int n = 0;
			if (root.left != null && root.left.left == null && root.left.right == null) {
				n = root.left.val;
			}
			return left + right + n;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}