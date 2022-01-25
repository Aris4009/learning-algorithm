//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1222 👎 0

package leetcode.editor.cn;

public class ImplementStrstr {
	public static void main(String[] args) {
		Solution solution = new ImplementStrstr().new Solution();
		solution.strStr("mississippi", "aabaaf");
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int strStr(String haystack, String needle) {
			if (needle.isEmpty()) {
				return 0;
			}
			if (haystack.length() < needle.length()) {
				return -1;
			}
			// KMP算法
			// 最长公共前后缀，前缀为以第一个字符开头，不包含最后一个字符的所有子串。后缀为以最后一个字符结尾，不包含第一个字符的所有子串。
			// 把求得的最长相同前后缀的长度就是对应前缀表的元素
			// 找到不匹配的位置，此时要看它的前一个字符的前缀表的数值是多少
			// next 数组存放的是当前长度下的 最长相同前后缀 的长度
			// 例:a a b a a f
			// 前缀表:
			// a 0
			// aa 1
			// aab 0
			// aaba 1
			// aabaa 2
			// aabaaf 0
			int[] next = next(needle);
			int j = -1;
			for (int i = 0; i < haystack.length(); i++) {
				// 回退操作
				while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
					j = next[j];
				}
				if (haystack.charAt(i) == needle.charAt(j + 1)) {
					j++;
				}
				if (j == needle.length() - 1) {
					return i - needle.length() + 1;
				}
			}
			return -1;
		}

		// 构造next数组，j+1表示前缀起始位置，i表示后缀其实位置
		private int[] next(String needle) {
			int[] next = new int[needle.length()];
			int j = -1;
			next[0] = j;
			for (int i = 1; i < needle.length(); i++) {
				while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
					j = next[j];
				}
				if (needle.charAt(i) == needle.charAt(j + 1)) {
					j++;
				}
				next[i] = j;
			}
			return next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}