package cn.my.chapter_2.mysort3;

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
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			if (min != i) {
				exch(a, i, min);
			}
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 5, 4, 3, 2, 2, 1, 8 };
		AbstractSort sort = new SelectionSort();
		sort.sort(a);
		System.out.println(sort.isSort(a));
	}
}
