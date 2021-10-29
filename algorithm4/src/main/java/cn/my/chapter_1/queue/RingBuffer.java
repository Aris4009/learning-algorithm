package cn.my.chapter_1.queue;

import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 环形缓冲队列
 */
public class RingBuffer<E> {

	private static final Logger log = LoggerFactory.getLogger(RingBuffer.class);

	private final Object[] array;

	private int size;

	private int head;

	private int tail;

	private final Lock lock = new ReentrantLock();

	private final Condition notFull = lock.newCondition();

	private final Condition notEmpty = lock.newCondition();

	public RingBuffer(int capacity) {
		if (capacity < 1) {
			throw new InvalidParameterException();
		}
		array = new Object[capacity];
		head = 0;
		tail = 0;
	}

	public int size() {
		lock.lock();
		try {
			return size;
		} finally {
			lock.unlock();
		}
	}

	public boolean enqueue(E e) throws InterruptedException {
		lock.lockInterruptibly();
		try {
			while (size == array.length) {
				notFull.await();
			}
			array[tail] = e;
			tail = (tail + 1) % array.length;
			size = size + 1;
			notEmpty.signal();
			return true;
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("unchecked")
	public E dequeue() throws InterruptedException {
		lock.lockInterruptibly();
		try {
			while (size == 0) {
				notEmpty.await();
			}
			E e = (E) array[head];
			head = (head + 1) % array.length;
			size = size - 1;
			notFull.signal();
			return e;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public String toString() {
		lock.lock();
		try {
			if (size == 0) {
				return "";
			}
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < size; i++) {
				builder.append(array[i]);
				builder.append(",");
			}
			builder.deleteCharAt(builder.length() - 1);
			return builder.toString();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		RingBuffer<String> queue = new RingBuffer<>(1);
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(() -> {
			while (true) {
				try {
					log.info("{}", queue.dequeue());
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Scanner scanner = new Scanner(System.in);
		String s = "";
		while ((s = scanner.nextLine()) != null) {
			if (s.isEmpty()) {
				System.exit(2);
			}
			queue.enqueue(s);
		}
	}
}
