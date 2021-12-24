//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 133 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.editor.cn.my.TreeNode;

public class MostFrequentSubtreeSum {
	public static void main(String[] args) {
		Solution solution = new MostFrequentSubtreeSum().new Solution();
		TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
		solution.findFrequentTreeSum(root);
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

		private int max;

		public int[] findFrequentTreeSum(TreeNode root) {
			if (root == null) {
				return new int[0];
			}
			map = new HashMap<>();
			Queue<Integer> queue = new LinkedList<>();
			helper(root);
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() == max) {
					queue.offer(entry.getKey());
				}
			}
			int[] array = new int[queue.size()];
			int i = 0;
			while (!queue.isEmpty()) {
				array[i] = queue.poll();
				i++;
			}
			return array;
		}

		private int helper(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int k = node.val + helper(node.left) + helper(node.right);
			int val = map.getOrDefault(k, 0) + 1;
			map.put(k, val);
			max = Math.max(val, max);
			return k;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}