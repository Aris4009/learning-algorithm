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

import java.util.HashMap;
import java.util.Map;

import leetcode.editor.cn.my.TreeNode;

/**
 * 中序 [8,4,9,2,5,10,1,11,6,3,7] m int left int right
 *
 * left=0 right=10 rootIndex = 6
 *
 * [[8,4,9,2,5,10],[1],[11,6,3,7]]
 *
 *
 *
 *
 * 后序 [8,9,4,10,5,2,11,6,7,3,1] n int left int right
 *
 * [[8,9,4,10,5,2],[11,6,7,3],[1]]
 *
 * left=0 right = left+size
 *
 *
 *
 *
 *
 *
 * 1.寻找跟节点 后续遍历的最后一个元素就是跟节点 root = new Tree(n[n.length-1])
 *
 * 2.从中序遍历中区分左右子树
 *
 * 数组长度 11
 *
 * root.index = 6
 *
 * 在中序遍历中： 左子树数量 0~root.index-1 6 左子树索引范围【0】~【5】 [8,4,9,2,5,10]
 *
 * 右子树数量 root.index+1 4 右子树索引范围【7】~【10】 [11,6,3,7]
 *
 * 在后序遍历中： root.index = length-1 = 10
 *
 * 左子树索引范围 0~root.index-5 【0】~【5】[8,9,4,10,5,2] 右子树索引范围 root.index-4
 * root.index-1 【6】~【9】[11,6,7,3]
 *
 * 3.寻找左子树的根节点
 */

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