package cn.my.chapter_2.mysort2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cn.my.chapter_2.AbstractSort;

@DisplayName("测试快速排序")
public class QuickSortTest {

	@Test
	void test1() {
		Integer[] a = { 1, 99, 5, 4, 3, 2, 1, 100 };
		AbstractSort sort = new QuickSort();
		sort.sort(a);
		Assertions.assertTrue(sort.isSort(a));
		sort.show(a);
	}
}
