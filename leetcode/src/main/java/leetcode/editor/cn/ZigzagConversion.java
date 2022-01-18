//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1445 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ZigzagConversion {
	public static void main(String[] args) {
		Solution solution = new ZigzagConversion().new Solution();
		String a = "PAYPALISHIRING";
		System.out.println(solution.convert(a, 3));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String convert(String s, int numRows) {
			if (Objects.isNull(s) || s.isEmpty() || s.length() == 1 || numRows == 1) {
				return s;
			}
			int len = s.length();
			List<StringBuilder> list = new ArrayList<>();
			for (int i = 0; i < numRows; i++) {
				StringBuilder builder = new StringBuilder();
				list.add(builder);
			}
			int i = 0;
			int down = 0;
			boolean direction = true;
			while (i < len) {
				StringBuilder builder = list.get(down);
				builder.append(s.charAt(i));
				if (direction) {
					down++;
					if (down == numRows - 1) {
						direction = false;
					}
				} else {
					down--;
					if (down == 0) {
						direction = true;
					}
				}
				i++;
			}
			StringBuilder builder = new StringBuilder();
			for (StringBuilder buffer : list) {
				builder.append(buffer);
			}
			return builder.toString();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}