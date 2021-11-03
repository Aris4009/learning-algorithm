package cn.my.chapter_1.analysis_of_algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试双调数组，查找元素")
public class BitonicArrayTest {

	private int[] a;

	private int k;

	@Test
	void testArrayLength() {
		Assertions.assertFalse(BitonicArray.find(a, k));
		a = new int[1];
		Assertions.assertFalse(BitonicArray.find(a, k));
	}

	@Test
	void testDuplicate() {
		a = new int[] { 1, 2, 3, 4, 5, 4, 3 };
		Assertions.assertFalse(BitonicArray.find(a, k));
	}

	@Test
	void testBitonic() {
		a = new int[] { 1, 2, 3, 4, 5 };
		Assertions.assertFalse(BitonicArray.find(a, k));

		a = new int[] { 5, 4, 3, 2, 1 };
		Assertions.assertFalse(BitonicArray.find(a, k));

		a = new int[] { 3, 1, 7, 10, 9 };
		Assertions.assertFalse(BitonicArray.find(a, k));
	}

	@Test
	void testFind() {
		a = new int[] { 1, 2, 3, 4, 10, 9, 8 };
		k = 3;
		Assertions.assertTrue(BitonicArray.find(a, k));
		k = -1;
		Assertions.assertFalse(BitonicArray.find(a, k));
		k = 10;
		Assertions.assertTrue(BitonicArray.find(a, k));
		k = 9;
		Assertions.assertTrue(BitonicArray.find(a, k));
		k = 8;
		Assertions.assertTrue(BitonicArray.find(a, k));
		k = 1;
		Assertions.assertTrue(BitonicArray.find(a, k));
		k = -1;
		Assertions.assertFalse(BitonicArray.find(a, k));
	}
}
