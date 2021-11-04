package cn.my.chapter_2;

import java.security.InvalidParameterException;
import java.util.Arrays;

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
			log.info("第{}趟:{}", i, Arrays.toString(a));
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
}
