package cn.my.chapter_2;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * 选择排序
 */
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
			log.info("第{}趟:{}", i + 1, Arrays.toString(a));
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
}
