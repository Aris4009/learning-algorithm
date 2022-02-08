//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为无重复元素的升序排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1308 👎 0

package leetcode.editor.cn;

public class SearchInsertPosition {
	public static void main(String[] args) {
		Solution solution = new SearchInsertPosition().new Solution();
		int[] nums = { 1, 3 };
		int target = 3;
		System.out.println(solution.searchInsert(nums, target));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int searchInsert(int[] nums, int target) {
			return find(nums, target, 0, nums.length - 1);
		}

		private int find(int[] nums, int target, int left, int right) {
			if (left <= right) {
				if (target <= nums[left]) {
					return left;
				}
				if (target == nums[right]) {
					return right;
				}
				if (target > nums[right]) {
					return right + 1;
				}
				int mid = (left + right) >> 1;
				if (target == nums[mid]) {
					return mid;
				}
				if (target < nums[mid]) {
					return find(nums, target, left, mid - 1);
				}
				if (target > nums[mid]) {
					return find(nums, target, mid + 1, right);
				}
			}
			return -1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}