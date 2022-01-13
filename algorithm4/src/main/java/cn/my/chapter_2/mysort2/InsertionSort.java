package cn.my.chapter_2.mysort2;

import java.security.InvalidParameterException;

import cn.my.chapter_2.AbstractSort;

public class InsertionSort extends AbstractSort {
	@Override
	public <T extends Comparable<T>> void sort(T[] a) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (a.length == 1) {
			return;
		}
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j > 0 && j < len; j--) {
				if (less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
				}
			}
		}
	}
}
