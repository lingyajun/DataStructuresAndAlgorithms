package stack;

public class ArrayStack {

	String[] items = null;
	int count = 0;
	int maxSize;

	public ArrayStack(int n) {
		maxSize = n;
		items = new String[n];
	}

	public boolean pusn(String s) {
		if (count >= maxSize) {
			return false; // 满了，装不下了
		}
		items[count] = s;
		count++;
		return true;
	}

	public String pop() {
		if (count < 1) {
			return null; // 空的
		}
		String str = items[count - 1];
		count--;
		return str;
	}
}
