package stack;

import java.util.Deque;
import java.util.LinkedList;

import utils.SysLog;

/**
 * 最小栈
 * 
 * 155 : https://leetcode.com/problems/min-stack/
 * 
 * 不服气，用官方的解法提交一下，看下运行结果:
 * 
 * https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
 * 
 * @author Solomon
 *
 */
public class MinStackEx {
	// 用空间换时间

	Deque<Integer> xStack;
	Deque<Integer> minStack;

	public MinStackEx() {
		xStack = new LinkedList<Integer>();
		minStack = new LinkedList<Integer>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int x) {
		xStack.push(x);
		/**
		 * 如果 x 更小，则将 x 放到栈顶；
		 * 
		 * 反之， 则将当前的最小值 再放到栈顶（栈内有多个同样的最小值）
		 */
		int peek = minStack.peek();
		SysLog.log("minStack peek: " + peek);
		minStack.push(Math.min(peek, x));
	}

	public void pop() {
		xStack.pop();
		minStack.pop();
	}

	public int top() {
		return xStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStackEx minStack = new MinStackEx();
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
		SysLog.log("top: " + top);
		min = minStack.getMin();
		SysLog.log("min: " + min);

		SysLog.log("----");
		minStack.pop();
		top = minStack.top();
		SysLog.log("top: " + top);
//		min = minStack.getMin();
//		SysLog.log("min: " + min);
	}
}
