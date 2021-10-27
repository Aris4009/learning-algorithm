package cn.my.chapter_1.queue;

import java.util.ListIterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 约瑟夫环的问题
 */
@DisplayName("测试约瑟夫环")
public class JosephusTest {

	// 原始数据队列
	private MyQueue<Integer> myQueue;

	// 出队元素
	private MyQueue<Integer> outQueue;

	private int k;

	@BeforeEach
	void init() {
		myQueue = new MyQueue<>();
		outQueue = new MyQueue<>();
		k = 1;
	}

	@Test
	@DisplayName("n=7,m=2,[1,3,5,0,4,2,6]")
	void test1() {
		int n = 7;
		int m = 2;
		String a = "1,3,5,0,4,2,6";
		Assertions.assertEquals(a, test(n, m));
	}

	@Test
	@DisplayName("n=3,m=5,[1,2,0]")
	void test2() {
		int n = 3;
		int m = 5;
		String a = "1,2,0";
		Assertions.assertEquals(a, test(n, m));
	}

	@Test
	@DisplayName("n=2,m=10,[1,0]")
	void test3() {
		int n = 2;
		int m = 10;
		String a = "1,0";
		Assertions.assertEquals(a, test(n, m));
	}

	@Test
	@DisplayName("n=2,m=11,[0,1]")
	void test4() {
		int n = 2;
		int m = 11;
		String a = "0,1";
		Assertions.assertEquals(a, test(n, m));
	}

	private String test(int n, int m) {
		for (int i = 0; i < n; i++) {
			myQueue.enqueue(i);
		}
		if (myQueue.isEmpty() || m < 1) {
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
				outQueue.enqueue(myQueue.dequeue());
			} else {
				outQueue.enqueue(myQueue.dequeue());
				outQueue.enqueue(myQueue.dequeue());
			}
			return outQueue.toString();
		} else {
			while (!myQueue.isEmpty()) {
				dequeue(m, outQueue);
			}
		}
		return outQueue.toString();
	}

	private void dequeue(int m, MyQueue<Integer> outQueue) {
		ListIterator<Integer> iterator = myQueue.iterator();
		while (iterator.hasNext()) {
			int a = iterator.next();
			if (k == m) {
				outQueue.enqueue(a);
				iterator.remove();
				k = 1;
			} else {
				k = k + 1;
			}
		}
	}
}
