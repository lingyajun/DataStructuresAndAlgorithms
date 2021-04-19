package stack;

import utils.SysLog;

/**
 * 最小栈
 * 
 * 155 : https://leetcode.com/problems/min-stack/
 * 
 * @author Solomon
 *
 */
public class MinStack {
	IntNode head = null;

//	IntNode mintNode = new IntNode(0);
	public MinStack() {
	}

	public void push(int val) {
		push(new IntNode(val));
	}

	public boolean push(IntNode node) {
		if (null == node) {
			return false;
		}
		node.next = head;
		head = node; // 重新指向栈顶节点

		return true;
	}

	public void pop() {
		if (null == head) {
			return;
		}
		IntNode top = head;
		head = top.next;
	}

	public int top() {
		if (null == head) {
			return 0;
		}
		IntNode top = head;
		return top.val;
	}

	/**
	 * 遍历，求最小值
	 * 
	 * 时间复杂度为 O(n)
	 * 
	 * @return
	 */
	public int getMin() {
		int min = null != head ? head.val : 0;
		IntNode curr = head;
		while (null != curr) {
			if (curr.val < min) {
				min = curr.val;
			}
			curr = curr.next;
		}
		return min;
	}

	private static class IntNode {
		int val;
		IntNode next;

		public IntNode(int val) {
			super();
			this.val = val;
		}
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		int min = minStack.getMin(); // --> 返回 -3.
		SysLog.log("min: " + min);
		minStack.pop();
		int top = minStack.top(); // --> 返回 0.
		SysLog.log("top: " + top);
		min = minStack.getMin(); // --> 返回 -2.
		SysLog.log("min: " + min);

	}
}
