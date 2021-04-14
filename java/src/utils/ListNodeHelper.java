package utils;

import linked_list.ListNode;

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
}
