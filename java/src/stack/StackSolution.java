package stack;

import utils.SysLog;

public class StackSolution {
	/**
	 * 有效的括号
	 * 
	 * 20 : https://leetcode.com/problems/valid-parentheses
	 * 
	 * https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		CharArrayStack stack = new CharArrayStack(s);
		char[] cs = null != s ? s.toCharArray() : null;
		if (null == cs) {
			return false;
		}

		for (char c : cs) {
			boolean ispair = isPair(stack.peek(), c);
			if (ispair) {
				stack.pop();
			} else {
				stack.pusn(c);
			}

		}
		SysLog.log(stack.toString());
		return stack.size() < 1;
	}

	private static boolean isPair(char peek, char c) {
		if ((peek == '(' && c == ')') || (peek == '[' && c == ']') || (peek == '{' && c == '}')) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s = null;
		s = "{[]}";
		boolean valid = isValid(s);
		SysLog.log(s + "  :  " + valid);

		s = "([)]";
		valid = isValid(s);
		SysLog.log(s + "  :  " + valid);

		s = "(]";
		valid = isValid(s);
		SysLog.log(s + "  :  " + valid);

		s = "()[]{}";
		valid = isValid(s);
		SysLog.log(s + "  :  " + valid);
	}
}
