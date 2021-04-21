package queue;

import utils.SysLog;

/**
 * 顺序队列，用数组实现的队列
 * 
 * @author Solomon
 *
 */
public class ArrayQueue {
	private String[] items;
	private int max;

	private int head = 0, tail = 0; // head表示队头下标，tail表示队尾下标

	public ArrayQueue(int capacity) {
		items = new String[capacity];
		max = capacity;
	}

	// 入队, 将元素放到队尾
	public boolean enqueue(String item) {
		if (tail >= max) {
			return false; // 队列已经满了
		}
		items[tail] = item;
		tail++;
		return true;
	}

	// 出队，从队首取出元素
	public String dequeue() {
		if (head >= tail) {
			return null; // 队列为空
		}
		String str = items[head];
		head++;
		return str;
	}

	@Override
	public String toString() {
		if (null == items || head >= tail) {
			return "queue is empty";
		}
		StringBuilder builder = new StringBuilder();

		for (int i = head; i < tail; i++) {
			builder.append(items[i]);
			builder.append("  ");
		}
		builder.append(" __total: ");
		builder.append(tail - head);
		return builder.toString();
	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(10);
		for (int i = 0; i < 10; i++) {
			queue.enqueue("item_" + i * 100);
		}

		SysLog.log(queue.toString());
		queue.enqueue("item_x");
		queue.enqueue("item_y");
		SysLog.log(queue.toString());
		queue.dequeue();
		queue.dequeue();
		SysLog.log(queue.toString());
	}
}
