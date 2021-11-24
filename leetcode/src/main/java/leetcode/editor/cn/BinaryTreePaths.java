//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 607 👎 0

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.my.TreeNode;

public class BinaryTreePaths {
	public static void main(String[] args) {
		Solution solution = new BinaryTreePaths().new Solution();
		TreeNode node = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
		System.out.println(Arrays.toString(solution.binaryTreePaths(node).toArray(new String[0])));
	}

	// leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public List<String> binaryTreePaths(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			Queue<TreeNode> queue = new ArrayDeque<>();
			queue.offer(root);
			Queue<String> q = new ArrayDeque<>();
			q.offer(Integer.toString(root.val));
			List<String> list = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				String s = q.poll();
				if (node.left != null) {
					queue.offer(node.left);
					q.offer(String.join("->", s, Integer.toString(node.left.val)));
				}
				if (node.right != null) {
					queue.offer(node.right);
					q.offer(String.join("->", s, Integer.toString(node.right.val)));
				}
				if (node.left == null && node.right == null) {
					list.add(s);
				}
			}
			return list;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}