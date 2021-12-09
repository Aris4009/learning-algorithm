//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1325 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import leetcode.editor.cn.my.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
		solution.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		private Map<Integer, Integer> map;

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			int n = inorder.length;
			map = new HashMap<>(n);
			for (int i = 0; i < n; i++) {
				map.put(inorder[i], i);
			}
			return helper(preorder, inorder, 0, n - 1, 0, n - 1);
		}

		private TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
			if (preLeft > preRight) {
				return null;
			}
			int inRoot = map.get(preorder[preLeft]);
			// 根节点
			TreeNode root = new TreeNode(preorder[preLeft]);
			int leftSubTreeSize = inRoot - inLeft;
			root.left = helper(preorder, inorder, preLeft + 1, preLeft + leftSubTreeSize, inLeft, inRoot - 1);
			root.right = helper(preorder, inorder, preLeft + leftSubTreeSize + 1, preRight, inRoot + 1, inRight);
			return root;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}