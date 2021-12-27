package leetcode.editor.cn.my;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode init(Integer[] a) {
		if (a == null || a.length == 0) {
			throw new InvalidParameterException();
		}
		return helper(a, 0);
	}

	private static TreeNode helper(Integer[] a, int index) {
		if (index >= a.length) {
			return null;
		}
		Integer val = a[index];
		if (val == null) {
			return null;
		}
		TreeNode node = new TreeNode(a[index]);
		node.left = helper(a, index * 2 + 1);
		node.right = helper(a, index * 2 + 2);
		return node;
	}

	public static void preorder(TreeNode node, List<Integer> list) {
		if (list == null) {
			throw new InvalidParameterException();
		}
		if (node == null) {
			list.add(null);
			return;
		}
		list.add(node.val);
		preorder(node.left, list);
		preorder(node.right, list);
	}

	public static void inorder(TreeNode node, List<Integer> list) {
		if (list == null) {
			throw new InvalidParameterException();
		}
		if (node == null) {
			list.add(null);
			return;
		}
		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}

	public static void postorder(TreeNode node, List<Integer> list) {
		if (list == null) {
			throw new InvalidParameterException();
		}
		if (node == null) {
			list.add(null);
			return;
		}
		postorder(node.left, list);
		postorder(node.right, list);
		list.add(node.val);
	}

	public static void levelorder(TreeNode node, List<Integer> list) {
		if (list == null) {
			throw new InvalidParameterException();
		}
		if (node == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode n = queue.poll();
				if (n != null) {
					list.add(n.val);
					queue.offer(n.left);
					queue.offer(n.right);
				} else {
					list.add(null);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "[" + this.left + "," + this.val + "," + this.right + "]";
	}
}
