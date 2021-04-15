package linked_list;

import utils.ListNodeHelper;

/**
 * 链表的中间点
 * 
 * @author Solomon
 * 
 *         876 ： https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleNodeSolution {
	/**
	 * Input: [1,2,3,4,5] , Output: Node 3 from this list (Serialization: [3,4,5]);
	 * slow = 2, fast = 4 , fast.next = 5, fast.next.next = null, return slow.next;
	 * 
	 * Input: [1,2,3,4,5,6] , Output: Node 4 from this list (Serialization: [4,5,6])
	 * slow = 3, fast = 6 , fast.next = null, return slow.next;
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode middleNode(ListNode head) {
		ListNode dummyNode = new ListNode(0, head);
		ListNode fast = dummyNode;
		ListNode slow = dummyNode;

		while (null != fast.next && null != fast.next.next) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.next;
	}

	/**
	 * https://leetcode.com/problems/middle-of-the-linked-list/discuss/1159273/Java-0ms-faster-than-100
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode middleNode2(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (null != fast && null != fast.next) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeHelper.generateListNode(1, 2, 3, 4, 5);
		ListNodeHelper.printListNode(head);
		ListNode node = middleNode2(head);
		ListNodeHelper.printListNode(node);

		head = ListNodeHelper.generateListNode(1, 2, 3, 4, 5, 6);
		ListNodeHelper.printListNode(head);
		node = middleNode2(head);
		ListNodeHelper.printListNode(node);

		head = ListNodeHelper.generateListNode(1, 2);
		ListNodeHelper.printListNode(head);
		node = middleNode2(head);
		ListNodeHelper.printListNode(node);
	}
}
