package linked_list;

import utils.SysLog;

/**
 * 链表合并
 * 
 * @author Solomon
 *
 *         21 ： https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class ListMergeSolution {

	/**
	 * Merge Two Sorted Lists
	 * 
	 * Input: l1 = [], l2 = [0] , Output: [0]
	 * 
	 * Input: l1 = [], l2 = [] , Output: []
	 * 
	 * Input: l1 = [1,2,4], l2 = [1,3,4] , Output: [1,1,2,3,4,4]
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode list = null;
		ListNode nxt = null;
		ListNode curr = list;

		ListNode c1 = l1;
		ListNode c2 = l2;
		while (null != c1 && null != c2) {
			if (c1.val < c2.val) {
				nxt = c1; // 采用c1
				c1 = c1.next; // c1 往后移一位
			} else {
				nxt = c2; // 采用c2
				c2 = c2.next; // c2 往后移一位
			}
			SysLog.log("nxt:  " + nxt.val);

			// 把 nxt 归入链表中
			if (curr != null) {
				curr.next = nxt;
			}

			curr = nxt; // 后移一位

			if (null == list) {
				list = curr;
			}

		}

		// 处理边界：null
		curr = null == c1 ? c2 : c1;
		if (null != nxt) {
			nxt.next = curr;
		} else if (null == list) {
			list = curr;
		}
		return list;
	}

	/**
	 * mergeTwoLists(ListNode l1, ListNode l2) 的实现感觉有些混乱；
	 * 
	 * 参考： https://leetcode-cn.com/problems/merge-two-sorted-lists/comments/2198
	 * 
	 * 思路清晰，初始化方法比较巧妙，代码优雅
	 * 
	 * @param args
	 */
	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0); // 好处：避免了空指针，避免了空判断
		ListNode curr = dummyHead;
		while (null != l1 && null != l2) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next; // l1 后移一位 , 进入下一轮比较
			} else {
				curr.next = l2;
				l2 = l2.next; // l2 后移一位 , 进入下一轮比较
			}
			curr = curr.next; // curr 后移一位 , 进入下一轮比较
		}

		curr.next = null == l1 ? l2 : l1;
		return dummyHead.next;
	}

	public static void main(String[] args) {
		// test
		ListNode l1 = LinkedListSolution.generateListNode(1, 2, 4);
		ListNode l2 = LinkedListSolution.generateListNode(1, 3, 4);
		LinkedListSolution.printListNode(l1);
		LinkedListSolution.printListNode(l2);

		ListNode list = mergeTwoLists(l1, l2);
		LinkedListSolution.printListNode(list);

		l1 = LinkedListSolution.generateListNode();
		l2 = LinkedListSolution.generateListNode(1, 3, 4);
		LinkedListSolution.printListNode(l1);
		LinkedListSolution.printListNode(l2);
		list = mergeTwoLists(l1, l2);
		LinkedListSolution.printListNode(list);

		l1 = LinkedListSolution.generateListNode();
		l2 = LinkedListSolution.generateListNode(1, 3, 4);
		LinkedListSolution.printListNode(l1);
		LinkedListSolution.printListNode(l2);
		list = merge(l1, l2);
		LinkedListSolution.printListNode(list);
		LinkedListSolution.printListNode(l1);
		LinkedListSolution.printListNode(l2);

		l1 = LinkedListSolution.generateListNode(1, 2, 4);
		l2 = LinkedListSolution.generateListNode(1, 3, 4);
		LinkedListSolution.printListNode(l1);
		LinkedListSolution.printListNode(l2);
		list = merge(l1, l2);
		LinkedListSolution.printListNode(list);
		LinkedListSolution.printListNode(l1);
		LinkedListSolution.printListNode(l2);
	}
}
