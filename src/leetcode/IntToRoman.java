package leetcode;

public class IntToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntToRoman i = new IntToRoman();
		for (int c = 1993; c <= 1996; c++) {
			i.intToRoman(c);
		}
	}

	public String intToRoman(int num) {
		String[] arr0 = new String[] { "M", "D", "C", "L", "X", "V", "I" };
		int[] arr1 = new int[] { 1000, 500, 100, 50, 10, 5, 1 };
		int[] arr2 = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		int position = 0;
		int remainder = 0;
		String result = "";
		for (int i = 0; i < arr1.length; i++) {
			if (num / arr1[i] >= 1) {
				remainder = num % arr1[i];
				position = i;
				arr2[position] = num / arr1[i];
				num = remainder;
			}
		}
		for(int i=0;i<arr2.length;i++){
			System.out.print(arr2[i]);
		}
		System.out.println();

		if (arr2[0] > 0) {
			for (int i = 0; i < arr2[0]; i++) {
				result += arr0[0];
			}
		}

		for (int i = 1; i < arr2.length; i = i + 2) {
			if (arr2[i] == 1 && arr2[i + 1] == 4) {
				result += arr0[i + 1] + arr0[i - 1];
			} else if (arr2[i] == 0 && arr2[i + 1] == 4) {
				result += arr0[i + 1] + arr0[i];
			} else {
				for (int j = 0; j < arr2[i]; j++) {
					result += arr0[i];
				}
				for (int k = 0; k < arr2[i + 1]; k++) {
					result += arr0[i+1];
				}
			}

		}

		System.out.println(result);
		return result;
	}

}
