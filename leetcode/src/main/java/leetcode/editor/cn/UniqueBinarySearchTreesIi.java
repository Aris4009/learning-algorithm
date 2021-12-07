//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1067 👎 0

package leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import leetcode.editor.cn.my.TreeNode;

public class UniqueBinarySearchTreesIi{
    public static void main(String[] args){
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        solution.generateTrees(3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return Collections.emptyList();
        }
        return helper(1,n);
    }

    private List<TreeNode> helper(int l,int r){
        List<TreeNode> list = new LinkedList<>();
        if (l>r){
            list.add(null);
            return list;
        }
        for(int i=l;i<=r;i++){
            List<TreeNode> left = helper(l,i-1);
            List<TreeNode> right = helper(i+1,r);
            for(TreeNode m:left){
                for(TreeNode n:right){
                    TreeNode root = new TreeNode(i);
                    root.left = m;
                    root.right = n;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}