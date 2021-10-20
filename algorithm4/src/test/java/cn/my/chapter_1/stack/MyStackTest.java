package cn.my.chapter_1.stack;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.*;

@DisplayName("测试栈用例")
public class MyStackTest {

	@Nested
	@DisplayName("测试数组实现")
	class MyStackArrayTest {

		private MyStack.MyStackArray<String> stack1;

		private MyStack.MyStackArray<String> stack2;

		@BeforeEach
		void init() {
			stack1 = new MyStack.MyStackArray<>();
			stack2 = new MyStack.MyStackArray<>(5);
		}

		@Test
		@DisplayName("入栈")
		void push() {
			Assertions.assertTrue(stack1.isEmpty());
			Assertions.assertEquals(0, stack1.size());
			for (int i = 0; i < 20; i++) {
				stack1.push(String.valueOf(i));
			}
			Assertions.assertEquals(20, stack1.size());
			Assertions.assertFalse(stack1.isEmpty());

			Assertions.assertTrue(stack2.isEmpty());
			Assertions.assertEquals(0, stack2.size());
			for (int i = 0; i < 20; i++) {
				stack2.push(String.valueOf(i));
			}
			Assertions.assertEquals(20, stack2.size());
			Assertions.assertFalse(stack2.isEmpty());

			List<String> list = new ArrayList<>();
			list.add("6");
			list.add("7");
			stack2.addAll(list);
			Assertions.assertEquals(22, stack2.size());
		}

		@Test
		@DisplayName("出栈")
		void pop() {
			int n = 20;
			for (int i = 0; i < n; i++) {
				stack1.push(String.valueOf(i));
			}
			Assertions.assertEquals("19", stack1.pop());
			Assertions.assertEquals("18", stack1.pop());
			Assertions.assertFalse(stack1.isEmpty());
			n = 18;
			Assertions.assertEquals(n, stack1.size());
			for (int i = 0; i < n; i++) {
				stack1.pop();
			}
			Assertions.assertEquals(0, stack1.size());
			Assertions.assertTrue(stack1.isEmpty());
		}

		@Test
		@DisplayName("是否包含某个元素")
		void contain() {
			Object o = null;
			Assertions.assertFalse(stack1.contains(o));
			stack1.add("4");
			stack1.add("5");
			Assertions.assertFalse(stack1.contains(o));
			Assertions.assertTrue(stack1.contains("5"));
			Assertions.assertFalse(stack1.contains("7"));
		}

		@Test
		@DisplayName("是否包含指定集合中的元素")
		void containAll() {
			Assertions.assertThrows(InvalidParameterException.class, () -> {
				boolean flag = stack1.containsAll(null);
			});
			Collection<String> c = new ArrayList<>();
			c.add("4");
			Assertions.assertFalse(stack1.containsAll(c));
			stack1.add("4");
			Assertions.assertTrue(stack1.containsAll(c));
		}

		@Test
		@DisplayName("迭代器")
		void iterator() {
			for (int i = 0; i < 5; i++) {
				stack1.add(String.valueOf(i));
			}
			Iterator<String> iterator = stack1.iterator();
			int i = 4;
			while (iterator.hasNext()) {
				Assertions.assertEquals(String.valueOf(i), iterator.next());
				i = i - 1;
			}
		}

		@Test
		@DisplayName("转换数组")
		void toArray() {
			int size = 10;
			Object[] objects = new Object[size];
			String[] str = new String[size];
			for (int i = 0; i < size; i++) {
				stack1.add(String.valueOf(i));
				objects[size - (i + 1)] = String.valueOf(i);
				str[size - (i + 1)] = String.valueOf(i);
			}
			Assertions.assertArrayEquals(objects, stack1.toArray());
			Assertions.assertArrayEquals(str, stack1.toArray(new String[0]));
		}

		@Test
		@DisplayName("打印数组")
		void toStr() {
			StringBuilder builder = new StringBuilder();
			int size = 30;
			for (int i = size - 1; i >= 0; i--) {
				builder.append(String.valueOf(i));
				builder.append(",");
			}
			for (int i = 0; i < size; i++) {
				stack1.push(String.valueOf(i));
			}
			builder.deleteCharAt(builder.length() - 1);
			Assertions.assertEquals(builder.toString(), stack1.toString());
		}

