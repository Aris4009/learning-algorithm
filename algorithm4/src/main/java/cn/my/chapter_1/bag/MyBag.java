package cn.my.chapter_1.bag;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 实现背包功能
 * <p>
 * 存储元素的方式主要采用两种方式来实现，一种是数组，一种是链表。数组需考虑扩容问题。
 */
public class MyBag {

	private MyBag() {
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

		// 背包大小
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
			if (a == null) {
				throw new IllegalArgumentException();
			}
			if (a.length < size) {
				return (T[]) Arrays.copyOf(array, size, a.getClass());
			}
			System.arraycopy(array, 0, a, 0, size);
			return a;
		}

		@Override
		public boolean add(E e) {
			int l = array.length;
			if (size == Integer.MAX_VALUE) {
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
}
