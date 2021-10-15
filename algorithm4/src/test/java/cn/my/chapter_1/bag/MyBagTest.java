package cn.my.chapter_1.bag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("背包测试用例")
public class MyBagTest {

	@Nested
	@DisplayName("测试使用数组实现的背包")
	class MyBagArrayTest {

		@Nested
		@DisplayName("测试构造函数")
		class ConstructorTest {

			@Test
			@DisplayName("测试默认构造函数")
			void defaultConstruct() {
				MyBag.MyBagArray<String> myBagArray = new MyBag.MyBagArray<>();
				Assertions.assertTrue(myBagArray.isEmpty());
				Assertions.assertEquals(0, myBagArray.size());
			}
		}
	}
}
