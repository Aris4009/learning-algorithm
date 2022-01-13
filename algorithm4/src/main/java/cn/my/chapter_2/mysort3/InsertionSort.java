package cn.my.chapter_2.mysort3;

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
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 5, 4, 3, 2, 2, 1, 8 };
		AbstractSort sort = new InsertionSort();
		sort.sort(a);
		System.out.println(sort.isSort(a));
	}
}
