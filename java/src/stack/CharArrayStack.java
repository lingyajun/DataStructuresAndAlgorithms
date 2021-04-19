package stack;

public class CharArrayStack {

	char[] items = null;
	int count = 0;
	int maxSize;

	public CharArrayStack(int max) {
		super();
		this.maxSize = max;
		items = new char[max];
	}

	public CharArrayStack(String str) {
		this(null != str ? str.length() : 0);
	}

	public boolean pusn(char s) {
		if (count >= maxSize) {
			return false; // 满了，装不下了
		}
		items[count] = s;
		count++;
		return true;
	}

	public char pop() {
		if (count < 1) {
			return ' '; // 空的
		}
		char str = items[count - 1];
		count--;
		return str;
	}

	public char peek() {
		if (count < 1) {
			return ' '; // 空的
		}
		char str = items[count - 1];
		return str;
	}

	public int size() {
		return count;

//		return null != items ? items.length : 0;
	}

	@Override
	public String toString() {
		if (null != items && count > 0 && count <= items.length) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < count; i++) {
				char c = items[i];
				builder.append(c);
			}
			return builder.toString();
		}
		return null;
	}
}
