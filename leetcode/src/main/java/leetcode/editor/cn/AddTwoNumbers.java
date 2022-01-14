//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7348 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.editor.cn.my.ListNode;

public class AddTwoNumbers {
	public static void main(String[] args) {
		Solution solution = new AddTwoNumbers().new Solution();
		int[] a1 = { 9, 9, 9, 9, 9, 9, 9 };
		int[] a2 = { 9, 9, 9, 9 };
		ListNode l1 = new ListNode();
		ListNode cursor = l1;
		for (int j : a1) {
			cursor.val = j;
			cursor.next = new ListNode();
			cursor = cursor.next;
		}

		ListNode l2 = new ListNode();
		cursor = l2;
		for (int j : a2) {
			cursor.val = j;
			cursor.next = new ListNode();
			cursor = cursor.next;
		}

		ListNode node = solution.addTwoNumbers(l1, l2);
		if (node != null) {
			List<Integer> list = new ArrayList<>();
			while (node != null) {
				list.add(node.val);
				node = node.next;
			}
			System.out.println(Arrays.toString(list.toArray(new Integer[0])));
		}
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null) {
				return l2;
			}
			if (l2 == null) {
				return l1;
			}
			return helper(l1, l2, 0);
		}

		public ListNode helper(ListNode l1, ListNode l2, int n) {
			if (l1 == null && l2 == null) {
				if (n != 0) {
					return new ListNode(n);
				} else {
					return null;
				}
			}
			if (l1 != null) {
				n = n + l1.val;
			}
			if (l2 != null) {
				n = n + l2.val;
			}
			ListNode node = new ListNode();
			node.val = n % 10;
			n = n / 10;
			if (l1 == null) {
				node.next = helper(null, l2.next, n);
			} else if (l2 == null) {
				node.next = helper(l1.next, null, n);
			} else {
				node.next = helper(l1.next, l2.next, n);
			}
			return node;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}