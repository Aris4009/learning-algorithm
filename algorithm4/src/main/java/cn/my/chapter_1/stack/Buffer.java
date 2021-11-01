package cn.my.chapter_1.stack;

import java.util.Iterator;

/**
 * 文本编辑器的缓冲区。为文本编辑器的缓冲区设计一种数据类型并实现表 1.3.13 中的 API。
 */
public class Buffer implements Iterable<Character> {

	// 光标左边的栈
	private MyStack.MyStackArray<Character> left;

	// 光标右边的栈
	private MyStack.MyStackArray<Character> right;

	// 当前光标所在位置
	private int cursor;

	private int size;

	public Buffer() {
		left = new MyStack.MyStackArray<>();
		right = new MyStack.MyStackArray<>();
	}

	public void insert(char c) {
		left.push(c);
		cursor = cursor + 1;
		size = size + 1;
	}

	public Character delete() {
		if (cursor == 0) {
			return null;
		}
		char c = left.pop();
		cursor = cursor - 1;
		size = size - 1;
		return c;
	}

	public void left(int k) {
		if (k < 0) {
			return;
		}
		if (k > left.size()) {
			k = left.size();
		}
		for (int i = 0; i < k; i++) {
			right.push(left.pop());
		}
		cursor = cursor - k;
	}

	public void right(int k) {
		if (k < 0) {
			return;
		}
		if (k > right.size()) {
			k = right.size();
		}
		for (int i = 0; i < k; i++) {
			left.push(right.pop());
		}
		cursor = cursor + k;
	}

	public int size() {
		return size;
	}

	public int cursor() {
		return cursor;
	}

	@Override
	public Iterator<Character> iterator() {
		return new It();
	}

	@Override
	public String toString() {
		if (size < 1) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for (Character c : this) {
			builder.append(c);
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

	private class It implements Iterator<Character> {

		private final Iterator<Character> iterator;

		public It() {
			MyStack.MyStackArray<Character> stack = new MyStack.MyStackArray<>();
			Iterator<Character> r = right.reverseIterator();
			while (r.hasNext()) {
				stack.push(r.next());
			}
			for (Character character : left) {
				stack.push(character);
			}
			iterator = stack.iterator();
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public Character next() {
			return iterator.next();
		}
	}
}
