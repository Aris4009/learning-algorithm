package cn.my.chapter_1.queue;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.*;

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
	class It implements ListIterator<E> {

		private Node<E> h = head;

		private Node<E> t = tail;

		private Node<E> cursor;

		@Override
		public boolean hasNext() {
			return h != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			cursor = h;
			h = h.next;
			return cursor.e;
		}

		@Override
		public boolean hasPrevious() {
			return t != null;
		}

		@Override
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			cursor = t;
			t = t.pre;
			return cursor.e;
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			if (cursor == null) {
				throw new NoSuchElementException();
			}
			Node<E> pre = cursor.pre;
			Node<E> next = cursor.next;
			// 删除头结点、尾结点、中间节点
			if (cursor == head) {
				head = next;
				if (next != null) {
					next.pre = null;
				} else {
					tail = null;
				}
			} else if (cursor == tail) {
				tail = pre;
				if (pre != null) {
					pre.next = null;
				} else {
					head = null;
				}
			} else {
				pre.next = next;
				next.pre = pre;
			}
			cursor.pre = null;
			cursor.next = null;
			cursor.e = null;
			cursor = null;
			size = size - 1;
		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException();
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
	public ListIterator<E> iterator() {
		return new It();
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
			iterator.next();
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
