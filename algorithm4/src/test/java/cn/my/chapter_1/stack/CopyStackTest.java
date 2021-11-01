package cn.my.chapter_1.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试复制栈")
public class CopyStackTest {

	@Test
	void test() {
		MyStack.MyStackArray<String> q = new MyStack.MyStackArray<>();
		for (int i = 0; i < 5; i++) {
			q.push(String.valueOf(i));
		}
		String b = "4,3,2,1,0";
		Assertions.assertEquals(b, q.toString());

		MyStack.MyStackArray<String> r = CopyStack.copy(q);
		q.pop();
		Assertions.assertEquals(4, q.size());
		Assertions.assertEquals(5, r.size());
		Assertions.assertEquals(b, r.toString());
	}
}
