//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1777 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.editor.cn.my.ListNode;

public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
//			return solution1(head, n);
			return solution2(head, n);
		}

		private ListNode solution1(ListNode head, int n) {
			int len = 0;
			ListNode cursor = head;
			while (cursor != null) {
				len++;
				cursor = cursor.next;
			}

			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			cursor = dummy;
			int i = 1;
			while (i < len - n + 1) {
				cursor = cursor.next;
				i++;
			}
			cursor.next = cursor.next.next;
			return dummy.next;
		}

		private ListNode solution2(ListNode head, int n) {
			Deque<ListNode> queue = new LinkedList<>();
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			ListNode cursor = dummy;
			while (cursor != null) {
				queue.offerFirst(cursor);
				cursor = cursor.next;
			}

			while (n > 0) {
				queue.poll();
				n--;
			}
			ListNode pre = queue.peek();
			pre.next = pre.next.next;
			return dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}