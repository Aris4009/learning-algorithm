package cn.my.chapter_1.stack;

import java.security.InvalidParameterException;

/**
 * 复制栈。为基于链表实现的栈编写一个新的构造函数，使以下代码 Stack<Item> t = new Stack<Item>(s); 得到的 t 指向栈 s
 * 的一个新的独立的副本。
 */
public class CopyStack {

	public static <E> MyStack.MyStackArray<E> copy(MyStack.MyStackArray<E> q) {
		if (q == null || q.isEmpty()) {
			throw new InvalidParameterException();
		}
		return new MyStack.MyStackArray<>(q);
	}
}
