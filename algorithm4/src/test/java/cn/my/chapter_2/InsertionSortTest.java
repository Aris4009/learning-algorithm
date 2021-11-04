package cn.my.chapter_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试插入排序")
public class InsertionSortTest {

	@Test
	void test() {
		String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		AbstractSort sort = new InsertionSort();
		sort.sort(a);
		Assertions.assertTrue(sort.isSort(a));
		sort.show(a);
	}
}
