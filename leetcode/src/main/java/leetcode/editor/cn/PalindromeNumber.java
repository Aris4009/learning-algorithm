//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 👍 1769 👎 0

package leetcode.editor.cn;

public class PalindromeNumber {
	public static void main(String[] args) {
		Solution solution = new PalindromeNumber().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isPalindrome(int x) {
			if (x < 0) {
				return false;
			}
			if (x < 10) {
				return true;
			}
			if (x % 10 == 0) {
				return false;
			}
//			Deque<Integer> queue = new ArrayDeque<>();
//			int num = x;
//			while (num >= 10) {
//				int b = num;
//				queue.offer(b % 10);
//				num = num / 10;
//			}
//			queue.offer(num);
//			while (!queue.isEmpty()) {
//				if (queue.peekFirst().equals(queue.peekLast())) {
//					queue.pollFirst();
//					queue.pollLast();
//				} else {
//					return false;
//				}
//			}
//			return true;
			int reverse = 0;
			while (x > reverse) {
				reverse = reverse * 10 + x % 10;
				x = x / 10;
			}
			return x == reverse || x == reverse / 10;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}