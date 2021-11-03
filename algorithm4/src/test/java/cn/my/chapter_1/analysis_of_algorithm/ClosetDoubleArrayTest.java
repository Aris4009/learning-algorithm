package cn.my.chapter_1.analysis_of_algorithm;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("最接近的一对（一维）。编写一个程序，给定一个含有 N 个 double 值的数组 a[]，在其中找到\n" + "一对最接近的值：两者之差（绝对值）最小的两个数。程序在最坏情况下所需的运行时间应该\n"
		+ "是线性对数级别的。")
public class ClosetDoubleArrayTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	void test() {
		Random random = new Random();
		int n = 5;
		int range = 10;
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(range);
		}
		log.info(Arrays.toString(a));
		double[] d = ClosetDoubleArray.find(a);
		log.info(Arrays.toString(d));
		Assertions.assertEquals(2, d.length);
	}
}
