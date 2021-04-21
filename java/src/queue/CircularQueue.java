package queue;

import utils.SysLog;

/**
 * 循环队列，把数组首尾相连 扳成了一个环。
 * 
 * 循环, 取余
 * 
 * @author Solomon
 *
 */
public class CircularQueue {
	private String[] items;
	private final int max;

	private int head = 0, tail = 0; // head表示队头下标，tail表示队尾下标

	public CircularQueue(int capacity) {
		items = new String[capacity];
		max = capacity;
	}

	// 入队, 将元素放到队尾
	public boolean enqueue(String item) {
//		if ((tail++) % max >= head) {
		if ((tail + 1) % max == head) {
			return false; // 队列满了
		}
		items[tail] = item;
		tail = (tail + 1) % max;
		return true;
	}

	// 出队，从队首取出元素
	public String dequeue() {
//		if (head >= tail) {
		if (head == tail) {
			return null; // 队列为空
		}
		String str = items[head];
		head = (head + 1) % max;
		return str;
	}

	@Override
	public String toString() {
		if (null == items || head == tail) {
			return "queue is empty";
		}
		StringBuilder builder = new StringBuilder();

		final int start = head;
		final int end = tail > head ? tail : (max + tail);

		for (int i = start; i < end; i++) {
			builder.append(items[i % max]);
			builder.append("  ");
		}

//		for (int i = head; i < tail; i++) {
//			builder.append(items[i]);
//			builder.append("  ");
//		}
		builder.append(" { total: ");
		builder.append(end - start);
		builder.append(" ,head: " + head);
		builder.append(" ,tail: " + tail);
		builder.append(" ,end: " + end);
		builder.append(" ,capacity: " + max);
		builder.append(" }");
		return builder.toString();
	}

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(8);
		for (int i = 0; i < 10; i++) {
			queue.enqueue("c_" + i * 100);
		}

		SysLog.log(queue.toString());
		// head = 7, tail=1
		for (int i = 0; i < 6; i++) {
			queue.dequeue();
		}
		SysLog.log(queue.toString());
		for (int i = 0; i < 3; i++) {
			queue.enqueue("x_" + i + 10);
		}
		SysLog.log(queue.toString());
	}
}
