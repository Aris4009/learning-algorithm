package cn.my.chapter_1.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 环形链表
 * 
 * @param <E>
 */
public class CycleQueue<E> implements Iterable<E> {

	private final Node<E> last;

	private int size;

	public CycleQueue() {
		last = new Node<>(null, null);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean enqueue(E e) {
		Node<E> node = new Node<>(e, null);
		if (isEmpty()) {
			last.next = node;
		} else {
			Node<E> l = last.next;
			while (l.next != null) {
				l = l.next;
			}
			l.next = node;
		}
		size = size + 1;
		return true;
	}

	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E e;
		e = last.next.e;
		Node<E> first = null;
		if (size > 1) {
			first = last.next.next;
		}
		last.next.e = null;
		last.next.next = null;
		last.next = first;
		size = size - 1;
		return e;
	}

	private class Node<E> {

		private E e;

		private Node<E> next;

		public Node(E e, Node<E> next) {
			this.e = e;
			this.next = next;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private Node<E> t = last;

			@Override
			public boolean hasNext() {
				return t.next != null;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				E e = t.next.e;
				t = t.next;
				return e;
			}
		};
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (E e : this) {
			builder.append(e);
			builder.append(",");
		}
		if (builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		return builder.toString();
	}
}
