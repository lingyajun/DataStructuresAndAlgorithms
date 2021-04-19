package utils;

import linked_list.ListNode;
import stack.base.BaseNode;

/**
 * 链表帮助类
 * 
 * @author Solomon
 *
 */
public class ListNodeHelper {

	/**
	 * 输入一个数组，得到链表， 返回head
	 */
	public static ListNode generateListNode(int... array) {
		final int size = null != array ? array.length : -1;
		if (size < 1) {
			return null;
		}
		ListNode head = new ListNode(array[0]);

		ListNode curr = head;
		ListNode next = null;
		for (int i = 1; i < size; i++) {
			next = new ListNode(array[i]);
			curr.next = next;

			curr = next;
			next = null;
		}
		return head;
	}

	public static void printListNode(ListNode head) {
		if (null == head) {
			SysLog.log("null");
			return;
		}
		SysLog.log(head.toString());
	}

	public static void printListNode(BaseNode head) {
		if (null == head) {
			SysLog.log("null");
			return;
		}
		SysLog.log(head.toString());
	}

	/**
	 * 输入一个数组，得到链表， 返回head
	 *
	public static StringNode generateStringNode(String str) {
		final int size = null != str ? str.length() : -1;
		if (size < 1) {
			return null;
		}
		StringNode head = new StringNode(str.charAt(0));

		StringNode curr = head;
		StringNode next = null;
		for (int i = 1; i < size; i++) {
			next = new StringNode(str.charAt(i));
			curr.next = next;

			curr = next;
			next = null;
		}
		return head;
	}

	public static void printStringNode(StringNode head) {
		if (null == head) {
			SysLog.log("null");
			return;
		}
		SysLog.log(head.toString());
	}
*/
}
