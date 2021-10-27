package cn.my.chapter_1.list;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 链表的反转
 */
public class ReverseList<E> {

	private Node<E> head;

	private Node<E> tail;

	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void add(E e) {
		if (isEmpty()) {
			head = new Node<>(e, null);
			tail = head;
		} else {
			Node<E> node = new Node<>(e, null);
			Node<E> t = tail;
			t.next = node;
			tail = node;
		}
		size = size + 1;
	}

	public void reverse() {
		if (isEmpty()) {
			return;
		}
		if (size == 1) {
			return;
		}
		if (size == 2) {
			Node<E> h = head;
			Node<E> t = tail;
			h.next = null;
			t.next = h;
			head = t;
			tail = h;
			return;
		}
		Node<E> first = head;
		Node<E> reverse = tail;
		r(first, reverse);
		head = reverse;
	}

	private void r(Node<E> first, Node<E> reverse) {
		if (first != tail) {
			Node<E> f = first;
			Node<E> fn = first.next;
			Node<E> t = tail;
			Node<E> tn = tail.next;
			f.next = null;
			t.next = f;
			f.next = tn;
			first = fn;
			reverse = f;
			r(first, reverse);
		}
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		Node<E> current = head;
		builder.append("[");
		builder.append(current.e).append(",");
		while (current.next != null) {
			current = current.next;
			builder.append(" ");
			builder.append(current.e);
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * 链表
	 * 
	 * @param <E>
	 */
	private class Node<E> {

		private final E e;

		private Node<E> next;

		public Node(E e, Node<E> next) {
			this.e = e;
			this.next = next;
		}
	}

	@Test
	@DisplayName("编写一个函数，接受一条链表的首结点作为参数，（破坏性地）将链表反转并返回结果链表的\n" + "首结点。")
	void test() {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] b = { 7, 6, 5, 4, 3, 2, 1, 0 };
		Assertions.assertEquals(Arrays.toString(b), t(a));

		a = new int[] { 0 };
		Assertions.assertEquals(Arrays.toString(a), t(a));

		a = new int[] { 0, 1 };
		b = new int[] { 1, 0 };
		Assertions.assertEquals(Arrays.toString(b), t(a));
	}

	private String t(int[] a) {
		ReverseList<Integer> list = new ReverseList<>();
		for (int j : a) {
			list.add(j);
		}
		list.reverse();
		return list.toString();
	}
}
