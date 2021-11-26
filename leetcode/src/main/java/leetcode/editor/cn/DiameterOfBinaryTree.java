//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 👍 837 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		Solution solution = new DiameterOfBinaryTree().new Solution();
		TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
		System.out.println(solution.diameterOfBinaryTree(node));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		int max = 0;

		public int diameterOfBinaryTree(TreeNode root) {
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
			int right = helper(node.right);
			max = Math.max(max, left + right);
			return Math.max(left, right) + 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}