package cn.my.chapter_1.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试复制队列")
public class CopyQueueTest {

	@Test
	void test() {
		MyQueue<String> q = new MyQueue<>();
		for (int i = 0; i < 5; i++) {
			q.add(String.valueOf(i));
		}

		MyQueue<String> r = CopyQueue.copy(q);
		q.dequeue();
		Assertions.assertEquals(5, r.size());
	}
}
