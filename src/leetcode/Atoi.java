package leetcode;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atoi atoi = new Atoi();
		// String[] arr = new String[] { "42", "-42", "4193 with words", "words
		// and 987", "-91283472332" };
		String[] arr = new String[] { "-5-" };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(atoi.myAtoi(arr[i]));
		}
	}

	public int myAtoi(String str) {
		String newStr = "";
		boolean first = false;
		int result = 0;
		long sum = 0;
		int length = 0;

		boolean positive = true;

		for (int i = 0; i < str.length(); i++) {
			char leading = str.charAt(i);
			if (first) {
				if (Character.isDigit(leading)) {
					newStr += leading;
					sum = Long.parseLong(newStr);
					if (positive && sum > Integer.MAX_VALUE) {
						newStr = "" + Integer.MAX_VALUE;
					}
					if (!positive && sum < Integer.MIN_VALUE) {
						newStr = "" + Integer.MIN_VALUE;
					}
					length++;
				}
				if (length == 0 && (leading == '+' || leading == '-')) {
					newStr = "0";
					break;
				}
				if (leading == '.' || !Character.isDigit(leading) ) {
					break;
				}
			}

			if (!first && leading != ' ') {
				if (leading == '-') {
					newStr += leading;
					positive = false;
					first = true;
				} else if (leading == '+') {
					positive = true;
					first = true;
				} else if (Character.isDigit(leading)) {
					newStr += leading;
					positive = true;
					first = true;
					length++;
				} else {
					newStr = "0";
					break;
				}
			}
		}
		if (newStr.length() == 0 || length == 0) {
			result = 0;
		} else {
			result = Integer.parseInt(newStr);
		}

		return result;
	}

}
