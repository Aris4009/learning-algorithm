//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1436 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import leetcode.editor.cn.my.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
	public static void main(String[] args) {
		Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
		TreeNode root = new TreeNode(3,
				new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
				new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		Deque<TreeNode> queue = new LinkedList<>();
		TreeNode n = solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
		if (n != null) {
			System.out.println(n.val);
		}
	}

	// leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {

		private Deque<TreeNode> q1;

		private Deque<TreeNode> q2;

		private boolean flag;

		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null) {
				return null;
			}
			flag = false;
			q1 = new ArrayDeque<>();
			helper(root, p, q1);
			flag = false;
			q2 = new ArrayDeque<>();
			helper(root, q, q2);
			for (TreeNode m : q1) {
				for (TreeNode n : q2) {
					if (m == n) {
						return m;
					}
				}
			}
			return null;
		}

		private void helper(TreeNode root, TreeNode n, Deque<TreeNode> queue) {
			if (root == null) {
				return;
			}
			if (!flag) {
				queue.offerFirst(root);
			}
			if (root.val == n.val) {
				flag = true;
				return;
			}
			if (!flag) {
				helper(root.left, n, queue);
				helper(root.right, n, queue);
				if (!flag) {
					queue.poll();
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}