//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 205 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import leetcode.editor.cn.my.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	public static void main(String[] args) {
		Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
		TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		List<Integer> list = new LinkedList<>();
		TreeNode.inorder(treeNode, list);
		System.out.println(Arrays.toString(list.toArray(new Integer[0])));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
			if (preorder == null || preorder.length == 0) {
				return null;
			}
			TreeNode root = new TreeNode(preorder[0]);
			if (preorder.length == 1) {
				return root;
			}
			int n = preorder.length;
			for (int i = 0; i < postorder.length; i++) {
				if (preorder[1] == postorder[i]) {
					int leftCount = i + 1;
					int[] preLeft = Arrays.copyOfRange(preorder, 1, leftCount + 1);
					int[] preRight = Arrays.copyOfRange(preorder, leftCount + 1, n);
					int[] postLeft = Arrays.copyOfRange(postorder, 0, leftCount);
					int[] postRight = Arrays.copyOfRange(postorder, leftCount, n - 1);
					root.left = constructFromPrePost(preLeft, postLeft);
					root.right = constructFromPrePost(preRight, postRight);
					break;
				}
			}
			return root;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}