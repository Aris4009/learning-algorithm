//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1218 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.ListNode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		Solution solution = new PalindromeLinkedList().new Solution();
		int[] a = { 1, 2, 2, 1 };
		ListNode head = new ListNode(a[0]);
		ListNode cursor = head;
		for (int i = 1; i < a.length; i++) {
			cursor.next = new ListNode(a[i]);
			cursor = cursor.next;
		}
		System.out.println(solution.isPalindrome(head));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public boolean isPalindrome(ListNode head) {
			if (head == null) {
				return false;
			}
			if (head.next == null) {
				return true;
			}

			ListNode slow = head;
			ListNode fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			ListNode post = slow.next;
			slow.next = null;
			ListNode cursor = post;
			ListNode n = null;
			while (cursor != null) {
				ListNode next = cursor.next;
				cursor.next = n;
				n = cursor;
				cursor = next;
			}

			ListNode pre = head;
			while (pre != null && n != null) {
				if (pre.val != n.val) {
					return false;
				}
				pre = pre.next;
				n = n.next;
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}