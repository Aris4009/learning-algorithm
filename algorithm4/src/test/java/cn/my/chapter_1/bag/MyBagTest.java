package cn.my.chapter_1.bag;

import org.junit.jupiter.api.*;

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

			@Test
			@DisplayName("测试指定容量的构造函数")
			void capacityConstruct() {
				MyBag.MyBagArray<String> myBagArray = new MyBag.MyBagArray<>(10);
				Assertions.assertTrue(myBagArray.isEmpty());
				Assertions.assertEquals(0, myBagArray.size());
			}
		}

		@Nested
		@DisplayName("测试操作")
		@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
		class operationTest {

			private MyBag.MyBagArray<String> myBagArray;

			private final MyBag.MyBagArray<String> temp = new MyBag.MyBagArray<>();

			@BeforeEach
			void init() {
				myBagArray = new MyBag.MyBagArray<>();
				for (int i = 0; i < 5; i++) {
					myBagArray.add(String.valueOf(i));
				}
			}

			@Test
			@DisplayName("添加")
			void add() {
				Assertions.assertTrue(myBagArray.add("5"));
				Assertions.assertEquals(6, myBagArray.size());
			}

			@Test
			@DisplayName("删除")
			void remove() {
				Assertions.assertThrows(UnsupportedOperationException.class, () -> {
					myBagArray.remove("5");
				});
				Assertions.assertThrows(UnsupportedOperationException.class, () -> {
					myBagArray.removeAll(temp);
				});
			}

			@Test
			@DisplayName("保留")
			void retain() {
				Assertions.assertThrows(UnsupportedOperationException.class, () -> {
					myBagArray.retainAll(temp);
				});
			}

			@Test
			@DisplayName("清除")
			void clear() {
				Assertions.assertThrows(UnsupportedOperationException.class, () -> {
					myBagArray.clear();
				});
			}

			@Test
			@DisplayName("打印集合元素")
			@Order(1)
			void string() {
				StringBuilder builder = new StringBuilder();
				String[] str = new String[5];
				for (int i = 0; i < str.length; i++) {
					builder.append(String.valueOf(i));
					builder.append(",");
				}
				builder.deleteCharAt(builder.length() - 1);
				Assertions.assertEquals(builder.toString(), myBagArray.toString());
			}

			@Test
			@DisplayName("转换数组")
			@Order(2)
			void toArray() {
				Object[] objects = new Object[5];
				for (int i = 0; i < 5; i++) {
					objects[i] = String.valueOf(i);
				}
				Assertions.assertArrayEquals(objects, myBagArray.toArray());

				MyBag.MyBagArray<String> my = new MyBag.MyBagArray<>();
				for (int i = 0; i < 5; i++) {
					my.add(String.valueOf(i));
				}
				Assertions.assertArrayEquals(my.toArray(new String[0]), myBagArray.toArray(new String[0]));

				String[] old = new String[10];
				Assertions.assertEquals(10, myBagArray.toArray(old).length);
			}
		}
	}
}
