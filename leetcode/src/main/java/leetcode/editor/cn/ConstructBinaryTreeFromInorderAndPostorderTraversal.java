//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 628 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public static void main(String[] args) {
		Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		solution.buildTree(inorder, postorder);
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

		public TreeNode buildTree(int[] inorder, int[] postorder) {
			map = new HashMap<>();
			int n = inorder.length;
			for (int i = 0; i < n; i++) {
				map.put(inorder[i], i);
			}
			TreeNode root = helper(inorder, postorder, 0, n - 1, 0, n - 1);
			return root;
		}

		private TreeNode helper(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
			if (postLeft < 0 || postRight < 0 || postLeft > postRight) {
				return null;
			}
			int rootVal = postorder[postRight];
			TreeNode root = new TreeNode(rootVal);
			// 中序遍历根节点索引
			int inorderRootIndex = map.get(rootVal);

			// 中序遍历左子树节点数量
			int inorderLeftSize = inorderRootIndex - inLeft;
			int inorderRightSize = inRight - inorderRootIndex;

			root.left = helper(inorder, postorder, inLeft, inorderRootIndex - 1, postLeft,
					postLeft + inorderLeftSize - 1);
			root.right = helper(inorder, postorder, inorderRootIndex + 1, inRight, postRight - inorderRightSize,
					postRight - 1);
			return root;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}