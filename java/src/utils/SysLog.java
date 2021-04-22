package utils;

public class SysLog {

	public static void log(String msg) {
		System.out.println(msg);
	}

	public static void log(String format, Object... objects) {
		System.out.println(String.format(format, objects));
	}
}
