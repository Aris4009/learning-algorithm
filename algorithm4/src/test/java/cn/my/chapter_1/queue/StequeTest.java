package cn.my.chapter_1.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Steque。一个以栈为目标的队列（或称 steque），是一种支持 push、pop 和 enqueue 操作的数 据类型。为这种抽象数据类型定义一份
 * API 并给出一份基于链表的实现。
 */
@DisplayName("测试Steque")
public class StequeTest {

	private Steque<Integer> stack;

	@BeforeEach
	void init() {
		stack = new Steque<>();
	}

	@Test
	@DisplayName("测试入栈")
	void push() {
		Assertions.assertEquals(0, stack.size());
		Assertions.assertTrue(stack.isEmpty());
		int[] a = { 1, 2, 3, 4, 5 };
		for (int t : a) {
			stack.push(t);
		}
		Assertions.assertEquals(5, stack.size());
		Assertions.assertFalse(stack.isEmpty());
		String b = "5,4,3,2,1";
		Assertions.assertEquals(b, stack.toString());
	}

	@Test
	@DisplayName("测试出栈")
	void pop() {
		int[] a = { 1, 2, 3, 4, 5 };
		for (int t : a) {
			stack.push(t);
		}

		for (int i = 0; i < 2; i++) {
			stack.pop();
		}
		Assertions.assertEquals(3, stack.size());
		Assertions.assertFalse(stack.isEmpty());
		String b = "3,2,1";
		Assertions.assertEquals(b, stack.toString());

		stack.push(1);
		Assertions.assertEquals(4, stack.size());
		b = "1,3,2,1";
		Assertions.assertEquals(b, stack.toString());

		while (stack.size() > 0) {
			stack.pop();
		}
		Assertions.assertEquals(0, stack.size());
		Assertions.assertTrue(stack.isEmpty());

		for (int t : a) {
			stack.enqueue(t);
		}
		Assertions.assertEquals(5, stack.size());
		Assertions.assertFalse(stack.isEmpty());
		b = "1,2,3,4,5";
		Assertions.assertEquals(b, stack.toString());
	}

	@Test
	@DisplayName("测试入队")
	void enqueue() {
		int[] a = { 1, 2, 3, 4, 5 };
		for (int t : a) {
			stack.enqueue(t);
		}
		Assertions.assertEquals(5, stack.size());
		Assertions.assertFalse(stack.isEmpty());
		String b = "1,2,3,4,5";
		Assertions.assertEquals(b, stack.toString());

		stack.pop();
		Assertions.assertEquals(4, stack.size());
		b = "2,3,4,5";
		Assertions.assertEquals(b, stack.toString());
	}
}
