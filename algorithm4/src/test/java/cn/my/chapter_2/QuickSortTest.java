package cn.my.chapter_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试快速排序")
public class QuickSortTest {
	@Test
	void test1() {
		Integer[] a = { 5, 4, 3, 2, 1 };
		AbstractSort sort = new QuickSort();
		sort.sort(a);
		Assertions.assertTrue(sort.isSort(a));
		sort.show(a);
	}
}
