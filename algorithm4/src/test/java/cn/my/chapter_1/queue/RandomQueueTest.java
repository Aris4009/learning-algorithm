package cn.my.chapter_1.queue;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试随机队列
 */
@DisplayName("测试随机队列")
public class RandomQueueTest {

	private RandomQueue<Integer> queue;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@BeforeEach
	void init() {
		queue = new RandomQueue<>();
	}

	@Test
	@DisplayName("入队")
	void enqueue() {
		int a = 20;
		for (int i = 0; i < a; i++) {
			queue.enqueue(i);
		}
		Assertions.assertEquals(20, queue.size());
		Assertions.assertFalse(queue.isEmpty());
	}

	@Test
	@DisplayName("随机出队")
	void dequeue() {
		int a = 20;
		for (int i = 0; i < a; i++) {
			queue.enqueue(i);
		}
		StringBuilder builder = new StringBuilder();
		while (queue.size() > 0) {
			builder.append(queue.dequeue());
			builder.append(",");
		}
		log.info(builder.toString());
		Assertions.assertEquals(0, queue.size());
		Assertions.assertTrue(queue.isEmpty());
	}

	@Test
	@DisplayName("随机返回一个元素")
	void sample() {
		int a = 20;
		for (int i = 0; i < a; i++) {
			queue.enqueue(i);
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < a; i++) {
			builder.append(queue.sample());
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		log.info(builder.toString());
		Assertions.assertEquals(20, queue.size());
		Assertions.assertFalse(queue.isEmpty());
	}

	@Test
	@DisplayName("随机迭代器")
	void iterator() {
		int a = 20;
		for (int i = 0; i < a; i++) {
			queue.enqueue(i);
		}
		StringBuilder builder = new StringBuilder();
		Iterator<Integer> iterator = queue.iterator();
		while (iterator.hasNext()) {
			builder.append(iterator.next());
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		log.info(builder.toString());
		Assertions.assertEquals(20, queue.size());
		Assertions.assertFalse(queue.isEmpty());
	}

	@Nested
	@DisplayName("随机发牌，每人13张牌")
	class SendCard {

		private final String[] COLORS = { "红桃", "黑桃", "梅花", "方块 " };

		private final String[] NUMS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		private RandomQueue<Card> cards;

		@BeforeEach
		void init() {
			cards = new RandomQueue<>();
			int k = 0;
			for (String color : COLORS) {
				for (String num : NUMS) {
					cards.enqueue(new Card(color, num));
				}
			}
		}

		@Test
		@DisplayName("发牌，每人13张牌")
		void send() {
			Card[][] a = new Card[4][13];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					a[i][j] = cards.dequeue();
				}
			}
			for (Card[] value : a) {
				log.info(Arrays.toString(value));
			}
			Assertions.assertEquals(0, cards.size());
		}

		class Card {

			private final String color;

			private final String num;

			public Card(String color, String num) {
				this.color = color;
				this.num = num;
			}

			@Override
			public String toString() {
				return color + num;
			}
		}
	}
}
