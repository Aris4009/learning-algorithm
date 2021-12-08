//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 557 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
		solution.zigzagLevelOrder(root);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			List<List<Integer>> list = new LinkedList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			int i = 0;
			queue.offer(root);
			while (!queue.isEmpty()) {
				int m = i & 1;
				LinkedList<Integer> l = new LinkedList<>();
				int size = queue.size();
				for (int j = 0; j < size; j++) {
					TreeNode node = queue.poll();
					if (node != null) {
						if (node.left != null) {
							queue.offer(node.left);
						}
						if (node.right != null) {
							queue.offer(node.right);
						}
						if (m == 0) {
							l.addLast(node.val);
						} else {
							l.addFirst(node.val);
						}
					}

				}
				i = i + 1;
				list.add(l);
			}
			return list;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}