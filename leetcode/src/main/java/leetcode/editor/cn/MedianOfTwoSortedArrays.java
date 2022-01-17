//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 4884 👎 0

package leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		Solution solution = new MedianOfTwoSortedArrays().new Solution();
		int[] num1 = { 1, 2 };
		int[] num2 = { 3, 4 };
		solution.findMedianSortedArrays(num1, num2);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//			int len = nums1.length + nums2.length;
//			int[] nums = new int[len];
//			System.arraycopy(nums1, 0, nums, 0, nums1.length);
//			System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
//			Arrays.sort(nums);
//			sort(nums);
//			double sum;
//			int cursor = len / 2;
//			if (len % 2 == 0) {
//				sum = (nums[cursor] + nums[cursor - 1]) / 2d;
//			} else {
//				sum = nums[cursor];
//			}
//			return sum;
			int m = nums1.length;
			int n = nums2.length;
			int left = (m + n + 1) / 2;
			int right = (m + n + 2) / 2;
			return (find(nums1, 0, nums2, 0, left) + find(nums1, 0, nums2, 0, right)) / 2.0;
		}

		// 寻找第k大的元素
		private int find(int[] nums1, int i, int[] num2, int j, int k) {
			if (i >= nums1.length) {
				return num2[j + k - 1];
			}
			if (j >= num2.length) {
				return nums1[i + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[i], num2[j]);
			}
			int minVal1 = Integer.MAX_VALUE;
			if (i + k / 2 - 1 < nums1.length) {
				minVal1 = nums1[i + k / 2 - 1];
			}
			int minVal2 = Integer.MAX_VALUE;
			if (j + k / 2 - 1 < num2.length) {
				minVal2 = num2[j + k / 2 - 1];
			}
			if (minVal1 < minVal2) {
				return find(nums1, i + k / 2, num2, j, k - k / 2);
			} else {
				return find(nums1, i, num2, j + k / 2, k - k / 2);
			}
		}

//		public void sort(int[] nums) {
//			build(nums);
//			for (int i = nums.length - 1; i >= 0; i--) {
//				int temp = nums[0];
//				nums[0] = nums[i];
//				nums[i] = temp;
//				heapify(nums, 0, i);
//			}
//		}

//		private void build(int[] nums) {
//			for (int i = (nums.length >> 1) - 1; i >= 0; i--) {
//				heapify(nums, i, nums.length);
//			}
//		}

//		private void heapify(int[] nums, int i, int len) {
//			int max = i;
//			int left = (i << 1) + 1;
//			int right = (i << 1) + 2;
//			if (left < len && nums[max] < nums[left]) {
//				max = left;
//			}
//			if (right < len && nums[max] < nums[right]) {
//				max = right;
//			}
//			if (max != i) {
//				int temp = nums[i];
//				nums[i] = nums[max];
//				nums[max] = temp;
//				heapify(nums, max, len);
//			}
//		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}