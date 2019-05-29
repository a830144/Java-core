package leetcode;
import java.util.HashMap;

public class PalindromicSubstring {
	HashMap hashMap = new HashMap();

	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		if (initial(s) == true) {
			return s;
		} else {
			int upperbound = s.length() > 1000 ? 1000 : s.length();
			for (int i = upperbound; i > 0; i--) {
				for (int j = 0; j <= s.length() - i; j++) {
					String sub = s.substring(j, j + i);
					System.out.println("sub::"+sub);
					if (isPali(sub, false)) {
						return sub;
					}
				}
			}
		}
		return "";
	}

	private boolean initial(String s) {

		return isPali(s, true);

	}

	private boolean isPali(String s, boolean isInitial) {
		boolean result = true;
		if (s.length() % 2 == 0) {
			int med2 = s.length() / 2;
			int med1 = med2 - 1;
			for (int i = 0; i < s.length() / 2; i++) {
				char c1 = s.charAt(med1--);
				char c2 = s.charAt(med2++);
				System.out.println("logic 1 c1:"+c1+";c2:"+c2);
				if (c1 != c2) {
					System.out.println("logic 1 c1:"+c1+";c2:"+c2);
					result = false;
					
					if (!isInitial) {
						break;
					}
					break;
				}
				if (isInitial) {
					if (hashMap.get(c1) != null) {
						hashMap.put(c1, (int) hashMap.get(c1) + 1);
					}
					if (hashMap.get(c2) != null) {
						hashMap.put(c2, (int) hashMap.get(c2) + 1);
					}
				}
			}
		}
		if(s.length() % 2 == 1){
			int med1 = s.length() / 2;
			int med2 = s.length() / 2;
			for (int i = 0; i <= s.length() / 2; i++) {
				char c1 = s.charAt(med1--);
				char c2 = s.charAt(med2++);
				//System.out.println("logic 2 c1:"+c1+";c2:"+c2);
				if (c1 != c2) {
					result = false;
					if (!isInitial) {
						break;
					}
					break;
				}
				if (isInitial) {
					if (hashMap.get(c1) != null) {
						hashMap.put(c1, (int) hashMap.get(c1) + 1);
					}
					if (hashMap.get(c2) != null) {
						hashMap.put(c2, (int) hashMap.get(c2) + 1);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromicSubstring p = new PalindromicSubstring();
		System.out.println(p.longestPalindrome("cbbd"));
	}

}
