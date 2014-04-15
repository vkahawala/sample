package user.mgt.ui.util;

import java.util.Formatter;

public class SecurityUtil {
	private SecurityUtil() {

	}

	public static String formatByteArray(byte[] data) {
		Formatter formatter = new Formatter();
		for (byte b : data) {
			formatter.format("%02x", b);
		}
		return formatter.toString();

	}
}
