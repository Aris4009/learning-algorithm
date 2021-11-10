package cn.my.chapter_2.mysort;

import java.security.InvalidParameterException;

import cn.my.chapter_2.AbstractSort;

/**
 * 直接插入排序
 *
 */
public class StraightInsertSort extends AbstractSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] a) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (a.length == 1) {
			return;
		}
		int len = a.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
}
