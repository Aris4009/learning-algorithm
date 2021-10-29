package cn.my.chapter_1.queue;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 实现泛型一般队列
 * 
 * @param <E>
 */
public class GeneralizedQueue<E> {

	private Object[] array;

	private int size;

	private static final int DEFAULT = 16;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void insert(E e) {
		if (e == null) {
			throw new InvalidParameterException();
		}
		if (isEmpty()) {
			array = new Object[DEFAULT];
		} else if (size == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
		array[size] = e;
		size = size + 1;
	}

	@SuppressWarnings("unchecked")
	public E delete(int k) {
		if (isEmpty() || k < 0 || k >= size) {
			throw new NoSuchElementException();
		}
		E e = (E) array[k];
		System.arraycopy(array, k + 1, array, k, size - k - 1);
		size = size - 1;
		array[size] = null;
		if (size < array.length / 4) {
			array = Arrays.copyOf(array, array.length / 2);
		}
		return e;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(array[i]);
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
}
