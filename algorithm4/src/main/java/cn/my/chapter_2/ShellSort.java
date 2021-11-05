package cn.my.chapter_2;

import java.security.InvalidParameterException;

/**
 * 希尔排序
 */
public class ShellSort extends AbstractSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] a) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (a.length == 1) {
			return;
		}
		int len = a.length;
		for (int gap = len / 2; gap > 0; gap = gap / 2) {
			for (int i = gap; i < len; i++) {
				for (int j = i; j >= gap && less(a[j], a[j - gap]); j = j - gap) {
					exch(a, j, j - gap);
				}
			}
		}
	}
}
