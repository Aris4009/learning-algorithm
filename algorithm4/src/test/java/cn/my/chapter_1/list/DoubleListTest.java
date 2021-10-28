package cn.my.chapter_1.list;

import java.util.NoSuchElementException;

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

	@Test
	@DisplayName("表尾插入结点")
	void addLast() {
		Assertions.assertEquals(0, doubleList.size());
		Assertions.assertTrue(doubleList.isEmpty());
		int[] a = { 0, 1, 2, 3, 4 };
		for (int t : a) {
			doubleList.addLast(t);
		}
		String test = "0,1,2,3,4";
		Assertions.assertEquals(test, doubleList.toString());
		Assertions.assertEquals(5, doubleList.size());
		Assertions.assertFalse(doubleList.isEmpty());
	}

	@Test
	@DisplayName("从表头删除结点")
	void removeFirst() {
		int[] a = { 0, 1, 2, 3, 4 };
		for (int t : a) {
			doubleList.addFirst(t);
		}
		Assertions.assertEquals(5, doubleList.size());
		Assertions.assertFalse(doubleList.isEmpty());

		doubleList.removeFirst();
		Assertions.assertEquals(4, doubleList.size());
		String test = "3,2,1,0";
		Assertions.assertEquals(test, doubleList.toString());

		for (int i = 0; i < a.length - 1; i++) {
			doubleList.removeFirst();
		}
		Assertions.assertEquals(0, doubleList.size());
		Assertions.assertEquals("", doubleList.toString());

		for (int t : a) {
			doubleList.addFirst(t);
		}
		test = "4,3,2,1,0";
		Assertions.assertEquals(test, doubleList.toString());
		Assertions.assertEquals(5, doubleList.size());
		Assertions.assertFalse(doubleList.isEmpty());
	}

	@Test
	@DisplayName("从表尾删除结点")
	void removeLast() {
		int[] a = { 0, 1, 2, 3, 4 };
		for (int t : a) {
			doubleList.addLast(t);
		}
		doubleList.removeLast();
		Assertions.assertEquals(4, doubleList.size());
		String test = "0,1,2,3";
		Assertions.assertEquals(test, doubleList.toString());

		for (int i = 0; i < a.length - 1; i++) {
			doubleList.removeLast();
		}
		Assertions.assertEquals(0, doubleList.size());
		Assertions.assertEquals("", doubleList.toString());
	}

	@Test
	@DisplayName("在指定结点前插入结点")
	void insertBefore() {
		int[] a = { 0, 1, 2, 3, 4 };
		for (int t : a) {
			doubleList.addLast(t);
		}
		doubleList.insertBefore(0, -1);
		Assertions.assertEquals(6, doubleList.size());
		String test = "-1,0,1,2,3,4";
		Assertions.assertEquals(test, doubleList.toString());

		doubleList.insertBefore(2, -2);
		Assertions.assertEquals(7, doubleList.size());
		test = "-1,0,1,-2,2,3,4";
		Assertions.assertEquals(test, doubleList.toString());

		doubleList.insertBefore(4, -4);
		Assertions.assertEquals(8, doubleList.size());
		test = "-1,0,1,-2,2,3,-4,4";
		Assertions.assertEquals(test, doubleList.toString());

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			doubleList.insertBefore(null, 1);
		});

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			doubleList.insertBefore(null, null);
		});

		Assertions.assertFalse(doubleList.insertBefore(10, 3));

		doubleList.clear();
		Assertions.assertEquals(0, doubleList.size());
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			doubleList.insertBefore(0, 2);
		});
	}

	@Test
	@DisplayName("在指定结点后插入结点")
	void insertAfter() {
		int[] a = { 0, 1, 2, 3, 4 };
		for (int t : a) {
			doubleList.addLast(t);
		}
		doubleList.insertAfter(0, -1);
		Assertions.assertEquals(6, doubleList.size());
		String test = "0,-1,1,2,3,4";
		Assertions.assertEquals(test, doubleList.toString());

		doubleList.insertAfter(2, -2);
		Assertions.assertEquals(7, doubleList.size());
		test = "0,-1,1,2,-2,3,4";
		Assertions.assertEquals(test, doubleList.toString());

		doubleList.insertAfter(4, -4);
		Assertions.assertEquals(8, doubleList.size());
		test = "0,-1,1,2,-2,3,4,-4";
		Assertions.assertEquals(test, doubleList.toString());

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			doubleList.insertAfter(null, 1);
		});

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			doubleList.insertAfter(null, null);
		});

		Assertions.assertFalse(doubleList.insertAfter(10, 3));

		doubleList.clear();
		Assertions.assertEquals(0, doubleList.size());
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			doubleList.insertAfter(0, 2);
		});
	}
}
