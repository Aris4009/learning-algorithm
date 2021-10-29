package cn.my.chapter_1.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试泛型一般队列
 */
public class GeneralizedQueueTest {

	GeneralizedQueue<Integer> queue;

	@BeforeEach
	void init() {
		queue = new GeneralizedQueue<>();
	}

	@Test
	@DisplayName("测试插入")
	void insert() {
		int a = 10;
		for (int i = 0; i < a; i++) {
			queue.insert(i);
		}
		Assertions.assertEquals(10, queue.size());
		Assertions.assertFalse(queue.isEmpty());
		String b = "0,1,2,3,4,5,6,7,8,9";
		Assertions.assertEquals(b, queue.toString());
	}

	@Test
	@DisplayName("测试删除")
	void delete() {
		int a = 10;
		for (int i = 0; i < a; i++) {
			queue.insert(i);
		}
		Assertions.assertEquals(10, queue.size());

		int a1 = queue.delete(0);
		Assertions.assertEquals(0, a1);
		Assertions.assertEquals(9, queue.size());
		String b = "1,2,3,4,5,6,7,8,9";
		Assertions.assertEquals(b, queue.toString());

		a1 = queue.delete(5);
		Assertions.assertEquals(6, a1);
		Assertions.assertEquals(8, queue.size());
		b = "1,2,3,4,5,7,8,9";
		Assertions.assertEquals(b, queue.toString());
	}
}
