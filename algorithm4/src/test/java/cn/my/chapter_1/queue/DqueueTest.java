package cn.my.chapter_1.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试双端队列
 */
@DisplayName("测试双端队列")
public class DqueueTest {

	private Dqueue<Integer> queue;

	@BeforeEach
	void init() {
		queue = new Dqueue<>();
	}

	@Test
	@DisplayName("测试向左端添加元素")
	void pushLeft() {
		Assertions.assertEquals(0, queue.size());
		Assertions.assertTrue(queue.isEmpty());
		int[] a = { 1, 2, 3, 4, 5 };
		for (int t : a) {
			queue.pushLeft(t);
		}
		Assertions.assertEquals(5, queue.size());
		Assertions.assertFalse(queue.isEmpty());
		String b = "5,4,3,2,1";
		Assertions.assertEquals(b, queue.toString());
	}

	@Test
	@DisplayName("测试向右端添加元素")
	void pushRight() {
		Assertions.assertEquals(0, queue.size());
		Assertions.assertTrue(queue.isEmpty());
		int[] a = { 1, 2, 3, 4, 5 };
		for (int t : a) {
			queue.pushRight(t);
		}
		Assertions.assertEquals(5, queue.size());
		Assertions.assertFalse(queue.isEmpty());
		String b = "1,2,3,4,5";
		Assertions.assertEquals(b, queue.toString());
	}

	@Test
	@DisplayName("测试向左端删除元素")
	void popLeft() {
		int[] a = { 1, 2, 3, 4, 5 };
		for (int t : a) {
			queue.pushRight(t);
		}
		for (int t : a) {
			Assertions.assertEquals(t, queue.popLeft());
		}
		Assertions.assertEquals(0, queue.size());
		Assertions.assertTrue(queue.isEmpty());
		pushLeft();
	}

	@Test
	@DisplayName("测试向右端删除元素")
	void popRight() {
		int[] a = { 1, 2, 3, 4, 5 };
		for (int t : a) {
			queue.pushLeft(t);
		}
		for (int t : a) {
			Assertions.assertEquals(t, queue.popRight());
		}
		Assertions.assertEquals(0, queue.size());
		Assertions.assertTrue(queue.isEmpty());
		pushRight();
	}
}
