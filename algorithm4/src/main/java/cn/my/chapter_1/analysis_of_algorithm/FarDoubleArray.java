package cn.my.chapter_1.analysis_of_algorithm;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * 最遥远的一对（一维）。编写一个程序，给定一个含有 N 个 double 值的数组 a[]，在其中找到
 * 一对最遥远的值：两者之差（绝对值）最大的两个数。程序在最坏情况下所需的运行时间应该 是线性级别的。
 */
public class FarDoubleArray {

	public static double[] find(double[] a) {
		if (a == null || a.length <= 1) {
			throw new InvalidParameterException();
		}
		double[] t = new double[2];
		Arrays.sort(a);
		t[0] = a[0];
		t[1] = a[a.length - 1];
		return t;
	}
}
