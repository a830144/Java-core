package String;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	
	private void file(){
		File file = new File("large.txt");
		int total =0;
		try {
			Scanner f = new Scanner(file);
			while(f.hasNextLine()){
				String line = f.nextLine();
				String[] lineArr= line.split(" ");
				int length = lineArr.length;
				total+=length;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("total "+total);
	}
	
	
	private void guess(){
		//random from 1~100
		double d = Math.random()* 100 +1;
		int num = (int)d;
		//for loop to ask
		int i=0;
		for(i=0;i<10;i++){
			System.out.println("pls input num");
			Scanner scanner = new Scanner(System.in);
			int g = scanner.nextInt();
			if(g ==num){
				System.out.println("you won");
				break;
			}else{
				if(g >num){
					System.out.println("you number is greater");
				}else{
					System.out.println("you number is less");
				}
			}
		}
		if(i==10){
			System.out.println("you lose");
		}
	}

	public static void main(String[] args) {
		Game g = new Game("movie.txt");
		String movieLetters = g.pickMovieLetters();
		g.guess(movieLetters);
	}

}
