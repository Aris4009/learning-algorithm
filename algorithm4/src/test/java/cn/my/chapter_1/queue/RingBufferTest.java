package cn.my.chapter_1.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试环形队列
 */
@DisplayName("测试环形队列")
public class RingBufferTest {

	private RingBuffer<Integer> queue;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@BeforeEach
	void init() {
		queue = new RingBuffer<>(5);
	}

	@Test
	@DisplayName("入队出队")
	void test() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(() -> {
			for (int i = 0; i < 10; i++) {
				log.info("入队:{}", i);
				try {
					Assertions.assertTrue(queue.enqueue(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		executorService.execute(() -> {
			while (true) {
				try {
					log.info("出队:{}", queue.dequeue());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
