//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3355 👎 0

package leetcode.editor.cn;

public class ReverseInteger {
	public static void main(String[] args) {
		Solution solution = new ReverseInteger().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int reverse(int x) {
			int num = 0;
			while (x != 0) {
				if (num < Integer.MIN_VALUE / 10 || num > Integer.MAX_VALUE / 10) {
					return 0;
				}
				int m = x % 10;
				x = x / 10;
				num = num * 10 + m;
			}
			return num;
//			StringBuilder builder = new StringBuilder();
//			int i = str.length();
//			boolean flag = false;
//			while (i > 0) {
//				i--;
//				if (i == 0 && str.charAt(i) == '-') {
//					flag = true;
//				} else {
//					builder.append(str.charAt(i));
//				}
//			}
//			if (flag) {
//				builder.insert(0, '-');
//			}
//			long l = Long.parseLong(builder.toString());
//			if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
//				return 0;
//			} else {
//				return (int) l;
//			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}