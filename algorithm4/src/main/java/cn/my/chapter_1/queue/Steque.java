package cn.my.chapter_1.queue;

import java.util.NoSuchElementException;

/**
 * 以栈为目标的队列，支持push,pop,enqueue操作
 * 
 * push、pop都是对队列同一端进行操作
 * 
 * enqueue操作的是队列的另一端
 */
public class Steque<E> {

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

	private Node<E> head;

	private Node<E> tail;

	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean push(E e) {
		if (isEmpty()) {
			head = new Node<>(e, null, null);
			tail = head;
		} else {
			Node<E> node = new Node<>(e, null, head);
			head.pre = node;
			head = node;
		}
		size = size + 1;
		return true;
	}

	public boolean pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<E> h = head;
		head = head.next;
		if (head != null) {
			head.pre = null;
		}
		h.e = null;
		h.next = null;
		size = size - 1;
		return true;
	}

	public boolean enqueue(E e) {
		if (isEmpty()) {
			return push(e);
		}
		Node<E> t = tail;
		Node<E> node = new Node<>(e, t, null);
		t.next = node;
		tail = node;
		size = size + 1;
		return true;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		Node<E> current = head;
		StringBuilder builder = new StringBuilder();
		while (current != null) {
			builder.append(current.e);
			builder.append(",");
			current = current.next;
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
}
