package stack;

import utils.SysLog;

/**
 * 最小栈
 * 
 * 155 : https://leetcode.com/problems/min-stack/
 * 
 * 模仿，官方的解法，自定义了链表、栈的实现:
 * 
 * https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
 * 
 * @author Solomon
 *
 */
public class MinStackExx {
	LinkedStack valStack;
	LinkedStack minStack;

	public MinStackExx() {
		valStack = new LinkedStack();
		minStack = new LinkedStack();
	}

	public void push(int val) {
		valStack.push(val);

		int peek = minStack.peek();
		SysLog.log("minStack peek: " + peek);
		minStack.push(Math.min(val, peek));
	}

	public void pop() {
		valStack.pop();
		minStack.pop();
	}

	public int top() {
		return valStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	/**
	 * 自定义 栈
	 * 
	 * @author Solomon
	 *
	 */
	private static class LinkedStack {
		IntNode head = null;

		public void push(int val) {
			if (null != head) {
				head = new IntNode(val, head);
			} else {
				head = new IntNode(val);
			}
		}

		public void pop() {
			if (null == head) {
				throw new NullPointerException();
			}
			head = head.next;
		}

		public int peek() {
			if (null == head) {
				return Integer.MAX_VALUE;
			}
			return head.val;
		}
	}

	/**
	 * 自定义链表
	 * 
	 * @author Solomon
	 *
	 */
	private static class IntNode {
		int val;
		IntNode next;

		public IntNode(int val) {
			this(val, null);
		}

		public IntNode(int val, IntNode next) {
			super();
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		MinStackExx minStack = new MinStackExx();
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

		SysLog.log("----");
		minStack.pop();
		top = minStack.top();
		SysLog.log("top: " + top); // --> 返回 -2.
		min = minStack.getMin();
		SysLog.log("min: " + min); // --> 返回 -2.

		SysLog.log("----");
		minStack.pop();
		top = minStack.top();
		SysLog.log("top: " + top);
//		min = minStack.getMin();
//		SysLog.log("min: " + min);
	}

}
