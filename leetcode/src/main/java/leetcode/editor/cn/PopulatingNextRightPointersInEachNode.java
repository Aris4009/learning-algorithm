//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量少于 4096 
// -1000 <= node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 619 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.my.Node;

import java.util.*;

public class PopulatingNextRightPointersInEachNode {
	public static void main(String[] args) {
		Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
		Node node = new Node(1, new Node(2, new Node(4, null, null, null), new Node(5, null, null, null), null),
				new Node(3, new Node(6, null, null, null), new Node(7, null, null, null), null), null);
		solution.connect(node);
	}
	// leetcode submit region begin(Prohibit modification and deletion)
	/*
	 * // Definition for a Node. class Node { public int val; public Node left;
	 * public Node right; public Node next;
	 *
	 * public Node() {}
	 *
	 * public Node(int _val) { val = _val; }
	 *
	 * public Node(int _val, Node _left, Node _right, Node _next) { val = _val; left
	 * = _left; right = _right; next = _next; } };
	 */

	class Solution {

		private Map<Integer, Node> map;

		public Node connect(Node root) {
			Queue<Node> queue = new LinkedList<>();
			queue.offer(root);
			List<Node> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node node = queue.poll();
					list.add(node);
					if (node != null) {
						if (node.left != null) {
							queue.offer(node.left);
						}
						if (node.right != null) {
							queue.offer(node.right);
						}
					}
				}
				for (int i = 1; i < list.size(); i++) {
					list.get(i - 1).next = list.get(i);
				}
				list.clear();
			}
			return root;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}