package stack.base;

public class BaseStackOfLinked<T> {
	int count = 0;
	int maxSize;
	BaseNode<T> head = null; // 指向栈顶节点

	public BaseStackOfLinked(int max) {
		maxSize = max;
	}

	public boolean push(T s) {
		return push(new BaseNode<T>(s));
	}

	public boolean push(BaseNode<T> node) {
		if (count >= maxSize) {
			return false;
		}
		node.next = head;
		head = node; // 重新指向栈顶节点
		count++;
		return true;
	}

	public BaseNode<T> pop() {
		if (count < 1 || null == head) {
			return null;
		}
		BaseNode<T> top = head;
		head = top.next;
		count--;
		return top;
	}
}
