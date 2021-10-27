package cn.my.chapter_1.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 双向链表测试
 */
@DisplayName("双向链表测试")
public class DoubleListTest {

	private DoubleList<Integer> doubleList;

	@BeforeEach
	void init() {
		doubleList = new DoubleList<>();
	}

	@Test
	@DisplayName("表头插入结点")
	void addFirst() {
		Assertions.assertEquals(0, doubleList.size());
		Assertions.assertTrue(doubleList.isEmpty());
		int[] a = { 0, 1, 2, 3, 4 };
		for (int t : a) {
			doubleList.addFirst(t);
		}
		String test = "4,3,2,1,0";
		Assertions.assertEquals(test, doubleList.toString());
		Assertions.assertEquals(5, doubleList.size());
		Assertions.assertFalse(doubleList.isEmpty());
	}
}
