//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。 
//
// 函数 myAtoi(string s) 的算法如下： 
//
// 
// 读入字符串并丢弃无用的前导空格 
// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。 
// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 
// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 
//2 开始）。 
// 如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应该被固
//定为 −2³¹ ，大于 231 − 1 的整数应该被固定为 231 − 1 。 
// 返回整数作为最终结果。 
// 
//
// 注意： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。 
//
// 示例 2： 
//
// 
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -42"（读入 "42"）
//               ^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
// 
//
// 示例 3： 
//
// 
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//解析得到整数 4193 。
//由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
// 
//
// 示例 4： 
//
// 
//输入：s = "words and 987"
//输出：0
//解释：
//第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
//         ^
//解析得到整数 0 ，因为没有读入任何数字。
//由于 0 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 0 。 
//
// 示例 5： 
//
// 
//输入：s = "-91283472332"
//输出：-2147483648
//解释：
//第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
//          ^
//第 3 步："-91283472332"（读入 "91283472332"）
//                     ^
//解析得到整数 -91283472332 。
//由于 -91283472332 小于范围 [-2³¹, 2³¹ - 1] 的下界，最终结果被截断为 -2³¹ = -2147483648 。 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 200 
// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成 
// 
// Related Topics 字符串 👍 1318 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class StringToIntegerAtoi {
	public static void main(String[] args) {
		Solution solution = new StringToIntegerAtoi().new Solution();
		System.out.println(solution.myAtoi("+1"));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int myAtoi(String s) {
			if (s == null) {
				return 0;
			}
			Set<Character> signSet = new HashSet<>();
			signSet.add('+');
			signSet.add('-');

			char blank = ' ';
			char dot = '.';

			StringBuilder builder = new StringBuilder();
			// 判断是否为合法的起始位置
			boolean start = false;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!start) {
					// 是否为字符
					if (Character.isLetter(c)) {
						break;
					}
					// 是否为空格
					if (c == blank) {
						continue;
					}
					// 是否为小数点
					if (c == dot) {
						break;
					}
					if (Character.isDigit(c)) {
						builder.append(c);
						start = true;
						continue;
					}
					if (signSet.contains(c)) {
						if (i + 1 >= s.length()) {
							break;
						}
						char n = s.charAt(i + 1);
						if (signSet.contains(n) || n == blank || n == dot) {
							break;
						}
						if (Character.isDigit(n)) {
							builder.append(c);
							start = true;
						}
					}
				} else {
					if (Character.isDigit(c)) {
						builder.append(c);
					} else {
						break;
					}
				}
			}
			if (builder.length() == 0) {
				return 0;
			}
			int len = builder.length();
			int j = len - 1;
			int sign = 1;
			if (builder.charAt(0) == '-') {
				sign = -1;
				len = len - 1;
			}
			long l = 0;
			for (int i = 0; i < len; i++) {
				if (i == 0) {
					l = Long.parseLong(String.valueOf(builder.charAt(j)));
				} else {
					if (signSet.contains(builder.charAt(j))) {
						break;
					} else {
						l = (long) (l + Long.parseLong(String.valueOf(builder.charAt(j))) * Math.pow(10, i));
					}
					if (l * sign > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
					if (l * sign < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				}
				j--;
			}
			return (int) (l * sign);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}