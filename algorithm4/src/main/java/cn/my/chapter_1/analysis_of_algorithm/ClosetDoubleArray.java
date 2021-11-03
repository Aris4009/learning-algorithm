package cn.my.chapter_1.analysis_of_algorithm;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * 最接近的一对（一维）。编写一个程序，给定一个含有 N 个 double 值的数组 a[]，在其中找到
 * 一对最接近的值：两者之差（绝对值）最小的两个数。程序在最坏情况下所需的运行时间应该 是线性对数级别的。
 */
public class ClosetDoubleArray {

	public static double[] find(double[] a) {
		if (a == null || a.length <= 1) {
			throw new InvalidParameterException();
		}
		double[] t = new double[2];
		Arrays.sort(a);
		double d = Double.MAX_VALUE;
		for (int i = 1; i < a.length; i++) {
			double m = Math.abs(a[i] - a[i - 1]);
			if (Double.compare(m, d) <= 0) {
				d = m;
				t[0] = a[i - 1];
				t[1] = a[i];
			}
		}
		return t;
	}
}
