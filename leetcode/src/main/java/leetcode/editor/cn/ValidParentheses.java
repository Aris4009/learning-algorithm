//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2912 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
	public static void main(String[] args) {
		Solution solution = new ValidParentheses().new Solution();
		String s = "){";
		solution.isValid(s);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isValid(String s) {
			if (s == null || s.length() % 2 != 0) {
				return false;
			}
			char a1 = '(';
			char a2 = ')';
			char b1 = '{';
			char b2 = '}';
			char c1 = '[';
			char c2 = ']';
			Deque<Character> deque = new ArrayDeque<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (a1 == c || b1 == c || c1 == c) {
					deque.offerFirst(c);
				} else {
					Character e = deque.peek();
					if (e != null && ((c == a2 && a1 == e) || (c == b2 && b1 == e) || (c == c2 && c1 == e))) {
						deque.poll();
					} else {
						deque.offerFirst(c);
					}
				}
			}
			return deque.isEmpty();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}