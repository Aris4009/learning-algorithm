package cn.my.chapter_3;

import java.security.InvalidParameterException;

/**
 * 二叉查找树
 * 
 * @param <K>
 * @param <V>
 */
public class BST<K extends Comparable<K>, V> {

	private static class Node<K, V> {

		private final K k;

		private V v;

		private Node<K, V> left;

		private Node<K, V> right;

		private int n;

		public Node(K k, V v, Node<K, V> left, Node<K, V> right, int n) {
			this.k = k;
			this.v = v;
			this.left = left;
			this.right = right;
			this.n = n;
		}
	}

	// 根结点
	private Node<K, V> root;

	private int size(Node<K, V> node) {
		if (node == null) {
			return 0;
		}
		return node.n;
	}

	public int size() {
		return size(root);
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void put(K k, V v) {
		root = put(root, k, v);
	}

	private Node<K, V> put(Node<K, V> node, K k, V v) {
		if (k == null) {
			throw new InvalidParameterException();
		}
		if (node == null) {
			return new Node<>(k, v, null, null, 1);
		} else {
			int cmp = node.k.compareTo(k);
			if (cmp > 0) {
				node.left = put(node.left, k, v);
			} else if (cmp < 0) {
				node.right = put(node.right, k, v);
			} else {
				node.v = v;
			}
		}
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

	public V get(K k) {
		return get(root, k);
	}

	private V get(Node<K, V> node, K k) {
		if (isEmpty() || node == null || k == null) {
			return null;
		}
		int cmp = node.k.compareTo(k);
		if (cmp > 0) {
			return get(node.left, k);
		} else if (cmp < 0) {
			return get(node.right, k);
		} else {
			return node.v;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		pre(root, builder);
		if (builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		return builder.toString();
	}

	/**
	 * 前序遍历
	 * 
	 * @param node    结点
	 * @param builder 字符串
	 */
	private void pre(Node<K, V> node, StringBuilder builder) {
		if (node == null) {
			return;
		}
		pre(node.left, builder);
		builder.append(node.k);
		builder.append(",");
		pre(node.right, builder);
	}
}
