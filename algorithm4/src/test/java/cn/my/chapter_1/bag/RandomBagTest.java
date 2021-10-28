package cn.my.chapter_1.bag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试随机背包
 */
@DisplayName("测试随机背包")
public class RandomBagTest {

	private RandomBag<Integer> bag;

	private static final Logger log = LoggerFactory.getLogger(RandomBagTest.class);

	@BeforeEach
	void init() {
		bag = new RandomBag<>();
	}

	@Test
	@DisplayName("测试添加元素")
	void add() {
		Assertions.assertTrue(bag.isEmpty());
		Assertions.assertEquals(0, bag.size());
		int a = 30;
		for (int i = 0; i < a; i++) {
			bag.add(i);
		}
		Assertions.assertFalse(bag.isEmpty());
		Assertions.assertEquals(30, bag.size());
	}

	@Test
	@DisplayName("测试随机迭代器")
	void iterator() {
		int a = 30;
		for (int i = 0; i < a; i++) {
			bag.add(i);
		}
		for (int i = 0; i < 10; i++) {
			String str = bag.toString();
			log.info(str);
			Assertions.assertNotNull(str);
		}
	}
}
