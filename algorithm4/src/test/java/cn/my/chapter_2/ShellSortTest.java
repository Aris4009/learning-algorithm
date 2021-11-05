package cn.my.chapter_2;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("测试希尔排序")
public class ShellSortTest {

	private static final Logger log = LoggerFactory.getLogger(ShellSortTest.class);

	@Test
	void test() {
		Random random = new Random();
		int n = 10;
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(20);
		}
		log.info(Arrays.toString(a));
		AbstractSort sort = new ShellSort();
		sort.sort(a);
		Assertions.assertTrue(sort.isSort(a));
		sort.show(a);
	}
}
