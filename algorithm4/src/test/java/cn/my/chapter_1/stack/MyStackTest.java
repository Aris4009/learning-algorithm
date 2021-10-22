package cn.my.chapter_1.stack;

import java.security.InvalidParameterException;
import java.util.*;

import org.junit.jupiter.api.*;

import cn.hutool.core.util.StrUtil;
import cn.my.chapter_1.queue.MyQueue;

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

		@Test
		@DisplayName("1.3.2-给定以下输入，java Stack 的输出是什么？it was - the best - of times - - - it was - the - -")
		void print() {
			MyStack.MyStackArray<String> my = new MyStack.MyStackArray<>();
			String[] str = "it was - the best - of times - - - it was - the - -".split("\\s");
			StringBuilder builder = new StringBuilder();
			for (String s : str) {
				if (!s.equals("-")) {
					my.push(s);
				} else {
					builder.append(my.pop());
					builder.append(" ");
				}
			}
			String s = "was best times of the was the it ";
			Assertions.assertEquals(s, builder.toString());
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

		@Test
		@DisplayName("1.3.2-给定以下输入，java Stack 的输出是什么？it was - the best - of times - - - it was - the - -")
		void print() {
			MyStack.MyStackList<String> my = new MyStack.MyStackList<>();
			String[] str = "it was - the best - of times - - - it was - the - -".split("\\s");
			StringBuilder builder = new StringBuilder();
			for (String s : str) {
				if (!s.equals("-")) {
					my.push(s);
				} else {
					builder.append(my.pop());
					builder.append(" ");
				}
			}
			String s = "was best times of the was the it ";
			Assertions.assertEquals(s, builder.toString());
		}

		@Nested
		@DisplayName("编写一个 Stack 的用例 Parentheses，从标准输入中读取一个文本流并使用栈判定其中的括\n"
				+ "号是否配对完整。例如，对于 [()]{}{[()()]()} 程序应该打印 true，对于 [(]) 则打印\n" + "false。")
		class Parentheses {

			MyStack.MyStackList<String> myStackList;

			@BeforeEach
			void init() {
				myStackList = new MyStack.MyStackList<>();
			}

			@Test
			@DisplayName("[()]{}{[()()]()} 程序应该打印 true")
			void test1() {
				String a = "[()]{}{[()()]()}";
				Assertions.assertFalse(test(a));
			}

			@Test
			@DisplayName("[(]) 则打印false。")
			void test2() {
				String a = "[(])";
				Assertions.assertFalse(test(a));
			}

			private boolean test(String a) {
				if (Objects.isNull(a) || a.isEmpty()) {
					return false;
				}
				for (int i = 0; i < a.length(); i++) {
					String t = String.valueOf(a.charAt(i));
					if (match(a, "(", ")", myStackList)) {
						continue;
					}
					if (match(a, "[", "]", myStackList)) {
						continue;
					}
					if (match(a, "{", "}", myStackList)) {
						continue;
					}
					if (t.equals("[") || t.equals("{") || t.equals("(")) {
						myStackList.push(t);
					}
				}
				return myStackList.isEmpty();
			}

			private boolean isSign(String a, String sign) {
				return StrUtil.equals(a, sign);
			}

			private boolean match(String a, String left, String right, MyStack.MyStackList<String> stack) {
				return isSign(a, right) && !myStackList.isEmpty() && isSign(myStackList.pop(), left);
			}
		}

		@Nested
		@DisplayName("十进制转二进制")
		class NumberToBinary {

			@Test
			@DisplayName("输出50的二进制格式")
			void test() {
				MyStack.MyStackList<Integer> myStackList = new MyStack.MyStackList<>();
				int n = 50;
				while (n > 0) {
					myStackList.push(n % 2);
					n = n / 2;
				}
				String a = "110010";
				StringBuilder builder = new StringBuilder();
				for (Integer integer : myStackList) {
					builder.append(integer.toString());
				}
				Assertions.assertEquals(a, builder.toString());
			}
		}

		@Nested
		@DisplayName("使用栈逆序队列操作")
		class ReverseQueue {

			@Test
			@DisplayName("将队列1，2，3，4，5逆序为5，4，3，2，1")
			void test() {
				MyQueue<Integer> queue = new MyQueue<>();
				for (int i = 1; i <= 5; i++) {
					queue.enqueue(i);
				}

				MyStack.MyStackList<Integer> stack = new MyStack.MyStackList<>();
				while (!queue.isEmpty()) {
					stack.push(queue.dequeue());
				}

				while (!stack.isEmpty()) {
					queue.enqueue(stack.pop());
				}

				String a = "5,4,3,2,1";
				Assertions.assertEquals(a, queue.toString());
			}
		}
	}
}
