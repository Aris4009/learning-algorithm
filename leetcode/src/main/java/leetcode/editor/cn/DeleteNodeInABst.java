//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
// Related Topics 树 二叉搜索树 二叉树 👍 596 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class DeleteNodeInABst {
	public static void main(String[] args) {
		Solution solution = new DeleteNodeInABst().new Solution();
		TreeNode root = new TreeNode(50, new TreeNode(30, null, new TreeNode(40)),
				new TreeNode(70, new TreeNode(60), new TreeNode(80)));
		TreeNode root2 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7)));
		TreeNode node = root2;
		solution.deleteNode(node, 3);
		System.out.println(node);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		public TreeNode deleteNode(TreeNode root, int key) {
			if (root == null) {
				return null;
			}
			return helper(root, key);
		}

		private TreeNode helper(TreeNode root, int key) {
			if (root == null) {
				return null;
			}
			if (key < root.val) {
				root.left = helper(root.left, key);
			} else if (key > root.val) {
				root.right = helper(root.right, key);
			} else {
				// root节点为需要删除的节点
				// 删除叶子节点
				TreeNode left = root.left;
				TreeNode right = root.right;
				if (left == null && right == null) {
					root = null;
				}
				if (right != null) {
					// 寻找右子树中的最小节点
//					TreeNode pre = right;
//					TreeNode cursor = right;
//					while (cursor.left != null) {
//						pre = cursor;
//						cursor = cursor.left;
//					}
//					if (pre == cursor) {
//						root.right = cursor.right;
//					} else {
//						if (cursor.right == null) {
//							pre.left = null;
//						} else {
//							pre.left = cursor.right;
//						}
//					}
//					root.val = cursor.val;
					root.val = rightMin(root);
					root.right = helper(root.right, root.val);
				} else if (left != null) {
					// 寻找左子树的最大节点
//					TreeNode pre = left;
//					TreeNode cursor = left;
//					while (cursor.right != null) {
//						pre = cursor;
//						cursor = cursor.right;
//					}
//					if (pre == cursor) {
//						root.left = cursor.left;
//					} else {
//						if (cursor.left == null) {
//							pre.right = null;
//						} else {
//							pre.right = cursor.left;
//						}
//					}
//					root.val = cursor.val;
					root.val = leftMax(root);
					root.left = helper(root.left, root.val);
				}
			}
			return root;
		}

		private int rightMin(TreeNode root) {
			root = root.right;
			while (root.left != null) {
				root = root.left;
			}
			return root.val;
		}

		private int leftMax(TreeNode root) {
			root = root.left;
			while (root.right != null) {
				root = root.right;
			}
			return root.val;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}