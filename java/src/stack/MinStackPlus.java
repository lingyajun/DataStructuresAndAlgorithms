package stack;

/**
 * 最小栈
 * 
 * 155 : https://leetcode.com/problems/min-stack/
 * 
 * 解题思路 ： https://leetcode-cn.com/problems/min-stack/comments/245076
 * 
 * @author Solomon
 *
 */
public class MinStackPlus {
	IntNode head = null;

	public void push(int val) {
		if (null == head) {
			head = new IntNode(val, val);
		} else {
			// Math.min(val, head.min) : 将head的最小值与 当前val比较 --> 得到最小值
			head = new IntNode(val, Math.min(val, head.min), head);
		}
	}

	public void pop() {
		if (null == head) {
			return;
		}
		head = head.next;
	}

	public int top() {
		return null != head ? head.val : 0;
	}

	/**
	 * 求最小值
	 * 
	 * 时间复杂度为 O(1)
	 * 
	 * @return
	 */
	public int getMin() {
		return null != head ? head.min : 0;
	}

	/**
	 * 链表节点： 封装了 节点的值、最小值、后驱
	 * 
	 * @author Solomon
	 *
	 */
	private static class IntNode {
		int val;
		int min;
		IntNode next;

		public IntNode(int val, int min) {
			this(val, min, null);
		}

		public IntNode(int val, int min, IntNode next) {
			super();
			this.val = val;
			this.min = min;
			this.next = next;
		}

	}

}
