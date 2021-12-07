package leetcode.editor.cn.my;

import java.security.InvalidParameterException;

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
		return helper(a,0);
	}

	private static TreeNode helper(Integer[] a,int index) {
		if (index >= a.length) {
			return null;
		}
		Integer val = a[index];
		if (val==null){
			return null;
		}
		TreeNode node = new TreeNode(a[index]);
		node.left = helper(a, index * 2 + 1);
		node.right = helper(a, index * 2 + 2);
		return node;
	}

	@Override
	public String toString() {
		return "["+this.left+","+this.val+","+this.right+"]";
	}
}
