package linked_list;

import utils.ListNodeHelper;
import utils.SysLog;

/**
 * 链表
 * 
 * @author Solomon
 * 
 *         练习 LeetCode对应编号:206，141，21，19，876
 */
public class LinkedListSolution {
	/**
	 * 反转链表 206 ： https://leetcode.com/problems/reverse-linked-list/
	 * 
	 * Input: head = [1,2,3,4,5] , Output: [5,4,3,2,1]
	 * 
	 * Input: head = [1,2] , Output: [2,1]
	 * 
	 * Input: head = [] , Output: []
	 * 
	 * 
	 * Constraints: The number of nodes in the list is the range [0, 5000]. -5000 <=
	 * Node.val <= 5000
	 * 
	 * @param head
	 * @return
	 * 
	 * 		2- 3- 4- 5 1- 2- 3- 4- 5
	 */
	public static ListNode reverseList(ListNode head) {
		return reverse(head, null);
	}

	/**
	 * 将当前节点指向前一个节点，然后将当前节点、前节点都后移. Point the current node to the previous node, and
	 * then move the current node and the previous node back.
	 * 
	 * @param curr
	 * @param pre
	 * @return
	 */
	private static ListNode reverse(ListNode curr, ListNode pre) {
		if (curr == null) {
			return pre;
		}

		ListNode nextTemp = curr.next; // 暂时缓存 Temporarily cached
		curr.next = pre; // 将当前节点指向 前一个节点 Point the current node to the previous node

		pre = curr; // 前一个节点后移 move the previous node back
		curr = nextTemp; // 将当前节点后移 move the current node back

		return reverse(curr, pre);
	}

	/**
	 * 迭代法
	 * 
	 * 1 -> 2 -> 3 -> 4 -> null null <- 1 <- 2 <- 3 <- 4
	 * 
	 * @param head
	 * @return https://leetcode-cn.com/problems/reverse-linked-list/comments/41502
	 */
	public static ListNode reverseListIterative(ListNode head) {
		ListNode pre = null; // 前一个节点
		ListNode curr = head; // 当前节点

		// 将当前节点指向前一个节点，然后将当前指针、前指针都后移
		while (null != curr) {
			ListNode nextTemp = curr.next; // 临时缓存
			curr.next = pre; // 将当前节点指向前一个节点

			pre = curr; // 前指针后移
			curr = nextTemp; // 当前指针后移
		}

		return pre;
	}

	/**
	 * 怎么进行测试呢？ 输入一个数组，得到链表head
	 */
	public static ListNode generateListNode(int... array) {
//		final int size = null != array ? array.length : -1;
//		if (size < 1) {
//			return null;
//		}
//		ListNode head = new ListNode(array[0]);
//
//		ListNode curr = head;
//		ListNode next = null;
//		for (int i = 1; i < size; i++) {
//			next = new ListNode(array[i]);
//			curr.next = next;
//
//			curr = next;
//			next = null;
//		}
//		return head;
		return ListNodeHelper.generateListNode(array);
	}

	public static void main(String[] args) {
		ListNode head = generateListNode(1, 2, 3, 4);
		printListNode(head);
		ListNode reverse = reverseList(head);
		printListNode(reverse);

//		head = generateListNode(new int[] {});
		head = generateListNode();
		printListNode(head);
		reverse = reverseList(head);
		printListNode(reverse);

		head = generateListNode(1, 2);
		printListNode(head);
		reverse = reverseList(head);
		printListNode(reverse);
	}

	public static void printListNode(ListNode head) {
//		if (null == head) {
//			SysLog.log("null");
//			return;
//		}
////		SysLog.log("head  " + head.val);
////		SysLog.log("head.next  " + head.next.val);
//		SysLog.log("head list  " + head);
		ListNodeHelper.printListNode(head);
	}
}
