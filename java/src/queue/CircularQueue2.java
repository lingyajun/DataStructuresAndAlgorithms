package queue;

import utils.SysLog;

public class CircularQueue2 {
	// 数组:items，数组大小:n
	private String[] items;
	private int n = 0;
	// head表示队头下标，tail表示队尾下标
	private int head = 0;
	private int tail = 0;

	// 申请一个大小为capacity的数组
	public CircularQueue2(int capacity) {
		n = capacity;
		items = new String[capacity];
	}

	// 入队
	public boolean enqueue(String item) {
		// 队列满了
		if ((tail + 1) % n == head)
			return false;

		items[tail] = item;
		tail = (tail + 1) % n;
		return true;
	}

	// 出队
	public String dequeue() {
		// 如果head == tail 表示队列为空
		if (head == tail)
			return null;

		String ret = items[head];
		head = (head + 1) % n;
		return ret;
	}
	
	@Override
	public String toString() {
		if (null == items || head == tail) {
			return "queue is empty";
		}
		StringBuilder builder = new StringBuilder();

		for (int i = head; i < tail; i++) {
			builder.append(items[i]);
			builder.append("  ");
		}
		builder.append(" __total: ");
		builder.append(tail - head);
		builder.append(" ,head: " + head);
		builder.append(" ,tail: " + tail);
		return builder.toString();
	}

	public static void main(String[] args) {
		CircularQueue2 queue = new CircularQueue2(8);
		for (int i = 0; i < 10; i++) {
			queue.enqueue("c2_" + i * 100);
		}

		SysLog.log(queue.toString());
		// head = 7, tail=1
		for (int i = 0; i < 6; i++) {
			queue.dequeue();
		}
		SysLog.log(queue.toString());
		for (int i = 0; i < 3; i++) {
			queue.enqueue("x2_" + i + 10);
		}
		SysLog.log(queue.toString());
	}
}
