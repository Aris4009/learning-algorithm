package cn.my.chapter_2.mysort2;

import java.security.InvalidParameterException;
import java.util.Arrays;

import cn.my.chapter_2.AbstractSort;

/**
 * 堆排序
 */
public class HeapSort extends AbstractSort {
	@Override
	public <T extends Comparable<T>> void sort(T[] a) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (a.length == 1) {
			return;
		}
		int len = a.length;
		buildHeap(a);
		for (int i = len - 1; i >= 0; i--) {
			exch(a, 0, i);
			heapify(a, 0, i);
		}
	}

	private <T extends Comparable<T>> void buildHeap(T[] a) {
		int len = a.length;
		for (int i = (len >> 1) - 1; i >= 0; i--) {
			heapify(a, i, len);
		}
	}

	private <T extends Comparable<T>> void heapify(T[] a, int i, int len) {
		int max = i;
		int left = (i << 1) + 1;
		int right = (i << 1) + 2;
		if (left < len && less(a[max], a[left])) {
			max = left;
		}
		if (right < len && less(a[max], a[right])) {
			max = right;
		}
		if (max != i) {
			exch(a, i, max);
			heapify(a, max, len);
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 2, 3, 4, 5, 0 };
		AbstractSort sort = new HeapSort();
		sort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
