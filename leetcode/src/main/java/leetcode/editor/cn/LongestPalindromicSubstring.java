//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4508 👎 0

package leetcode.editor.cn;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		Solution solution = new LongestPalindromicSubstring().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String longestPalindrome(String s) {
			String str = "";
			if (s == null) {
				return null;
			}
			int len = s.length();
			if (len < 2) {
				return s;
			}
			for (int i = 0; i < s.length(); i++) {
				String s1 = find(s, i, i);
				String s2 = find(s, i, i + 1);
				if (str.length() < s1.length()) {
					str = s1;
				}
				if (str.length() < s2.length()) {
					str = s2;
				}
			}
			return str;
		}

		private String find(String s, int left, int right) {
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left = left - 1;
				right = right + 1;
			}
			return s.substring(left + 1, right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}