package cn.my.chapter_1.queue;

import java.security.InvalidParameterException;

/**
 * 复制队列
 * 
 * 编写一个新的构造函数，使以下代码 Queue<Item> r = new Queue<Item>(q); 得到的 r 指向队列 q
 * 的一个新的独立的副本。可以对 q 或 r 进行任意入列或出列操作但它们不 会相互影响。提示：从 q 中取出所有元素再将它们插入 q 和 r。
 */
public class CopyQueue {

	public static <E> MyQueue<E> copy(MyQueue<E> q) {
		if (q == null || q.isEmpty()) {
			throw new InvalidParameterException();
		}
		MyQueue<E> myQueue = new MyQueue<>();
		myQueue.addAll(q);
		return myQueue;
	}
}
