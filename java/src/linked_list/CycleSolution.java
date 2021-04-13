package linked_list;

/**
 * 检测链表中是否有环
 * 
 * @author Solomon
 * 
 *         141 ： https://leetcode.com/problems/linked-list-cycle/
 */
public class CycleSolution {

	/**
	 * 快、慢指针法: 快指针是慢指针速度的2倍；
	 * 
	 * 如果没有环，那么最终快指针会走到表的尾部；
	 * 
	 * 如果有环，那么两个指针都会进入环中，一直循环下去，两个指针会相遇；
	 * 
	 * 假设环有Y个节点，
	 * 
	 * 1. 慢指针先进入环，且领先快指针m步 —— 由于快指针是慢指针速度的2倍，那么再过m步后，快指针会赶上慢指针；
	 * 
	 * 2. 快指针先进入环，领先慢指针n步 —— 那么再过（Y-n）步，快指针还是会遇上慢指针
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		return checkCycle(head.next, head.next.next);
	}

	// 处理边界问题，输入起点的指两者必然相等
	private boolean checkCycle(ListNode slow, ListNode fast) {
		// 两个指针指向同一个对象，相遇了
		if (slow == fast) {
			return true;
		}
		// 快指针会走到表的尾部了
		if (fast == null || fast.next == null) {
			return false;
		}
		return checkCycle(slow.next, fast.next.next);
	}
}
