//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1166 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import leetcode.editor.cn.my.TreeNode;

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeInorderTraversal().new Solution();
		TreeNode root = new TreeNode();
		root.val = 1;
		List<Integer> list = solution.inorderTraversal(root);
		System.out.println(Arrays.toString(list.toArray(new Integer[0])));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
//	public static class TreeNode {
//		int val;
//		TreeNode left;
//		TreeNode right;
//
//		TreeNode() {
//		}
//
//		TreeNode(int val) {
//			this.val = val;
//		}
//
//		TreeNode(int val, TreeNode left, TreeNode right) {
//			this.val = val;
//			this.left = left;
//			this.right = right;
//		}
//	}

	class Solution {

		public List<Integer> inorderTraversal(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			List<Integer> list;
			if (root.left == null && root.right == null) {
				list = new ArrayList<>(1);
				list.add(root.val);
				return list;
			}
			list = new ArrayList<>();
			traversal(root, list);
			return list;
		}

		public void traversal(TreeNode node, List<Integer> list) {
			if (node.left != null) {
				traversal(node.left, list);
			}
			list.add(node.val);
			if (node.right != null) {
				traversal(node.right, list);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}