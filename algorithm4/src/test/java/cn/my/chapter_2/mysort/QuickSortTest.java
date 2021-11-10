package cn.my.chapter_2.mysort;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cn.my.chapter_2.AbstractSort;

@DisplayName("测试快速排序")
public class QuickSortTest {

	private final Random random = new Random();

	private final int bound = 10000;

	@Test
	@DisplayName("填坑法")
	void fill() {
		int n = 10;
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(bound);
		}
		AbstractSort sort = new QuickSort.Fill();
		sort.sort(a);
		Assertions.assertTrue(sort.isSort(a));
	}

	@Test
	@DisplayName("交换法")
	void swap() {
		int n = 10;
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(bound);
		}
		AbstractSort sort = new QuickSort.Swap();
		sort.sort(a);
		Assertions.assertTrue(sort.isSort(a));
	}
}
