package chapter1.bag;

import java.lang.reflect.Array;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现背包功能
 * <p>
 * 存储元素的方式主要采用两种方式来实现，一种是数组，一种是链表。数组需考虑扩容问题。
 */
public class MyBag {

	private static final Logger log = LoggerFactory.getLogger(MyBag.class);

	public static void main(String[] args) {
		testMyBagArray();
		testMyBagList();
	}

	private static void testMyBagArray() {
		MyBagArray<String> myBag = new MyBagArray<>();
		log.info("myBag size {}", myBag.size());
		for (int i = 0; i < 20; i++) {
			myBag.add(String.valueOf(i));
		}
		log.info("myBag size {},elements[{}]", myBag.size(), myBag);
		log.info("myBag contain 5? {}", myBag.contains("5"));

		List<String> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(String.valueOf(i));
		}
		myBag.addAll(list);
		log.info("myBag size {},elements[{}]", myBag.size(), myBag);
	}

	private static void testMyBagList() {
		MyBagList<String> myBag = new MyBagList<>();
		log.info("myBag size {}", myBag.size());
		for (int i = 0; i < 20; i++) {
			myBag.add(String.valueOf(i));
		}
		log.info("myBag size {},elements[{}]", myBag.size(), myBag);
		log.info("myBag contain 5? {}", myBag.contains("5"));

		List<String> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(String.valueOf(i));
		}
		myBag.addAll(list);
		log.info("myBag size {},elements[{}]", myBag.size(), myBag);
	}

	/**
	 * 背包的数组实现
	 *
	 * @param <E>
	 */
	static class MyBagArray<E> implements Collection<E> {

		// 保存背包元素
		private Object[] array;

		// 默认数组元素的大小
		private static final int DEFAULT_SIZE = 16;

		// 背包元素大小
		private int size = 0;

		// 默认集合
		public MyBagArray() {
			this.array = new Object[DEFAULT_SIZE];
		}

		// 指定集合元素大小
		public MyBagArray(int capacity) {
			if (capacity <= 0) {
				throw new IllegalArgumentException();
			}
			this.array = new Object[capacity];
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
			Iterator<E> iterator = iterator();
			if (o == null) {
				while (iterator.hasNext()) {
					if (iterator.next() == null) {
						return true;
					}
				}
			} else {
				while (iterator.hasNext()) {
					if (o.equals(iterator.next())) {
						return true;
					}
				}
			}
			return false;
		}

		@Override
		public Iterator<E> iterator() {

			return new Iterator<E>() {

				private int cur = 0;

				@Override
				public boolean hasNext() {
					return cur != size;
				}

				@Override
				@SuppressWarnings("unchecked")
				public E next() {
					if (cur >= size) {
						throw new NoSuchElementException();
					}
					E e = (E) array[cur];
					cur = cur + 1;
					return e;
				}
			};
		}

		@Override
		public Object[] toArray() {
			return Arrays.copyOf(array, size);
		}

		@Override
		@SuppressWarnings("unchecked")
		public <T> T[] toArray(T[] a) {
			if (a.length < size) {
				return (T[]) Arrays.copyOf(array, size, a.getClass());
			}
			System.arraycopy(array, 0, a, 0, size);
			return a;
		}

		@Override
		public boolean add(E e) {
			int l = array.length;
			if (l == Integer.MAX_VALUE) {
				throw new ArrayIndexOutOfBoundsException();
			}
			if (size == l) {
				int grow = l >> 1;
				int s;
				// 扩容数组，每次扩容当前大小的1.5倍，此处可能发生溢出
				if (Integer.MAX_VALUE - l >= grow) {
					s = l + grow;
				} else {
					s = Integer.MAX_VALUE;
				}
				array = Arrays.copyOf(array, s);
			}
			array[size] = e;
			size = size + 1;
			return true;
		}

		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			for (Object o : c) {
				if (!contains(o)) {
					return false;
				}
			}
			return true;
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			int l = c.size();
			// 防止溢出
			if (Integer.MAX_VALUE - size < l) {
				throw new ArrayIndexOutOfBoundsException();
			}
			Object[] a = c.toArray();
			System.arraycopy(a, 0, array, size, l);
			size = size + l;
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
			throw new UnsupportedOperationException();
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
	 * 背包，使用链表实现
	 * 
	 * @param <E>
	 */
	static class MyBagList<E> implements Collection<E> {

		private int size = 0;

		// 头节点
		private Node<E> head;

		// 尾结点
		private Node<E> tail;

		// 链表节点对象
		static class Node<E> {

			private E e;

			private Node<E> pre;

			private Node<E> next;

			public Node(E e, Node<E> pre, Node<E> next) {
				this.e = e;
				this.pre = pre;
				this.next = next;
			}
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
			Iterator<E> iterator = iterator();
			if (o == null) {
				while (iterator.hasNext()) {
					if (iterator.next() == null) {
						return true;
					}
				}
			} else {
				while (iterator.hasNext()) {
					if (o.equals(iterator.next())) {
						return true;
					}
				}
			}
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			return new Iterator<E>() {

				// 游标指向链表头结点
				private Node<E> cursor = head;

				@Override
				public boolean hasNext() {
					return cursor != null;
				}

				@Override
				public E next() {
					if (cursor == null) {
						throw new NoSuchElementException();
					}
					E e = cursor.e;
					cursor = cursor.next;
					return e;
				}

				public boolean hasPre() {
					return cursor != null;
				}

				public E pre() {
					if (cursor == null) {
						throw new NoSuchElementException();
					}
					E e = cursor.e;
					cursor = cursor.pre;
					return e;
				}
			};
		}

		@Override
		public Object[] toArray() {
			Object[] objects = new Object[size];
			int i = 0;
			Iterator<E> iterator = iterator();
			while (iterator.hasNext()) {
				Object o = iterator.next();
				objects[i] = o;
				i++;
			}
			return objects;
		}

		@Override
		@SuppressWarnings("unchecked")
		public <T> T[] toArray(T[] a) {
			if (a == null) {
				throw new IllegalArgumentException();
			}
			if (Integer.MAX_VALUE - a.length < size) {
				throw new IndexOutOfBoundsException();
			}
			if (a.length < size) {
				T[] arr = (T[]) Array.newInstance(a.getClass(), size);
				System.arraycopy(a, 0, arr, 0, a.length);
				a = arr;
			}
			int i = a.length - 1;
			Iterator<E> iterator = iterator();
			while (iterator.hasNext()) {
				E e = iterator.next();
				a[i] = (T) e;
				i++;
			}
			return a;
		}

		@Override
		public boolean add(E e) {
			if (head == null) {
				head = new Node<>(e, null, null);
			} else {
				if (tail == null) {
					tail = new Node<>(e, head, null);
					head.next = tail;
				} else {
					Node<E> node = new Node<>(e, tail, null);
					tail.next = node;
					tail = node;
				}
			}
			size = size + 1;
			return true;
		}

		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsAll(Collection<?> c) {
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
			throw new UnsupportedOperationException();
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
}
