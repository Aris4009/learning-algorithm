package cn.my.chapter_1.bag;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 编写一个 RandomBag 类来实现这份 API。请注意，除了形容词随机之外，这份 API 和 Bag 的 API
 * 是相同的，这意味着迭代应该随机访问背包中的所有元素（对于每次迭代，所有的 N! 种排列出
 * 现的可能性均相同）。提示：用数组保存所有元素并在迭代器的构造函数中随机打乱它们的顺序。
 * 
 * @param <E>
 */
public class RandomBag<E> implements Iterable<E> {

	private Object[] array;

	private static final int DEFAULT = 16;

	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean add(E e) {
		if (isEmpty()) {
			array = new Object[DEFAULT];
		} else if (size == array.length) {
			Object[] n = new Object[array.length * 2];
			System.arraycopy(array, 0, n, 0, size);
			array = n;
		}
		array[size] = e;
		size = size + 1;
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new It();
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		Iterator<E> iterator = iterator();
		StringBuilder builder = new StringBuilder();
		while (iterator.hasNext()) {
			builder.append(iterator.next());
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

	class It implements Iterator<E> {

		private final Object[] shuffle;

		private int cursor;

		public It() {
			if (isEmpty()) {
				throw new IndexOutOfBoundsException();
			}
			Random random = new Random();
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
			return cursor < shuffle.length;
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
