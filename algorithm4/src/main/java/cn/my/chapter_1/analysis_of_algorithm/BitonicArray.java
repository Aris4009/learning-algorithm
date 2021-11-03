package cn.my.chapter_1.analysis_of_algorithm;

import java.util.Arrays;

/**
 * 双调数组，查找元素
 */
public class BitonicArray {

	/**
	 * 查找指定元素
	 * 
	 * @param a N个不重复的元素
	 * @param k 指定查找的元素
	 * @return 是否包含该元素k
	 */
	public static boolean find(int[] a, int k) {
		if (a == null || a.length < 3) {
			return false;
		}

		if (checkDuplicate(a)) {
			return false;
		}

		if (!checkBitonic(a)) {
			return false;
		}

		int maxIdx = findMaxIndex(a);
		if (a[maxIdx] == k) {
			return true;
		}

		if (leftBinarySearch(a, 0, maxIdx, k)) {
			return true;
		}

		return rightBinarySearch(a, maxIdx, a.length, k);
	}

	/**
	 * 判断数组是否包含重复元素
	 * 
	 * @param a 指定数组
	 * @return 返回是否包含重复元素
	 */
	private static boolean checkDuplicate(int[] a) {
		int len = a.length;
		int[] t = Arrays.copyOf(a, len);
		Arrays.sort(t);
		for (int i = 1; i < len; i++) {
			if (t[i - 1] == t[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断数组是否是先递增后递减
	 * 
	 * @param a 不重复的数组
	 * @return 是否为先递增后递减
	 */
	private static boolean checkBitonic(int[] a) {
		int len = a.length;
		int[] t = Arrays.copyOf(a, len);
		Arrays.sort(t);
		int maxVal = t[len - 1];
		int maxIdx = -1;
		for (int i = 0; i < len; i++) {
			if (a[i] == maxVal) {
				maxIdx = i;
				break;
			}
		}
		if (maxIdx == 0 || maxIdx == len - 1) {
			return false;
		}

		for (int i = 0; i < maxIdx; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}

		for (int i = maxIdx; i < len - 1; i++) {
			if (a[i] < a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private static int findMaxIndex(int[] a) {
		int len = a.length;
		int maxIdx = -1;
		int left = 0;
		int right = len - 1;
		while (left <= right) {
			maxIdx = (left + right) >>> 1;
			if (a[maxIdx] > a[maxIdx + 1]) {
				right = maxIdx - 1;
			} else if (a[maxIdx] < a[maxIdx + 1]) {
				left = maxIdx + 1;
			} else {
				return maxIdx;
			}
		}
		return maxIdx;
	}

	private static boolean leftBinarySearch(int[] a, int from, int to, int k) {
		int left = from;
		int right = to - 1;
		while (left <= right) {
			int mid = (left + right) >>> 1;
			if (a[mid] > k) {
				right = mid - 1;
			} else if (a[mid] < k) {
				left = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}

	private static boolean rightBinarySearch(int[] a, int from, int to, int k) {
		int left = from;
		int right = to - 1;
		while (left <= right) {
			int mid = (left + right) >>> 1;
			if (a[mid] > k) {
				left = mid + 1;
			} else if (a[mid] < k) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
