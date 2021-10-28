package cn.my.chapter_1.queue;

import java.util.NoSuchElementException;

/**
 * 双端队列
 */
public class Dqueue<E> {

	class Node<E> {
		private E e;

		private Node<E> pre;

		private Node<E> next;

		public Node(E e, Node<E> pre, Node<E> next) {
			this.e = e;
			this.pre = pre;
			this.next = next;
		}
	}

	private Node<E> left;

	private Node<E> right;

	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean pushLeft(E e) {
		if (isEmpty()) {
			left = new Node<>(e, null, null);
			right = left;
		} else {
			Node<E> l = left;
			Node<E> node = new Node<>(e, null, l);
			l.pre = node;
			left = node;
		}
		size = size + 1;
		return true;
	}

	public boolean pushRight(E e) {
		if (isEmpty()) {
			return pushLeft(e);
		}
		Node<E> r = right;
		Node<E> node = new Node<>(e, r, null);
		r.next = node;
		right = node;
		size = size + 1;
		return true;
	}

	public E popLeft() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E e;
		if (size == 1) {
			e = left.e;
			left = null;
			right = null;
		} else {
			Node<E> l = left;
			left = left.next;
			e = l.e;
			l.next = null;
			l.e = null;
			left.pre = null;
		}
		size = size - 1;
		return e;
	}

	public E popRight() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (size == 1) {
			return popLeft();
		}
		Node<E> r = right;
		E e = r.e;
		right = right.pre;
		r.pre = null;
		r.e = null;
		right.next = null;
		size = size - 1;
		return e;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		Node<E> cursor = left;
		while (cursor != null) {
			builder.append(cursor.e);
			builder.append(",");
			cursor = cursor.next;
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
}
