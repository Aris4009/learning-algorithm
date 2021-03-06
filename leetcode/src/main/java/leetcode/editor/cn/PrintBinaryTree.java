//在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则： 
//
// 
// 行数 m 应当等于给定二叉树的高度。 
// 列数 n 应当总是奇数。 
// 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分
//，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，
//如果两个子树都为空则不需要为它们留出任何空间。 
// 每个未使用的空间应包含一个空的字符串""。 
// 使用相同的规则输出子树。 
// 
//
// 示例 1: 
//
// 
//输入:
//     1
//    /
//   2
//输出:
//[["", "1", ""],
// ["2", "", ""]]
// 
//
// 示例 2: 
//
// 
//输入:
//     1
//    / \
//   2   3
//    \
//     4
//输出:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
// 
//
// 示例 3: 
//
// 
//输入:
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//输出:
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// 
//
// 注意: 二叉树的高度在范围 [1, 10] 中。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 112 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import leetcode.editor.cn.my.TreeNode;

public class PrintBinaryTree {
	public static void main(String[] args) {
		Solution solution = new PrintBinaryTree().new Solution();
		TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
		TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
				new TreeNode(5));
		TreeNode node = root2;
		solution.printTree(node);
	}

	// leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public List<List<String>> printTree(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			List<List<String>> list = new LinkedList<>();
			int depth = maxDepth(root);
			for (int i = 0; i < depth; i++) {
				List<String> l = new ArrayList<>();
				for (int j = 0; j < Math.pow(2, depth) - 1; j++) {
					l.add("");
				}
				list.add(l);
			}
			helper(list, root, 0, list.get(0).size(), 0);
			return list;
		}

		private int maxDepth(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int left = maxDepth(node.left);
			int right = maxDepth(node.right);
			return Math.max(left, right) + 1;
		}

		private void helper(List<List<String>> list, TreeNode node, int left, int right, int i) {
			if (node == null) {
				return;
			}
			list.get(i).set((left + right) / 2, String.valueOf(node.val));
			helper(list, node.left, left, (left + right) / 2, i + 1);
			helper(list, node.right, (left + right + 1) / 2, right, i + 1);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}