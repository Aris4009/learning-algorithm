//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 376 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import leetcode.editor.cn.my.TreeNode;

public class FindModeInBinarySearchTree {
	public static void main(String[] args) {
		Solution solution = new FindModeInBinarySearchTree().new Solution();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
		System.out.println(Arrays.toString(solution.findMode(root)));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		private List<Integer> list;

		private int base;

		private int count;

		private int maxCount;

		public int[] findMode(TreeNode root) {
			if (root == null) {
				return new int[0];
			}
			if (root.left == null && root.right == null) {
				return new int[] { root.val };
			}
			list = new LinkedList<>();
			inorder(root);
			int[] a = new int[list.size()];
			for (int i = 0; i < a.length; i++) {
				a[i] = list.get(i);
			}
			return a;
		}

		private void inorder(TreeNode node) {
			if (node == null) {
				return;
			}
			inorder(node.left);
			if (base == node.val) {
				count = count + 1;
			} else {
				base = node.val;
				count = 1;
			}
			if (count == maxCount) {
				list.add(node.val);
			} else if (count > maxCount) {
				maxCount = count;
				list.clear();
				list.add(node.val);
			}
			inorder(node.right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}