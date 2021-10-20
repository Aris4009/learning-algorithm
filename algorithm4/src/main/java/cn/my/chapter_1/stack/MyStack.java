package cn.my.chapter_1.stack;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 实现一个后进先出的栈
 */
public class MyStack {

	private MyStack() {
	}

	/**
	 * 使用数组实现栈
	 */
	static class MyStackArray<E> implements Collection<E> {

		// 底层保存栈的元素
		private Object[] array;

		// 栈的大小
		private int size;

		// 默认栈的大小
		private static final int DEFAULT_SIZE = 16;

		/**
		 * 默认构造器，初始化栈的容量为16
		 */
		public MyStackArray() {
			array = new Object[DEFAULT_SIZE];
			this.size = 0;
		}

		/**
		 * 指定栈的容量
		 * 
		 * @param capacity 指定容量
		 */
		public MyStackArray(int capacity) {
			if (capacity <= 0) {
				throw new InvalidParameterException();
			}
			array = new Object[capacity];
			this.size = 0;
		}

		@Override
		public int size() {
			return this.size;
		}

		@Override
		public boolean isEmpty() {
			return this.size == 0;
		}

		/**
		 * 入栈，将入栈元素置于栈顶，如果数组已满，则数组容量扩大为当前容量的2倍
		 * 
		 * @param e 入栈元素
		 */
		public boolean push(E e) {
			if (size == Integer.MAX_VALUE) {
				throw new IndexOutOfBoundsException();
			}
			int l = array.length;
			if (size == l) {
				// 防止扩容溢出
				if (Integer.MAX_VALUE - l < l) {
					array = Arrays.copyOf(array, Integer.MAX_VALUE);
				} else {
					array = Arrays.copyOf(array, l * 2);
				}
			}
			array[size] = e;
			size = size + 1;
			return true;
		}

		/**
		 * 出栈操作，如果元素数量为当前数组大小的1/4，则将当前数组大小缩容为当前数组大小的1/2。
		 *
		 */
		@SuppressWarnings("unchecked")
		public E pop() {
			if (size == 0) {
				throw new NoSuchElementException();
			}
			E e = (E) array[size - 1];
			array[size - 1] = null;
			size = size - 1;
			if (size == array.length / 4) {
				array = Arrays.copyOf(array, array.length / 2);
			}
			return e;
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
		public Iterator<E> iterator() {
			return new Iterator<E>() {

				private int cursor = size;

				@Override
				public boolean hasNext() {
					return cursor != 0;
				}

				@Override
				@SuppressWarnings("unchecked")
				public E next() {
					if (cursor == 0) {
						throw new NoSuchElementException();
					}
					E e = (E) array[cursor - 1];
					cursor = cursor - 1;
					return e;
				}
			};
		}

		@Override
		public Object[] toArray() {
			int s = size;
			Object[] objects = new Object[s];
			for (int i = 0; i < size; i++) {
				objects[i] = array[s - 1];
				s = s - 1;
			}
			return objects;
		}

		@Override
		@SuppressWarnings("unchecked")
		public <T> T[] toArray(T[] a) {
			if (a == null) {
				throw new InvalidParameterException();
			}
			int n = Math.max(a.length, size);
			T[] copy = (a.getClass() == Object[].class) ? (T[]) new Object[n]
					: (T[]) Array.newInstance(a.getClass().getComponentType(), n);
			int s = size;
			for (int i = 0; i < copy.length; i++) {
				copy[i] = (T) array[s - 1];
				s = s - 1;
			}
			return copy;
		}

		@Override
		public boolean add(E e) {
			return push(e);
		}

		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
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
			if (c == null) {
				throw new InvalidParameterException();
			}
			for (E o : c) {
				add(o);
			}
			return true;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			Arrays.fill(array, null);
			array = new Object[DEFAULT_SIZE];
			this.size = 0;
		}

		@Override
		public String toString() {
			Iterator<E> iterator = iterator();
			StringBuilder builder = new StringBuilder();
			while (iterator.hasNext()) {
				builder.append(iterator.next().toString());
				builder.append(",");
			}
			builder.deleteCharAt(builder.length() - 1);
			return builder.toString();
		}
	}

	/**
	 * 使用链表实现栈
	 * 
	 * @param <E>
	 */
	static class MyStackList<E> implements Collection<E> {

		// 头结点
		private Node<E> head;

		// 栈容量
		private int size = 0;

		/**
		 * 结点
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
		 * 迭代器
		 * 
		 * @param <E>
		 */
		class It<E> implements Iterator<E> {

			private Node<E> h = (Node<E>) head;

			@Override
			public boolean hasNext() {
				return h != null;
			}

			@Override
			public E next() {
				if (h == null) {
					throw new NoSuchElementException();
				}
				E e = h.e;
				h = h.next;
				return e;
			}

			@Override
			public void remove() {
				if (hasNext()) {
					Node<E> node = h;
					Node<E> pre = h.pre;
					Node<E> next = h.next;
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
		}

		/**
		 * 入栈操作
		 * 
		 * @param e 入栈元素
		 * @return
		 */
		public boolean push(E e) {
			if (isEmpty()) {
				head = new Node<>(null, null, e);
			} else {
				Node<E> h = head;
				Node<E> node = new Node<>(null, h, e);
				h.pre = node;
				head = node;
			}
			size = size + 1;
			return true;
		}

		/**
		 * 出栈
		 *
		 */
		public E pop() {
			if (isEmpty()) {
				throw new NoSuchElementException();
			}
			Node<E> node = head;
			Node<E> next = head.next;
			E e = node.e;
			node.pre = null;
			node.next = null;
			node.e = null;
			if (next != null) {
				next.pre = null;
			}
			head = next;
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
			It<E> it = iterator();
			int i = 0;
			while (it.hasNext()) {
				objects[i] = it.next();
				i = i + 1;
			}
			return objects;
		}

		@Override
		@SuppressWarnings("unchecked")
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
			return push(e);
		}

		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
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
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			It<E> it = iterator();
			while (it.hasNext()) {
				it.remove();
			}
		}

		@Override
		public String toString() {
			It<E> it = iterator();
			StringBuilder builder = new StringBuilder();
			while (it.hasNext()) {
				builder.append(it.next().toString());
				builder.append(",");
			}
			builder.deleteCharAt(builder.length() - 1);
			return builder.toString();
		}
	}
}
