//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 609 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		Solution solution = new RecoverBinarySearchTree().new Solution();
		TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
		solution.recoverTree(root);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		private TreeNode cur = new TreeNode(Integer.MIN_VALUE);

		private TreeNode m;

		private TreeNode n;

		public void recoverTree(TreeNode root) {
			if (root == null) {
				return;
			}
			helper(root);
			int t = m.val;
			m.val = n.val;
			n.val = t;
		}

		private void helper(TreeNode node) {
			if (node == null) {
				return;
			}
			helper(node.left);
			if (cur.val > node.val && m == null) {
				m = cur;
			}
			if (cur.val > node.val && m != null) {
				n = node;
			}
			cur = node;
			helper(node.right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}