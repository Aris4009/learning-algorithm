//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 288 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class MinimumAbsoluteDifferenceInBst {
	public static void main(String[] args) {
		Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		private int min = Integer.MAX_VALUE;

		private int pre = Integer.MIN_VALUE;

		public int getMinimumDifference(TreeNode root) {
			if (root == null) {
				return 0;
			}
			if (root.left == null && root.right == null) {
				return 0;
			}
			inorder(root);
			return min;
		}

		private void inorder(TreeNode node) {
			if (node == null) {
				return;
			}
			inorder(node.left);
			if (pre != Integer.MIN_VALUE) {
				int n = Math.abs(node.val - pre);
				if (n < min) {
					min = n;
				}
			}
			pre = node.val;
			inorder(node.right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}