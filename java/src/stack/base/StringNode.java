package stack.base;

public class StringNode extends BaseNode<String> {

	public StringNode(String val) {
		super(val);
	}

	public StringNode(String val, BaseNode<String> next) {
		super(val, next);
	}

}
