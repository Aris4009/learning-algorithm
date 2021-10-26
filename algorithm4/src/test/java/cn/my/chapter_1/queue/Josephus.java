package cn.my.chapter_1.queue;

import java.util.ListIterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * 约瑟夫环的问题
 */
@DisplayName("测试约瑟夫环")
public class Josephus {

	// 原始数据队列
	private MyQueue<Integer> myQueue;

	// 出队元素
	private MyQueue<Integer> outQueue;

	private int m;

	@BeforeEach
	void init() {
		int n = 7;
		m = 2;
		// 入队操作
		myQueue = new MyQueue<>();
		for (int i = 0; i < n; i++) {
			myQueue.enqueue(i);
		}
		outQueue = new MyQueue<>();
	}

	private String test() {
		if (myQueue.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (myQueue.size() == 1) {
			outQueue.enqueue(myQueue.dequeue());
			return outQueue.toString();
		}
		if (myQueue.size() == 2) {
			if (m % myQueue.size() % 2 == 0) {
				int i = 0;
				ListIterator<Integer> iterator = myQueue.iterator();
				while (iterator.hasNext()) {
					int a = iterator.next();
					if (i == 1) {
						outQueue.enqueue(a);
						iterator.remove();
					}
					i = i + 1;
				}
			} else {
				outQueue.enqueue(myQueue.dequeue());
			}
			return outQueue.toString();
		} else {
			while (myQueue.size() > 1) {
				for (int i = 0; i < m - 1; i++) {
					myQueue.add(myQueue.dequeue());
				}
			}
		}
	}
}
