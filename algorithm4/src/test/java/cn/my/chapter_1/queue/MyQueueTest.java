package cn.my.chapter_1.queue;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 队列测试用例
 */
@DisplayName("队列测试用例")
public class MyQueueTest {

	private MyQueue<String> queue;

	@BeforeEach
	void init() {
		queue = new MyQueue<>();
	}

	@Test
	@DisplayName("入队")
	void push() {
		Assertions.assertTrue(queue.isEmpty());
		Assertions.assertEquals(0, queue.size());
		for (int i = 0; i < 20; i++) {
			queue.enqueue(String.valueOf(i));
		}
		Assertions.assertEquals(20, queue.size());
		Assertions.assertFalse(queue.isEmpty());

		List<String> list = new ArrayList<>();
		list.add("6");
		list.add("7");
		queue.addAll(list);
		Assertions.assertEquals(22, queue.size());
	}

	@Test
	@DisplayName("出队")
	void pop() {
		int n = 20;
		for (int i = 0; i < n; i++) {
			queue.enqueue(String.valueOf(i));
		}
		Assertions.assertEquals("0", queue.dequeue());
		Assertions.assertEquals("1", queue.dequeue());
		Assertions.assertFalse(queue.isEmpty());
		n = 18;
		Assertions.assertEquals(n, queue.size());
		for (int i = 0; i < n; i++) {
			queue.dequeue();
		}
		Assertions.assertEquals(0, queue.size());
		Assertions.assertTrue(queue.isEmpty());
	}

	@Test
	@DisplayName("是否包含某个元素")
	void contain() {
		Object o = null;
		Assertions.assertFalse(queue.contains(o));
		queue.add("4");
		queue.add("5");
		Assertions.assertFalse(queue.contains(o));
		Assertions.assertTrue(queue.contains("5"));
		Assertions.assertFalse(queue.contains("7"));
	}

	@Test
	@DisplayName("是否包含指定集合中的元素")
	void containAll() {
		Assertions.assertThrows(InvalidParameterException.class, () -> {
			boolean flag = queue.containsAll(null);
		});
		Collection<String> c = new ArrayList<>();
		c.add("4");
		Assertions.assertFalse(queue.containsAll(c));
		queue.add("4");
		Assertions.assertTrue(queue.containsAll(c));
	}

	@Test
	@DisplayName("迭代器")
	void iterator() {
		for (int i = 0; i < 5; i++) {
			queue.add(String.valueOf(i));
		}
		Iterator<String> iterator = queue.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Assertions.assertEquals(String.valueOf(i), iterator.next());
			i = i + 1;
		}
	}

	@Test
	@DisplayName("转换数组")
	void toArray() {
		int size = 10;
		Object[] objects = new Object[size];
		String[] str = new String[size];
		for (int i = 0; i < size; i++) {
			queue.add(String.valueOf(i));
			objects[i] = String.valueOf(i);
			str[i] = String.valueOf(i);
		}
		Assertions.assertArrayEquals(objects, queue.toArray());
		Assertions.assertArrayEquals(str, queue.toArray(new String[0]));
	}

	@Test
	@DisplayName("打印数组")
	void toStr() {
		StringBuilder builder = new StringBuilder();
		int size = 30;
		for (int i = 0; i < size; i++) {
			builder.append(String.valueOf(i));
			builder.append(",");
		}
		for (int i = 0; i < size; i++) {
			queue.enqueue(String.valueOf(i));
		}
		builder.deleteCharAt(builder.length() - 1);
		Assertions.assertEquals(builder.toString(), queue.toString());
	}

	@Test
	@DisplayName("清除队列中的所有元素")
	void clear() {
		for (int i = 0; i < 100; i++) {
			queue.add(String.valueOf(i));
		}
		Assertions.assertEquals(100, queue.size());
		queue.clear();
		Assertions.assertEquals(0, queue.size());
		for (int i = 0; i < 100; i++) {
			queue.add(String.valueOf(i));
		}
		Assertions.assertEquals(100, queue.size());
	}

}
