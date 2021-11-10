package cn.my.chapter_2.mysort;

import java.security.InvalidParameterException;
import java.util.Random;

import cn.my.chapter_2.AbstractSort;

/**
 * 快速排序
 * 
 * https://segmentfault.com/a/1190000004410119
 */
public class QuickSort {

	private static final Random random = new Random();

	private static <T extends Comparable<T>> void shuffle(T[] a) {
		int len = a.length;
		for (int i = len - 1; i >= 0; i--) {
			int r = random.nextInt(i + 1);
			T temp = a[r];
			a[r] = a[i];
			a[i] = temp;
		}
	}

	/**
	 * 填坑法
	 */
	static class Fill extends AbstractSort {

		@Override
		public <T extends Comparable<T>> void sort(T[] a) {
			if (isNull(a)) {
				throw new InvalidParameterException();
			}
			if (a.length == 1) {
				return;
			}
			shuffle(a);
			int len = a.length;
			sort(a, 0, len - 1);
		}

		public <T extends Comparable<T>> void sort(T[] a, int left, int right) {
			if (left < right) {
				int p = partition(a, left, right);
				sort(a, left, p - 1);
				sort(a, p + 1, right);
			}
		}

		public <T extends Comparable<T>> int partition(T[] a, int left, int right) {
			T p = a[left];
			while (left < right) {
				while (a[right].compareTo(p) >= 0 && left < right) {
					right = right - 1;
				}
				a[left] = a[right];
				while (p.compareTo(a[left]) > 0 && left < right) {
					left = left + 1;
				}
				a[right] = a[left];
			}
			a[left] = p;
			return left;
		}
	}

	/**
	 * 交换法
	 */
	static class Swap extends AbstractSort {

		@Override
		public <T extends Comparable<T>> void sort(T[] a) {
			if (isNull(a)) {
				throw new InvalidParameterException();
			}
			if (a.length == 1) {
				return;
			}
			shuffle(a);
			int len = a.length;
			sort(a, 0, len - 1);
		}

		public <T extends Comparable<T>> void sort(T[] a, int left, int right) {
			if (left < right) {
				int p = partition(a, left, right);
				sort(a, left, p - 1);
				sort(a, p + 1, right);
			}
		}

		public <T extends Comparable<T>> int partition(T[] a, int left, int right) {
			int p = left;
			while (left < right) {
				while (a[right].compareTo(a[p]) >= 0 && left < right) {
					right = right - 1;
				}
				while (a[left].compareTo(a[p]) < 0 && left < right) {
					left = left + 1;
				}
				if (left < right) {
					exch(a, left, right);
				}
			}
			exch(a, left, p);
			return left;
		}
	}
}
