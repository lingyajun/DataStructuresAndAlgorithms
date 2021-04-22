package utils;

public class Tools {

	public static void print(int... a) {
		final int n = null != a ? a.length : 0;
		if (n < 1) {
			SysLog.log("array is empty");
			return;
		}
		print(0, n - 1, a);
//		StringBuilder builder = new StringBuilder();
//		for (int i = 0; i < n; i++) {
//			builder.append(a[i]);
//			builder.append("  ");
//		}
//		builder.append("{ size is ");
//		builder.append(n);
//		builder.append(" } ");
//
//		SysLog.log(builder.toString());
	}

	public static void print(int start, int end, int... a) {
		final int n = null != a ? a.length : 0;
		if (n < 1) {
			SysLog.log("array is empty");
			return;
		}
		if (start < 0 || end >= n || start > end) {
			SysLog.log("param is error");
			return;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = start; i <= end; i++) {
			builder.append(a[i]);
			builder.append("  ");
		}
		builder.append("{ size is ");
		builder.append(end - start + 1);
		builder.append(" } ");

		SysLog.log(builder.toString());
	}
}
