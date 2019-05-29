package leetcode;
public class RomanToInt<K, V> {

	public static void main(String[] args) {
		RomanToInt<Object, Object> r = new RomanToInt<Object, Object>();
		System.out.println(r.romanToInt("III"));
		System.out.println(r.romanToInt("IV"));
		System.out.println(r.romanToInt("IX"));
		System.out.println(r.romanToInt("LVIII"));
		System.out.println(r.romanToInt("MCMXCIV"));
		
	}

	public int romanToInt(String s) {
		String model = "MDCLXVI";
		int[] arr1 = new int[] { 1000, 500, 100, 50, 10, 5, 1 };
		int sum = 0;
		while (s.length() > 0) {
			char leading0 = s.charAt(0);			
			int leading0_position = model.indexOf(leading0);
			if(s.length() > 1){
				char leading1 = s.charAt(1);
				int leading1_position =  model.indexOf(leading1);
				if (leading0_position > leading1_position && s.length() > 1) {
					int parseValue = arr1[leading1_position] - arr1[leading0_position];
					sum += parseValue;
					s = s.substring(2);
				} else {
					int parseValue = arr1[leading0_position];
					sum += parseValue;
					s = s.substring(1);
				}
			}else{
				int parseValue = arr1[leading0_position];
				sum += parseValue;
				s = s.substring(1);

			}
			
			

		}
		return sum;

	}
}
