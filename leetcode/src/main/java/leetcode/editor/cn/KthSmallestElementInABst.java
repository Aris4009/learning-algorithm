//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 541 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class KthSmallestElementInABst {
	public static void main(String[] args) {
		Solution solution = new KthSmallestElementInABst().new Solution();
		TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
		System.out.println(solution.kthSmallest(root, 4));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		private int m;

		private int res;

		public int kthSmallest(TreeNode root, int k) {
			if (root == null) {
				return -1;
			}
			m = 0;
			helper(root, k);
			if (k != m) {
				return -1;
			}
			if (m != 0) {
				return res;
			} else {
				return -1;
			}
		}

		private void helper(TreeNode node, int k) {
			if (node == null) {
				return;
			}
			if (m < k) {
				helper(node.left, k);
				if (m < k) {
					m++;
					res = node.val;
				}
				helper(node.right, k);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

//    private Deque<Integer> queue;
//
//    public int kthSmallest(TreeNode root, int k) {
//        if (root == null) {
//            return -1;
//        }
//        queue = new LinkedList<>();
//        helper(root, k);
//        if (k != queue.size()) {
//            return -1;
//        }
//        if (!queue.isEmpty()) {
//            return queue.poll();
//        } else {
//            return -1;
//        }
//    }
//
//    private void helper(TreeNode node, int k) {
//        if (node == null) {
//            return;
//        }
//        if (queue.size() < k) {
//            helper(node.left, k);
//            if (queue.size() < k) {
//                queue.offerFirst(node.val);
//            }
//            helper(node.right, k);
//        }
//    }
}