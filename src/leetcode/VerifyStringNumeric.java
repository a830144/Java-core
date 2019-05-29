package leetcode;
public class VerifyStringNumeric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyStringNumeric v = new VerifyStringNumeric();
		System.out.println(v.isNumber("0"));
		System.out.println(v.isNumber(" 0.1 "));
		System.out.println(v.isNumber("abc"));
		System.out.println(v.isNumber("1 a"));
		System.out.println(v.isNumber("2e10"));

	}

	public boolean isNumber(String str) {
		boolean result = true;
		boolean first = true;
		int length = 0;

		for (int i = 0; i < str.length(); i++) {
			char leading = str.charAt(i);
			if (first) {
				if (Character.isDigit(leading) || leading == '.') {
					length++;
				} else {
					result = false;
					break;
				}

			}

			if (!first && leading != ' ') {
				if (leading == '-') {
					
					first = true;
				} else if (leading == '+') {
					first = true;
				} else if (Character.isDigit(leading)) {
					
					first = true;
					length++;
				} else {
					result = false;
					break;
				}
			}
		}
		if (length == 0) {
			result = false;
		}

		return result;
	}
}
