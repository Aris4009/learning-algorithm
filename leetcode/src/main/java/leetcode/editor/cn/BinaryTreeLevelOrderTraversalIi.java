//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 517 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			LinkedList<List<Integer>> list = new LinkedList<>();
			Deque<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				LinkedList<Integer> l = new LinkedList<>();
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					l.add(node.val);
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				list.offerFirst(l);
			}
			return list;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}