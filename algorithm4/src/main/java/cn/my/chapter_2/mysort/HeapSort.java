package cn.my.chapter_2.mysort;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;

import cn.my.chapter_2.AbstractSort;

/**
 * 堆排序
 */
public class HeapSort extends AbstractSort {
	@Override
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void sort(T[] a) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (a.length == 1) {
			return;
		}
		int len = a.length;
		T[] copy = (T[]) Array.newInstance(a.getClass().getComponentType(), len + 1);
		System.arraycopy(a, 0, copy, 1, len);

		build(copy, len);
		for (int i = len; i > 0; i--) {
			exch(copy, 1, i);
			len = len - 1;
			heap(copy, 1, len);
		}
		System.arraycopy(copy, 1, a, 0, copy.length - 1);
	}

	private <T extends Comparable<T>> void build(T[] a, int len) {
		for (int i = len >> 1; i >= 1; i--) {
			heap(a, i, len);
		}
	}

	private <T extends Comparable<T>> void heap(T[] a, int i, int len) {
		int left = i * 2;
		int right = i * 2 + 1;
		int max = i;
		if (left <= len && less(a[max], a[left])) {
			max = left;
		}
		if (right <= len && less(a[max], a[right])) {
			max = right;
		}
		if (max != i) {
			exch(a, i, max);
			heap(a, max, len);
		}
	}
}
