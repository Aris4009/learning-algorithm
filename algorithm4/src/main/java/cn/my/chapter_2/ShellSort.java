package cn.my.chapter_2;

import java.security.InvalidParameterException;

/**
 * 希尔排序
 */
public class ShellSort {

	/**
	 * 根据定义实现的希尔排序
	 * 
	 * 我们来看下希尔排序的基本步骤，在此我们选择增量gap=length/2，缩小增量继续以gap =
	 * gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列。希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，也是希尔建议的增量，称为希尔增量，但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。
	 */
	public static class MySort extends AbstractSort {

		@Override
		public <T extends Comparable<T>> void sort(T[] a) {
			if (isNull(a)) {
				throw new InvalidParameterException();
			}
			if (a.length == 1) {
				return;
			}

			int len = a.length;
			int gap = len / 2;
			while (gap > 0) {
				for (int i = gap; i < len; i++) {
					for (int j = i; j >= gap && less(a[j], a[j - gap]); j -= gap) {
						exch(a, j, j - gap);
					}
				}
				gap = gap / 2;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 4, 2, 3, 1, 5, 6, 10 };
		AbstractSort sort = new ShellSort.MySort();
		sort.sort(a);
		sort.show(a);
	}
}
