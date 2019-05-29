package String;

import java.util.Queue;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "a&&&&&GADHPb$c";
		int middle = input.length()/2;
		char[] arr = new char[input.length()];
		for(int i =0;i<middle;i++){
			char c = input.charAt(i);
			char c2 = input.charAt(input.length()-i-1);
			System.out.println((int)(c));
			System.out.println((int)(c2));
			if(((65<=c&& c<=90)||(97<=c&& c<=122)) && ((65<=c2&& c2<=90)||(97<=c2&& c2<=122))){
				arr[i] = c2;
				arr[input.length()-i-1] =c;
			}else{
				arr[i] = c;
				arr[input.length()-i-1] =c2;
			}
		}
		String output = String.valueOf(arr);
		
		System.out.println(input);
		System.out.println(output);

	}

}
