package cn.my.chapter_1.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试文本编辑器的缓冲区")
public class BufferTest {

	@Test
	void test() {
		Buffer buffer = new Buffer();
		char[] arr = "12345".toCharArray();
		for (char c : arr) {
			buffer.insert(c);
		}
		Assertions.assertEquals(5, buffer.cursor());
		String b = "1,2,3,4,5";
		Assertions.assertEquals(b, buffer.toString());

		buffer.left(5);
		buffer.insert('0');
		Assertions.assertEquals(1, buffer.cursor());
		b = "0,1,2,3,4,5";
		Assertions.assertEquals(b, buffer.toString());

		buffer.right(3);
		buffer.insert('6');
		b = "0,1,2,3,6,4,5";
		Assertions.assertEquals(b, buffer.toString());
		Assertions.assertEquals(5, buffer.cursor());

		char c = buffer.delete();
		Assertions.assertEquals('6', c);
		b = "0,1,2,3,4,5";
		Assertions.assertEquals(b, buffer.toString());
		Assertions.assertEquals(6, buffer.size());
		Assertions.assertEquals(4, buffer.cursor());

		buffer.right(2);
		buffer.insert('6');
		b = "0,1,2,3,4,5,6";
		Assertions.assertEquals(b, buffer.toString());
	}
}
