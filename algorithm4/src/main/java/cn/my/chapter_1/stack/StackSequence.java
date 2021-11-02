package cn.my.chapter_1.stack;

/**
 * 假设我们的栈测试用例将会进行一系列混合的入栈和出栈操作，序列中的整数 0,1,...,N-1（按此先后顺序排列）表示入栈操作，N
 * 个减号表示出栈操作。设计一个算法，判 定给定的混合序列是否会使数组向下溢出（你所使用的空间量与 N 无关，即不能用某种数据结
 * 构存储所有整数）。设计一个线性时间的算法判定我们的测试用例能否产生某个给定的排列（这 取决于出栈操作指令的出现位置）。
 */
public class StackSequence {

	public static boolean test1(String[] array) {
		int n = 0;
		for (String a : array) {
			if (a.equals("-")) {
				n = n - 1;
			} else {
				n = n + 1;
			}
			if (n < 0) {
				return false;
			}
		}
		return true;
	}
}
