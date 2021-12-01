//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 10⁴ 
// 0 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁴ <= val <= 10⁴ 
// 最多调用 add 方法 10⁴ 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
// Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 👍 306 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
	public static void main(String[] args) {
//		KthLargest kthLargest = new KthLargest(3, new int[] { 5, -1 });
//		int[] a = { 2, 1, -1, 3, 4 };
//		for (int i : a) {
//			System.out.println(kthLargest.add(i));
//		}
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class KthLargest {

		private final int k;

		private PriorityQueue<Integer> queue;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			this.queue = new PriorityQueue<>();
			if (nums != null && nums.length > 0) {
				for (int i : nums) {
					add(i);
				}
			}
		}

		public int add(int val) {
			queue.offer(val);
			if (queue.size() > k) {
				queue.poll();
			}
			return queue.peek();
		}
	}

	/**
	 * Your KthLargest object will be instantiated and called as such: KthLargest
	 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
	 */
//leetcode submit region end(Prohibit modification and deletion)

}