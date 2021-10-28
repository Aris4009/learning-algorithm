package cn.my.chapter_1.list;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

/**
 * 双向链表
 * 
 * @param <E>
 */
public class DoubleList<E> {

	private class DoubleNode<E> {

		private E e;

		private DoubleNode<E> pre;

		private DoubleNode<E> next;

		public DoubleNode(E e, DoubleNode<E> pre, DoubleNode<E> next) {
			this.e = e;
			this.pre = pre;
			this.next = next;
		}
	}

	private DoubleNode<E> head;

	private DoubleNode<E> last;

	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean addFirst(E e) {
		if (e == null) {
			throw new InvalidParameterException();
		}
		if (isEmpty()) {
			head = new DoubleNode<>(e, null, null);
			last = head;
		} else {
			DoubleNode<E> oldFirst = head;
			DoubleNode<E> node = new DoubleNode<>(e, null, oldFirst);
			oldFirst.pre = node;
			head = node;
		}
		size = size + 1;
		return true;
	}

	public boolean addLast(E e) {
		if (e == null) {
			throw new InvalidParameterException();
		}
		if (isEmpty()) {
			head = new DoubleNode<>(e, null, null);
			last = head;
		} else {
			DoubleNode<E> oldLast = last;
			DoubleNode<E> node = new DoubleNode<>(e, oldLast, null);
			oldLast.next = node;
			last = node;
		}
		size = size + 1;
		return true;
	}

	public void removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		DoubleNode<E> oldFirst = head;
		head = head.next;
		if (head != null) {
			head.pre = null;
		}
		oldFirst.next = null;
		oldFirst.e = null;
		size = size - 1;
	}

	public void removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		DoubleNode<E> oldLast = last;
		last = last.pre;
		if (last != null) {
			last.next = null;
		}
		oldLast.pre = null;
		oldLast.e = null;
		size = size - 1;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		DoubleNode<E> h = head;
		while (h != null) {
			builder.append(h.e);
			builder.append(",");
			h = h.next;
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

	public boolean insertBefore(E e, E n) {
		if (e == null || n == null || isEmpty()) {
			throw new NoSuchElementException();
		}
		DoubleNode<E> cursor = head;
		while (cursor != null) {
			if (cursor.e.equals(e)) {
				if (cursor == head) {
					addFirst(n);
				} else {
					DoubleNode<E> pre = cursor.pre;
					DoubleNode<E> node = new DoubleNode<>(n, pre, cursor);
					pre.next = node;
					cursor.pre = node;
					size = size + 1;
				}
				return true;
			} else {
				cursor = cursor.next;
			}
		}
		return false;
	}

	public boolean insertAfter(E e, E n) {
		if (e == null || n == null || isEmpty()) {
			throw new NoSuchElementException();
		}
		DoubleNode<E> cursor = head;
		while (cursor != null) {
			if (cursor.e.equals(e)) {
				if (cursor == last) {
					addLast(n);
				} else {
					DoubleNode<E> next = cursor.next;
					DoubleNode<E> node = new DoubleNode<>(n, cursor, next);
					next.pre = node;
					cursor.next = node;
					size = size + 1;
				}
				return true;
			} else {
				cursor = cursor.next;
			}
		}
		return false;
	}

	public void clear() {
		if (isEmpty()) {
			return;
		}
		DoubleNode<E> cursor = head;
		while (cursor != null) {
			DoubleNode<E> next = cursor.next;
			cursor.pre = null;
			cursor.e = null;
			cursor.next = null;
			cursor = next;
			size = size - 1;
		}
		head = null;
		last = null;
	}
}
