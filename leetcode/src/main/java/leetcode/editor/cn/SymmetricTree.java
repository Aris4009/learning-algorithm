//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1609 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class SymmetricTree {
	public static void main(String[] args) {
		Solution solution = new SymmetricTree().new Solution();
		TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		System.out.println(solution.isSymmetric(treeNode));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null) {
				return true;
			}
			TreeNode left = root.left;
			TreeNode right = root.right;
			return code(left, right);
		}

		public boolean code(TreeNode left, TreeNode right) {
			if (left == null && right == null) {
				return true;
			}
			if (left == null || right == null) {
				return false;
			}
			if (left.val != right.val) {
				return false;
			}
			return code(left.left, right.right) && code(left.right, right.left);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}