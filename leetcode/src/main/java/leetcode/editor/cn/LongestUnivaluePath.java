//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 深度优先搜索 二叉树 👍 522 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class LongestUnivaluePath {
	public static void main(String[] args) {
		Solution solution = new LongestUnivaluePath().new Solution();
		TreeNode node = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)),
				new TreeNode(5, null, new TreeNode(5)));
		TreeNode node2 = new TreeNode(1, new TreeNode(1, new TreeNode(1), null), null);
		int m = solution.longestUnivaluePath(node2);
		System.out.println(m);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		private int max;

		public int longestUnivaluePath(TreeNode root) {
			if (root == null) {
				return 0;
			}
			helper(root);
			return max;
		}

		private int helper(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int left = helper(node.left);
			int m = 0;
			if (node.left != null && node.val == node.left.val) {
				m = m + left + 1;
			}
			int right = helper(node.right);
			int n = 0;
			if (node.right != null && node.val == node.right.val) {
				n = n + right + 1;
			}
			max = Math.max(max, m + n);
			return Math.max(m, n);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}