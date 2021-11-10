package cn.my.chapter_2;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 排序算法类的模板
 */
public abstract class AbstractSort {

	public static final Logger log = LoggerFactory.getLogger(AbstractSort.class);

	public abstract <T extends Comparable<T>> void sort(T[] a);

	public <T extends Comparable<T>> boolean isSort(T[] a) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (a.length == 1) {
			return true;
		}
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	protected <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	protected <T extends Comparable<T>> void exch(T[] a, int i, int j) {
		if (isNull(a)) {
			throw new InvalidParameterException();
		}
		if (i < 0 || j < 0) {
			throw new InvalidParameterException();
		}
		if (i >= a.length || j >= a.length) {
			throw new InvalidParameterException();
		}
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public <T extends Comparable<T>> void show(T[] a) {
		if (Objects.isNull(a) || a.length == 0) {
			throw new NullPointerException();
		}
		String str = Arrays.toString(a);
		log.info(str);
	}

	protected <T extends Comparable<T>> boolean isNull(T[] a) {
		return Objects.isNull(a) || a.length == 0;
	}
}
