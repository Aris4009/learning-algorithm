//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 244 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.TreeNode;

public class CousinsInBinaryTree {
	public static void main(String[] args) {
		Solution solution = new CousinsInBinaryTree().new Solution();
		TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(4)),new TreeNode(3));
		System.out.println(solution.isCousins(root,4,3));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		private TreeNode xParent;

		private TreeNode yParent;

		private boolean xFlag;

		private boolean yFlag;

		private int xDeep;

		private int yDeep;

		private int x;

		private int y;

		public boolean isCousins(TreeNode root, int x, int y) {
			this.x = x;
			this.y = y;
			helper(root,null,0);
			return xParent!=yParent&&xDeep==yDeep;
		}

		private void helper(TreeNode node,TreeNode parent,int deep){
			if (node==null){
				return;
			}
			if (node.val==x){
				xParent = parent;
				xDeep = deep;
				xFlag = true;
			}else if(node.val==y){
				yParent=parent;
				yDeep = deep;
				yFlag=true;
			}
			if (xFlag&&yFlag){
				return;
			}
			helper(node.left,node,deep+1);
			if (xFlag&&yFlag){
				return;
			}
			helper(node.right,node,deep+1);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}