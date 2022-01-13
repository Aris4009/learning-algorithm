package cn.my.chapter_2.mysort2;

import java.security.InvalidParameterException;

import cn.my.chapter_2.AbstractSort;

public class SelectionSort extends AbstractSort {
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
			int min = selectMin(a, i, len);
			if (i != min) {
				exch(a, i, min);
			}
		}
	}

	private <T extends Comparable<T>> int selectMin(T[] a, int left, int right) {
		int min = left;
		T minVal = a[min];
		for (int i = left + 1; i < right; i++) {
			if (less(a[i], minVal)) {
				minVal = a[i];
				min = i;
			}
		}
		return min;
	}
}
