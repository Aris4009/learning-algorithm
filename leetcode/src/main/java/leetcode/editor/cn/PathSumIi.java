//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 629 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathSumIi {
	public static void main(String[] args) {
		Solution solution = new PathSumIi().new Solution();
		TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
				new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
		solution.pathSum(root, 22);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		private List<List<Integer>> list;

		public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
			if (root == null) {
				return Collections.emptyList();
			}
			list = new LinkedList<>();
			helper(root, targetSum, null);
			return list;
		}

		private void helper(TreeNode node, int targetSum, LinkedList<Integer> sub) {
			if (node == null) {
				return;
			}
			if (sub == null) {
				sub = new LinkedList<>();
			}
			sub.add(node.val);
			targetSum = targetSum - node.val;
			if (node.left == null && node.right == null && targetSum == 0) {
				list.add(new LinkedList<>(sub));
			}
			helper(node.left, targetSum, sub);
			helper(node.right, targetSum, sub);
			sub.removeLast();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}