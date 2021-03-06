//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 630 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.ListNode;
import leetcode.editor.cn.my.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	public static void main(String[] args) {
		Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
		int[] a = new int[] { 0, 1, 2, 3, 4, 5 };
		ListNode listNode = new ListNode(a[0]);
		ListNode node = listNode;
		for (int i = 1; i < a.length; i++) {
			node.next = new ListNode(a[i]);
			node = node.next;
		}
		solution.sortedListToBST(listNode);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		public TreeNode sortedListToBST(ListNode head) {
			if (head == null) {
				return null;
			}
			return helper(head, null);
		}

		private TreeNode helper(ListNode left, ListNode right) {
			if (left == right) {
				return null;
			}
			ListNode mid = mid(left, right);
			TreeNode root = new TreeNode(mid.val);
			root.left = helper(left, mid);
			root.right = helper(mid.next, right);
			return root;
		}

		private ListNode mid(ListNode left, ListNode right) {
			ListNode fast = left;
			ListNode slow = left;
			while (fast != right && fast.next != right) {
				fast = fast.next;
				fast = fast.next;
				slow = slow.next;
			}
			return slow;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}