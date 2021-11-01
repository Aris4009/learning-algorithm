package cn.my.chapter_1.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试前移编码
 */
@DisplayName("测试迁移编码")
public class MoveToFrontTest {

	private DoubleList<Character> list;

	@BeforeEach
	void init() {
		list = new DoubleList<>();
	}

	@Test
	void test1() {
		String a = "12334";
		String b = "3,1,2,4";
		Assertions.assertEquals(b, MoveToFront.moveToFront(a, list));
	}

	@Test
	void test2() {
		String a = "3331";
		String b = "3,1";
		Assertions.assertEquals(b, MoveToFront.moveToFront(a, list));
	}

	@Test
	void test3() {
		String a = "133";
		String b = "3,1";
		Assertions.assertEquals(b, MoveToFront.moveToFront(a, list));
	}
}
