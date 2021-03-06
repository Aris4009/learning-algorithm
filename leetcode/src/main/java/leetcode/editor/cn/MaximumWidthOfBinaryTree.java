//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 277 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.editor.cn.my.TreeNode;

public class MaximumWidthOfBinaryTree {
	public static void main(String[] args) {
		Solution solution = new MaximumWidthOfBinaryTree().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public int widthOfBinaryTree(TreeNode root) {
			if (root == null) {
				return 0;
			}
			Deque<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			root.val = 0;
			int max = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				int width = queue.getLast().val - queue.getFirst().val + 1;
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					if (node.left != null) {
						node.left.val = 2 * node.val + 1;
						queue.offer(node.left);
					}
					if (node.right != null) {
						node.right.val = 2 * node.val + 2;
						queue.offer(node.right);
					}
				}
				max = Math.max(width, max);
			}
			return max;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}