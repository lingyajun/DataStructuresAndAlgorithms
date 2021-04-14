package linked_list;

/**
 * 节点移除
 * 
 * @author Solomon
 *
 */
public class RemoveNodeSolution {

	/**
	 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	 * 
	 * 移除倒数第n个节点
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(0, head); // 小技巧
		ListNode fast = dummyHead;
		ListNode slow = dummyHead;

		// 1. fast 先走n步 ；
		// 2. slow再从起点出发；
		// 3. slow,fast 速度一样 ；
		// 4. 当fast到达最后一个节点时，slow落后fast节点n步，此时slow.next节点就是链表的倒数第n个节点，即移除的节点
		for (int i = 0; i < n; i++) {
			if (null == fast) {
				return head;
			}
			fast = fast.next;
		}
		while (null != fast.next) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode head = LinkedListSolution.generateListNode(1, 2, 3, 4, 5);
		ListNode listNode = removeNthFromEnd(head, 2);
		LinkedListSolution.printListNode(listNode);
		
		head = LinkedListSolution.generateListNode(1, 2);
		listNode = removeNthFromEnd(head, 1);
		LinkedListSolution.printListNode(listNode);
		
		head = LinkedListSolution.generateListNode(1);
		listNode = removeNthFromEnd(head, 1);
		LinkedListSolution.printListNode(listNode);
	}
}
