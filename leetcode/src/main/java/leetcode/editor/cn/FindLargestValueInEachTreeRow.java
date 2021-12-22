//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//解释:
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
//解释:
//          1
//         / \
//        2   3
// 
//
// 示例3： 
//
// 
//输入: root = [1]
//输出: [1]
// 
//
// 示例4： 
//
// 
//输入: root = [1,null,2]
//输出: [1,2]
//解释:      
//           1 
//            \
//             2     
// 
//
// 示例5： 
//
// 
//输入: root = []
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 161 👎 0

package leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.editor.cn.my.TreeNode;

public class FindLargestValueInEachTreeRow {
	public static void main(String[] args) {
		Solution solution = new FindLargestValueInEachTreeRow().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public List<Integer> largestValues(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			List<Integer> list = new LinkedList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					max = Math.max(max, node.val);
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				list.add(max);
			}
			return list;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}