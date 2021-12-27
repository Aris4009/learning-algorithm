//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 467 👎 0

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.my.TreeNode;

public class AllNodesDistanceKInBinaryTree {
	public static void main(String[] args) {
		Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
		TreeNode root = new TreeNode(3,
				new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
				new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		List<Integer> preorder = new LinkedList<>();
		TreeNode.preorder(root, preorder);
		System.out.println(Arrays.toString(preorder.toArray(new Integer[0])));
		List<Integer> inorder = new LinkedList<>();
		TreeNode.inorder(root, inorder);
		System.out.println(Arrays.toString(inorder.toArray(new Integer[0])));
		List<Integer> postorder = new LinkedList<>();
		TreeNode.postorder(root, postorder);
		System.out.println(Arrays.toString(postorder.toArray(new Integer[0])));
		List<Integer> levelorder = new LinkedList<>();
		TreeNode.levelorder(root, levelorder);
		System.out.println(Arrays.toString(levelorder.toArray(new Integer[0])));

		TreeNode target = new TreeNode(5);
//		System.out.println(Arrays.toString(solution.distanceK(root, target, 2).toArray(new Integer[0])));

		root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(2)), null);
		target = new TreeNode(2);
		System.out.println(Arrays.toString(solution.distanceK(root, target, 1).toArray(new Integer[0])));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {

		private Map<Integer, TreeNode> map;

		private List<Integer> list;

		public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
			if (root == null) {
				return Collections.emptyList();
			}
			map = new HashMap<>();
			parents(root);
			list = new LinkedList<>();
			find(target, null, 0, k);
			return list;
		}

		private void parents(TreeNode node) {
			if (node.left != null) {
				map.put(node.left.val, node);
				parents(node.left);
			}
			if (node.right != null) {
				map.put(node.right.val, node);
				parents(node.right);
			}
		}

		private void find(TreeNode node, TreeNode from, int depth, int k) {
			if (node == null) {
				return;
			}
			if (depth == k) {
				list.add(node.val);
				return;
			}
			if (node.left != from) {
				find(node.left, node, depth + 1, k);
			}
			if (node.right != from) {
				find(node.right, node, depth + 1, k);
			}
			if (map.get(node.val) != from) {
				find(map.get(node.val), node, depth + 1, k);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}