package stack.base;

public class CharNode extends BaseNode<Character> {

	public CharNode(Character val) {
		super(val);
	}

	public CharNode(char val) {
		super(val);
	}

	public CharNode(Character val, CharNode next) {
		super(val, next);
	}

	public CharNode(char val, CharNode next) {
		super(val, next);
	}

	@Override
	public BaseNode<Character> generateListNode(Character... array) {
		return super.generateListNode(array);
	}

	public CharNode generateListNode(String str) {
		if (null == str || str.length() < 1) {
			return null;
		}
		char[] array = str.toCharArray();
		final int len = array.length;
		Character[] cs = new Character[len];
		for (int i = 0; i < len; i++) {
			cs[i] = Character.valueOf(array[i]);
		}
		CharNode cn = (CharNode) super.generateListNode(cs);
		return cn;
	}
}
