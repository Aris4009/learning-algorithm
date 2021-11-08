package cn.my.chapter_2;

import java.security.InvalidParameterException;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort extends AbstractSort {

	private Random random = new Random();

	@Override
	public <T extends Comparable<T>> void sort(T[] a) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (a.length == 1) {
			return;
		}
		shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private <T extends Comparable<T>> void shuffle(T[] a) {
		int len = a.length;
		for (int i = len - 1; i >= 0; i--) {
			int r = random.nextInt(i + 1);
			exch(a, r, i);
		}
	}

	private <T extends Comparable<T>> void sort(T[] a, int left, int right) {
		if (left < right) {
			int j = position(a, left, right);
			sort(a, left, j - 1);
			sort(a, j + 1, right);
		}
	}

	private <T extends Comparable<T>> int position(T[] a, int left, int right) {
		int i = left;
		int j = right + 1;
		T t = a[left];
		while (true) {
			while (less(a[++i], t)) {
				if (i == right) {
					break;
				}
			}
			while (less(t, a[--j])) {
				if (j == left) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		exch(a, left, j);
		return j;
	}

	public static void main(String[] args) {
		Integer[] a = { 5, 4, 3, 2, 1 };
		AbstractSort sort = new QuickSort();
		sort.sort(a);
		sort.show(a);
	}
}
