package cn.my.chapter_2;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;

/**
 * 归并排序
 */
public class MergeSort extends AbstractSort {

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
		T[] temp = (T[]) Array.newInstance(a.getClass().getComponentType(), len);
		sort(a, 0, len - 1, temp);
	}

	private <T extends Comparable<T>> void sort(T[] a, int left, int right, T[] temp) {
		if (left < right) {
			int mid = left + ((right - left) / 2);
			sort(a, left, mid, temp);
			sort(a, mid + 1, right, temp);
			merge(a, left, mid, right, temp);
		}
	}

	private <T extends Comparable<T>> void merge(T[] a, int left, int mid, int right, T[] temp) {
		int i = left;
		int j = mid + 1;
		System.arraycopy(a, left, temp, left, right + 1 - left);
		for (int k = left; k <= right; k++) {
			if (i > mid) {
				a[k] = temp[j++];
			} else if (j > right) {
				a[k] = temp[i++];
			} else if (less(temp[j], temp[i])) {
				a[k] = temp[j++];
			} else {
				a[k] = temp[i++];
			}
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 5, 4, 3, 2, 1 };
		AbstractSort sort = new MergeSort();
		sort.sort(a);
		sort.show(a);
	}
}
