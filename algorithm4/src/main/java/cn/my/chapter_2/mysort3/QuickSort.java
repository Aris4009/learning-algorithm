package cn.my.chapter_2.mysort3;

import java.security.InvalidParameterException;

import cn.my.chapter_2.AbstractSort;

public class QuickSort extends AbstractSort {
	@Override
	public <T extends Comparable<T>> void sort(T[] a) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (a.length == 1) {
			return;
		}
		quickSort(a, 0, a.length - 1);
	}

	private <T extends Comparable<T>> void quickSort(T[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		int p = partition(a, left, right);
		quickSort(a, left, p - 1);
		quickSort(a, p + 1, right);
	}

	private <T extends Comparable<T>> int partition(T[] a, int left, int right) {
		int p = left;
		exch(a, p, right);
		for (int i = left; i < right; i++) {
			if (a[i].compareTo(a[right]) <= 0) {
				exch(a, i, p);
				p++;
			}
		}
		exch(a, p, right);
		return p;
	}

	public static void main(String[] args) {
		Integer[] a = { 5, 4, 3, 2, 2, 1, 8 };
		AbstractSort sort = new QuickSort();
		sort.sort(a);
		System.out.println(sort.isSort(a));
	}
}
