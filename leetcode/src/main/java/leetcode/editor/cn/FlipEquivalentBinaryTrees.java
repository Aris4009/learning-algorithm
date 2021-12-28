//我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。 
//
// 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。 
//
// 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。 
//
// 
//
// 示例： 
//
// 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,
//null,null,null,8,7]
//输出：true
//解释：我们翻转值为 1，3 以及 5 的三个节点。
//
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 100 个节点。 
// 每棵树中的每个值都是唯一的、在 [0, 99] 范围内的整数。 
// 
//
// 
// Related Topics 树 深度优先搜索 二叉树 👍 108 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.editor.cn.my.TreeNode;

public class FlipEquivalentBinaryTrees {
	public static void main(String[] args) {
		Solution solution = new FlipEquivalentBinaryTrees().new Solution();
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		public boolean flipEquiv(TreeNode root1, TreeNode root2) {
			if (root1 == null || root2 == null) {
				return false;
			}
			if (root1.val != root2.val) {
				return false;
			}
			Queue<TreeNode> queue1 = new LinkedList<>();
			queue1.offer(root1);
			Queue<TreeNode> queue2 = new LinkedList<>();
			queue2.offer(root2);
			boolean flag = true;
			while (!queue1.isEmpty() && !queue2.isEmpty() && flag) {
				int size1 = queue1.size();
				int size2 = queue2.size();
				if (size1 != size2) {
					flag = false;
					break;
				}
				for (int i = 0; i < size1; i++) {
					TreeNode node1 = queue1.poll();
					TreeNode node2 = queue2.poll();
					if (node1.val != node2.val) {
						flag = false;
						break;
					}
					if (node1.left != null) {
						queue1.offer(node1.left);
					}
					if (node1.right != null) {
						queue1.offer(node1.right);
					}
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}