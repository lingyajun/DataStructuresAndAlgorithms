package stack.base;

public class BaseNode<T> {
	public T val;
	public BaseNode<T> next;

	public BaseNode(T val, BaseNode<T> next) {
		super();
		this.val = val;
		this.next = next;
	}

	public BaseNode(T val) {
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

	protected void detail(BaseNode<T> curr, StringBuilder msg) {
		if (null == curr || msg == null) {
			return;
		}
		msg.append(curr.val);

		curr = curr.next;
		if (null != curr) {
			msg.append(" , ");
		}
		detail(curr, msg);
	}

	/**
	 * 输入一个数组，得到链表， 返回head
	 */
	public BaseNode<T> generateListNode(T... array) {
		final int size = null != array ? array.length : -1;
		if (size < 1) {
			return null;
		}
		BaseNode<T> head = new BaseNode<T>(array[0]);

		BaseNode<T> curr = head;
		BaseNode<T> next = null;
		for (int i = 1; i < size; i++) {
			next = new BaseNode<T>(array[i]);
			curr.next = next;

			curr = next;
			next = null;
		}
		return head;
	}

}
