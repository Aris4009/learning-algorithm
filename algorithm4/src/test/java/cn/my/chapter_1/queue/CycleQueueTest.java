package cn.my.chapter_1.queue;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试环形链表
 */
@DisplayName("测试环形链表")
public class CycleQueueTest {

	private CycleQueue<String> queue;

	@BeforeEach
	void init() {
		queue = new CycleQueue<>();
	}

	@Test
	@DisplayName("链表初始大小")
	void size() {
		Assertions.assertEquals(0, queue.size());
		Assertions.assertTrue(queue.isEmpty());
	}

	@Test
	@DisplayName("入队")
	void enqueue() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			queue.enqueue(String.valueOf(i));
			builder.append(String.valueOf(i)).append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		Assertions.assertEquals(20, queue.size());
		Assertions.assertFalse(queue.isEmpty());
		Assertions.assertEquals(builder.toString(), queue.toString());
	}

	@Test
	@DisplayName("出队")
	void dequeue() {
		for (int i = 0; i < 20; i++) {
			queue.enqueue(String.valueOf(i));
		}
		for (int i = 0; i < 20; i++) {
			Assertions.assertEquals(String.valueOf(i), queue.dequeue());
		}
		Assertions.assertEquals(0, queue.size());
		Assertions.assertTrue(queue.isEmpty());

		for (int i = 0; i < 5; i++) {
			queue.enqueue(String.valueOf(i));
		}
		String a = queue.dequeue();
		Assertions.assertEquals(4, queue.size());
		Assertions.assertEquals("0", a);
		queue.enqueue(a);
		Assertions.assertEquals(5, queue.size());
		String b = "1,2,3,4,0";
		Assertions.assertEquals(b, queue.toString());
	}

	@Test
	@DisplayName("迭代器")
	void iterator() {
		for (int i = 0; i < 20; i++) {
			queue.enqueue(String.valueOf(i));
		}
		StringBuilder builder = new StringBuilder();
		Iterator<String> iterator = queue.iterator();
		while (iterator.hasNext()) {
			builder.append(iterator.next());
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		Assertions.assertEquals(builder.toString(), queue.toString());
	}
}