		@Test
		@DisplayName("清除栈中的所有元素")
		void clear() {
			for (int i = 0; i < 100; i++) {
				stack1.add(String.valueOf(i));
			}
			Assertions.assertEquals(100, stack1.size());
			stack1.clear();
			Assertions.assertEquals(0, stack1.size());
		}
	}

	@Nested
	@DisplayName("测试链表实现")
	class MyStackListTest {

		private MyStack.MyStackList<String> stack1;

		@BeforeEach
		void init() {
			stack1 = new MyStack.MyStackList<>();
		}

		@Test
		@DisplayName("入栈")
		void push() {
			Assertions.assertTrue(stack1.isEmpty());
			Assertions.assertEquals(0, stack1.size());
			for (int i = 0; i < 20; i++) {
				stack1.push(String.valueOf(i));
			}
			Assertions.assertEquals(20, stack1.size());
			Assertions.assertFalse(stack1.isEmpty());

			List<String> list = new ArrayList<>();
			list.add("6");
			list.add("7");
			stack1.addAll(list);
			Assertions.assertEquals(22, stack1.size());
		}

		@Test
		@DisplayName("出栈")
		void pop() {
			int n = 20;
			for (int i = 0; i < n; i++) {
				stack1.push(String.valueOf(i));
			}
			Assertions.assertEquals("19", stack1.pop());
			Assertions.assertEquals("18", stack1.pop());
			Assertions.assertFalse(stack1.isEmpty());
			n = 18;
			Assertions.assertEquals(n, stack1.size());
			for (int i = 0; i < n; i++) {
				stack1.pop();
			}
			Assertions.assertEquals(0, stack1.size());
			Assertions.assertTrue(stack1.isEmpty());
		}

		@Test
		@DisplayName("是否包含某个元素")
		void contain() {
			Object o = null;
			Assertions.assertFalse(stack1.contains(o));
			stack1.add("4");
			stack1.add("5");
			Assertions.assertFalse(stack1.contains(o));
			Assertions.assertTrue(stack1.contains("5"));
			Assertions.assertFalse(stack1.contains("7"));
		}

		@Test
		@DisplayName("是否包含指定集合中的元素")
		void containAll() {
			Assertions.assertThrows(InvalidParameterException.class, () -> {
				boolean flag = stack1.containsAll(null);
			});
			Collection<String> c = new ArrayList<>();
			c.add("4");
			Assertions.assertFalse(stack1.containsAll(c));
			stack1.add("4");
			Assertions.assertTrue(stack1.containsAll(c));
		}

		@Test
		@DisplayName("迭代器")
		void iterator() {
			for (int i = 0; i < 5; i++) {
				stack1.add(String.valueOf(i));
			}
			Iterator<String> iterator = stack1.iterator();
			int i = 4;
			while (iterator.hasNext()) {
				Assertions.assertEquals(String.valueOf(i), iterator.next());
				i = i - 1;
			}
		}

		@Test
		@DisplayName("转换数组")
		void toArray() {
			int size = 10;
			Object[] objects = new Object[size];
			String[] str = new String[size];
			for (int i = 0; i < size; i++) {
				stack1.add(String.valueOf(i));
				objects[size - (i + 1)] = String.valueOf(i);
				str[size - (i + 1)] = String.valueOf(i);
			}
			Assertions.assertArrayEquals(objects, stack1.toArray());
			Assertions.assertArrayEquals(str, stack1.toArray(new String[0]));
		}

		@Test
		@DisplayName("打印数组")
		void toStr() {
			StringBuilder builder = new StringBuilder();
			int size = 30;
			for (int i = size - 1; i >= 0; i--) {
				builder.append(String.valueOf(i));
				builder.append(",");
			}
			for (int i = 0; i < size; i++) {
				stack1.push(String.valueOf(i));
			}
			builder.deleteCharAt(builder.length() - 1);
			Assertions.assertEquals(builder.toString(), stack1.toString());
		}

		@Test
		@DisplayName("清除栈中的所有元素")
		void clear() {
			for (int i = 0; i < 100; i++) {
				stack1.add(String.valueOf(i));
			}
			Assertions.assertEquals(100, stack1.size());
			stack1.clear();
			Assertions.assertEquals(0, stack1.size());
			for (int i = 0; i < 100; i++) {
				stack1.add(String.valueOf(i));
			}
			Assertions.assertEquals(100, stack1.size());
		}
	}
}
