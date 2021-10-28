package cn.my.chapter_1.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 随机队列
 * 
 * @param <E>
 */
public class RandomQueue<E> implements Iterable<E> {

	private Random random = new Random();

	private Object[] array;

	private int size;

	private static final int DEFAULT = 16;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean enqueue(E e) {
		if (isEmpty()) {
			array = new Object[DEFAULT];
		} else if (size == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
		array[size] = e;
		size = size + 1;
		return true;
	}

	@SuppressWarnings("unchecked")
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int r = random.nextInt(size);
		Object temp = array[r];
		Object oldLast = array[size - 1];
		E e;
		if (temp != oldLast) {
			array[r] = oldLast;
			array[size - 1] = temp;
		}
		e = (E) temp;
		array[size - 1] = null;
		size = size - 1;
		if (size < array.length / 4) {
			array = Arrays.copyOf(array, array.length / 2);
		}
		return e;
	}

	@SuppressWarnings("unchecked")
	public E sample() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return (E) array[random.nextInt(size)];
	}

	@Override
	public Iterator<E> iterator() {
		return new It();
	}

	class It implements Iterator<E> {

		private Object[] shuffle;

		private int cursor;

		public It() {
			if (isEmpty()) {
				throw new IndexOutOfBoundsException();
			}
			shuffle = Arrays.copyOf(array, size);
			for (int i = shuffle.length - 1; i >= 0; i--) {
				int r = random.nextInt(i + 1);
				Object temp = shuffle[i];
				shuffle[i] = shuffle[r];
				shuffle[r] = temp;
			}
		}

		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		@SuppressWarnings("unchecked")
		public E next() {
			if (isEmpty()) {
				throw new NoSuchElementException();
			}
			E e = (E) shuffle[cursor];
			cursor = cursor + 1;
			return e;
		}
	}
}
