package cn.my.chapter_1.queue;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 使用链表实现队列
 * 
 * @param <E>
 */
public class MyQueue<E> implements Collection<E> {

	// 队列头
	private Node<E> head;

	// 队列尾
	private Node<E> tail;

	// 队列大小
	private int size;

	/**
	 * 链表结点数据结构定义
	 * 
	 * @param <E>
	 */
	private static class Node<E> {

		private Node<E> pre;

		private Node<E> next;

		private E e;

		public Node(Node<E> pre, Node<E> next, E e) {
			this.pre = pre;
			this.next = next;
			this.e = e;
		}
	}

	/**
	 * 链表迭代器
	 *
	 */
	class It<E> implements Iterator<E> {

		private Node<E> h = (Node<E>) head;

		@Override
		public boolean hasNext() {
			return h != null;
		}

		@Override
		public E next() {
			if (isEmpty()) {
				throw new NoSuchElementException();
			}
			Node<E> node = h;
			E e = node.e;
			h = h.next;
			return e;
		}

		@Override
		public void remove() {
			Node<E> node = h;
			Node<E> pre = node.pre;
			Node<E> next = node.next;
			if (pre != null) {
				pre.next = next;
			}
			if (next != null) {
				next.pre = pre;
			}
			h = next;
			node.pre = null;
			node.next = null;
			node.e = null;
			size = size - 1;
		}
	}

	/**
	 * 入队操作
	 * 
	 * @param e
	 */
	public boolean enqueue(E e) {
		if (isEmpty()) {
			head = new Node<>(null, null, e);
			tail = head;
		} else {
			Node<E> t = tail;
			Node<E> node = new Node<>(t, null, e);
			t.next = node;
			tail = node;
		}
		size = size + 1;
		return true;
	}

	/**
	 * 出队操作
	 *
	 */
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<E> node = head;
		Node<E> next = head.next;
		if (next != null) {
			next.pre = null;
		}
		head = next;
		E e = node.e;
		node.next = null;
		node.pre = null;
		size = size - 1;
		return e;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			for (E e : this) {
				if (e == null) {
					return true;
				}
			}
		} else {
			for (E e : this) {
				if (o.equals(e)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public It<E> iterator() {
		return new It<>();
	}

	@Override
	public Object[] toArray() {
		Object[] objects = new Object[size];
		int i = 0;
		for (E e : this) {
			objects[i] = e;
			i = i + 1;
		}
		return objects;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (a == null) {
			throw new InvalidParameterException();
		}
		int n = Math.max(a.length, size);
		T[] copy = ((Object) a.getClass() == (Object) Object[].class) ? (T[]) new Object[n]
				: (T[]) Array.newInstance(a.getClass().getComponentType(), n);
		int i = 0;
		for (E e : this) {
			copy[i] = (T) e;
			i = i + 1;
		}
		return copy;
	}

	@Override
	public boolean add(E e) {
		return enqueue(e);
	}

	@Override
	public boolean remove(Object o) {
		if (o == null) {
			return removeIf(Objects::isNull);
		} else {
			return removeIf(o::equals);
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (c == null) {
			throw new InvalidParameterException();
		}
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E e : c) {
			add(e);
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object o : c) {
			remove(o);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		removeIf(e -> !c.contains(e));
		return true;
	}

	@Override
	public void clear() {
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			iterator.remove();
		}
	}

	@Override
	public String toString() {
		Iterator<E> it = iterator();
		StringBuilder builder = new StringBuilder();
		while (it.hasNext()) {
			builder.append(it.next().toString());
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
}
