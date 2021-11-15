package cn.my.chapter_2.mysort;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cn.my.chapter_2.AbstractSort;

@DisplayName("测试堆排序")
public class HeapSortTest {
	@Test
	void test() {
		int n = 10;
		int bound = 1000;
		Random random = new Random();
		Integer[] array = new Integer[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(bound);
		}
		AbstractSort sort = new HeapSort();
		sort.sort(array);
		Assertions.assertTrue(sort.isSort(array));
	}
}
