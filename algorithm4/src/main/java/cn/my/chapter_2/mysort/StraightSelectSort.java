package cn.my.chapter_2.mysort;

import java.security.InvalidParameterException;

import cn.my.chapter_2.AbstractSort;

/**
 * 直接选择排序
 */
public class StraightSelectSort extends AbstractSort {
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
			int k = i;
			for (int j = i + 1; j < len; j++) {
				if (less(a[j], a[k])) {
					k = j;
				}
			}
			if (k != i) {
				exch(a, i, k);
			}
		}
	}
}
