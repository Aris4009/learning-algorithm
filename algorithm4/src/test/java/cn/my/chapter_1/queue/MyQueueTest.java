package cn.my.chapter_1.queue;

import java.security.InvalidParameterException;
import java.util.*;

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
		for (int i = 0; i < 3; i++) {
			queue.add(String.valueOf(i));
		}
		Assertions.assertEquals(3, queue.size());
		queue.clear();
		Assertions.assertEquals(0, queue.size());
		for (int i = 0; i < 3; i++) {
			queue.add(String.valueOf(i));
		}
		Assertions.assertEquals(3, queue.size());
	}

	@Test
	@DisplayName("移除一个元素")
	void remove() {
		for (int i = 0; i < 5; i++) {
			queue.enqueue(String.valueOf(i));
		}
		Assertions.assertEquals(5, queue.size());

		// 移除中间结点
		Assertions.assertTrue(queue.remove("3"));
		Assertions.assertEquals(4, queue.size());
		String str = "0,1,2,4";
		Assertions.assertEquals(str, queue.toString());

		Assertions.assertTrue(queue.add("5"));
		Assertions.assertEquals(5, queue.size());
		str = "0,1,2,4,5";
		Assertions.assertEquals(str, queue.toString());

		// 移除头结点
		Assertions.assertTrue(queue.remove("0"));
		Assertions.assertEquals(4, queue.size());
		str = "1,2,4,5";
		Assertions.assertEquals(str, queue.toString());

		// 移除尾结点
		queue.enqueue("6");
		queue.remove("6");
		str = "1,2,4,5";
		Assertions.assertEquals(str, queue.toString());

		// 从头部遍历移除结点
		ListIterator<String> listIterator = queue.iterator();
		while (listIterator.hasNext()) {
			String s = listIterator.next();
			// 移除头结点
			if (s.equals("1")) {
				listIterator.remove();
			}
		}
		str = "2,4,5";
		Assertions.assertEquals(str, queue.toString());

		listIterator = queue.iterator();
		while (listIterator.hasNext()) {
			String s = listIterator.next();
			// 移除中间结点
			if (s.equals("4")) {
				listIterator.remove();
			}
		}
		str = "2,5";
		Assertions.assertEquals(str, queue.toString());

		listIterator = queue.iterator();
		while (listIterator.hasNext()) {
			String s = listIterator.next();
			// 移除尾结点
			if (s.equals("5")) {
				listIterator.remove();
			}
		}
		str = "2";
		Assertions.assertEquals(str, queue.toString());

		// 从尾部遍历结点
		queue.enqueue("6");
		queue.enqueue("7");
		listIterator = queue.iterator();
		while (listIterator.hasPrevious()) {
			String s = listIterator.previous();
			// 移除尾结点
			if (s.equals("7")) {
				listIterator.remove();
			}
		}
		str = "2,6";
		Assertions.assertEquals(str, queue.toString());
		queue.add("7");

		// 从中间移除结点
		listIterator = queue.iterator();
		while (listIterator.hasPrevious()) {
			String s = listIterator.previous();
			if (s.equals("6")) {
				listIterator.remove();
			}
		}
		str = "2,7";
		Assertions.assertEquals(str, queue.toString());

		// 移除头结点
		listIterator = queue.iterator();
		while (listIterator.hasPrevious()) {
			String s = listIterator.previous();
			if (s.equals("2")) {
				listIterator.remove();
			}
		}
		str = "7";
		Assertions.assertEquals(str, queue.toString());

		queue.add("8");
		queue.add("9");
		Assertions.assertEquals(3, queue.size());
		str = "7,8,9";
		Assertions.assertEquals(str, queue.toString());
	}
}
