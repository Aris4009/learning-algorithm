package cn.my.chapter_2.mysort;

import java.security.InvalidParameterException;

import cn.my.chapter_2.AbstractSort;

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
		int gap = len >> 1;
		while (gap > 0) {
			for (int i = gap; i < len; i++) {
				for (int j = i; j >= gap && less(a[j], a[j - gap]); j = j - gap) {
					exch(a, j, j - gap);
				}
			}
			gap = gap >> 1;
		}
	}
}
