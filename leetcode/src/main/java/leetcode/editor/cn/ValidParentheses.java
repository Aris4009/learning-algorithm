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
		String s = "([}}])";
		solution.isValid(s);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isValid(String s) {
			if (s == null || s.length() % 2 != 0) {
				return false;
			}
			Character a1 = '(';
			Character a2 = ')';
			Character b1 = '{';
			Character b2 = '}';
			Character c1 = '[';
			Character c2 = ']';
			Deque<Character> deque = new ArrayDeque<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (a1.equals(c) || b1.equals(c) || c1.equals(c)) {
					deque.offerFirst(c);
				} else {
					Character e = deque.peek();
					if ((c == a2 && a1.equals(e)) || (c == b2 && b1.equals(e)) || (c == c2 && c1.equals(e))) {
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