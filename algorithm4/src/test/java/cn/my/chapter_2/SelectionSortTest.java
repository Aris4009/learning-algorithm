package cn.my.chapter_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试选择排序")
public class SelectionSortTest {

	@Test
	void test1() {
		String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		AbstractSort sort = new SelectionSort();
		sort.sort(a);
		Assertions.assertTrue(sort.isSort(a));
		sort.show(a);
	}
}
