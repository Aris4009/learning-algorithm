package cn.my.chapter_3;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 基于链表实现的泛型符号表
 * 
 * @param <K>
 * @param <V>
 */
public class SequentialSt<K extends Comparable<K>, V> {

	private static class Node<K, V> {

		private K key;

		private V value;

		private Node<K, V> pre;

		private Node<K, V> next;

		public Node(K key, V value, Node<K, V> pre, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.pre = pre;
			this.next = next;
		}
	}

	private int size;

	private Node<K, V> first;

	public void put(K key, V value) {
		if (key == null) {
			throw new InvalidParameterException();
		}
		if (isEmpty()) {
			first = new Node<>(key, value, null, null);
			size = size + 1;
		} else {
			Node<K, V> cursor = first;
			if (size == 1) {
				if (cursor.key.compareTo(key) == 0) {
					cursor.value = value;
				} else {
					cursor.next = new Node<>(key, value, cursor, null);
					size = size + 1;
				}
				return;
			}
			while (cursor.next != null) {
				if (cursor.key.compareTo(key) == 0) {
					cursor.value = value;
					return;
				}
				cursor = cursor.next;
			}
			cursor.next = new Node<>(key, value, cursor, null);
			size = size + 1;
		}
	}

	public V get(K key) {
		if (key == null || isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<K, V> cursor = first;
		while (cursor != null) {
			if (cursor.key.compareTo(key) == 0) {
				return cursor.value;
			}
			cursor = cursor.next;
		}
		return null;
	}

	public void delete(K key) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (key == null) {
			throw new NoSuchElementException();
		}
		Node<K, V> cursor = first;
		boolean flag = false;
		while (cursor != null) {
			if (cursor.key.compareTo(key) == 0) {
				flag = true;
				break;
			}
			cursor = cursor.next;
		}
		if (flag) {
			if (cursor == first) {
				first = first.next;
				cursor.key = null;
				cursor.value = null;
				cursor.next = null;
				if (first != null) {
					first.pre = null;
				}
			} else {
				Node<K, V> pre = cursor.pre;
				Node<K, V> next = cursor.next;
				pre.next = next;
				if (next != null) {
					next.pre = pre;
				}
			}
			size = size - 1;
		}
	}

	public boolean contains(K key) {
		return get(key) != null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public Iterable<K> keys() {
		return keys(min(), max());
	}

	public K min() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<K, V> cursor = first;
		K min = cursor.key;
		while (cursor != null) {
			if (min.compareTo(cursor.key) > 0) {
				min = cursor.key;
			}
			cursor = cursor.next;
		}
		return min;
	}

	public K max() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<K, V> cursor = first;
		K max = cursor.key;
		while (cursor != null) {
			if (max.compareTo(cursor.key) < 0) {
				max = cursor.key;
			}
			cursor = cursor.next;
		}
		return max;
	}

	public K floor(K key) {
		if (isEmpty() || key == null) {
			throw new NoSuchElementException();
		}
		Node<K, V> cursor = first;
		SequentialSt<K, V> s = new SequentialSt<>();
		while (cursor != null) {
			if (cursor.key.compareTo(key) <= 0) {
				s.put(cursor.key, cursor.value);
			}
			cursor = cursor.next;
		}
		return s.max();
	}

	public K celling(K key) {
		if (isEmpty() || key == null) {
			throw new NoSuchElementException();
		}
		Node<K, V> cursor = first;
		SequentialSt<K, V> s = new SequentialSt<>();
		while (cursor != null) {
			if (cursor.key.compareTo(key) >= 0) {
				s.put(cursor.key, cursor.value);
			}
			cursor = cursor.next;
		}
		return s.min();
	}

	public int rank(K key) {
		if (isEmpty() || key == null) {
			throw new NoSuchElementException();
		}
		Node<K, V> cursor = first;
		int n = 0;
		while (cursor != null) {
			if (cursor.key.compareTo(key) < 0) {
				n++;
			}
			cursor = cursor.next;
		}
		return n;
	}

	public K select(int k) {
		if (isEmpty() || k < 0 || k >= size) {
			throw new NoSuchElementException();
		}
		K key = null;
		Node<K, V> cursor = first;
		while (cursor != null && k >= 0) {
			key = cursor.key;
			k--;
			cursor = cursor.next;
		}
		return key;
	}

	public void deleteMin() {
		delete(min());
	}

	public void deleteMax() {
		delete(max());
	}

	public int size(K low, K high) {
		if (isEmpty() || low == null || high == null) {
			throw new NoSuchElementException();
		}
		if (high.compareTo(low) < 0) {
			return 0;
		}
		int n = 0;
		Node<K, V> cursor = first;
		while (cursor != null) {
			if (cursor.key.compareTo(low) >= 0 && cursor.key.compareTo(high) <= 0) {
				n++;
			}
			cursor = cursor.next;
		}
		return n;
	}

	public Iterable<K> keys(K low, K high) {
		if (isEmpty() || low == null || high == null || high.compareTo(low) < 0) {
			throw new NoSuchElementException();
		}
		return new Iterable<K>() {
			@Override
			public Iterator<K> iterator() {
				return new It();
			}

			class It implements Iterator<K> {

				private SequentialSt<K, V> s = new SequentialSt<>();

				private Node<K, V> c = null;

				public It() {
					Node<K, V> cursor = first;
					while (cursor != null) {
						if (cursor.key.compareTo(low) >= 0 && cursor.key.compareTo(high) <= 0) {
							s.put(cursor.key, cursor.value);
						}
						cursor = cursor.next;
					}
					c = s.first;
				}

				@Override
				public boolean hasNext() {
					return c != null;
				}

				@Override
				public K next() {
					if (c == null) {
						throw new NoSuchElementException();
					}
					K key = c.key;
					c = c.next;
					return key;
				}
			}
		};
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		Node<K, V> node = first;
		StringBuilder builder = new StringBuilder();
		while (node != null) {
			builder.append("{");
			builder.append(node.key);
			builder.append(":");
			builder.append(node.value);
			builder.append("}");
			builder.append(",");
			node = node.next;
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
}
