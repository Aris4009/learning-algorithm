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
		 * @return
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
		 * @return
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
			int n;
			if (a.length < size) {
				n = size;
			} else {
				n = a.length;
			}
			T[] copy = ((Object) a.getClass() == (Object) Object[].class) ? (T[]) new Object[n]
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
}
