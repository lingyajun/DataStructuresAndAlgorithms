package linked_list;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}

	public ListNode(int val) {
		super();
		this.val = val;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[ ");
		detail(this, builder);
		builder.append(" ]");
		return builder.toString();
	}

	protected static void detail(ListNode curr, StringBuilder msg) {
		if (null == curr || msg == null) {
			return;
		}
		msg.append(String.valueOf(curr.val));

		curr = curr.next;
		if (null != curr) {
			msg.append(" , ");
		}
		detail(curr, msg);
	}
}
