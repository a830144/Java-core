package String;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
	String fileName;
	
	
	public Game(String fileName) {
		super();
		this.fileName = fileName;
	}

	private Scanner getScanner(){
		Scanner scanner = null;
		try {
			File file = new File(fileName);
			scanner = new Scanner(file);
		} catch (Exception e) {
			System.out.println("no this file");
		}
		return scanner;
	}
	
	private int checkLineNumber(){
		Scanner scanner = getScanner();
		if(scanner==null){
			System.out.println("null");
		}
		int lineNum = 0;
		while(scanner.hasNextLine()){
			String name = scanner.nextLine();
			//System.out.println(name);
			lineNum ++;
		}
		System.out.println(lineNum);
		return lineNum ;
	}
	
	private String pickMovie(int num){
		//random
		int random = (int)(Math.random()*num+1);
		Scanner scanner = getScanner();
		int lineNum=0;
		HashSet set = new HashSet();
		while(scanner.hasNextLine()){
			lineNum ++;
			String name = scanner.nextLine();
			if(lineNum==random){
				
				/*for(int i =0;i<name.length();i++){
					set.add(name.charAt(i));
				}*/
				return name;
			}
		}
		return "";
	}
	
	
	public void guess(String answer){
		String current = "";
		int wrongTime = 0;
		int i;
		for(i =0;i<answer.length();i++){
			current +="_";
		}
		
		while(wrongTime<=10){
			System.out.println("You ar guessing:"+current);
			System.out.println("You have guessed ("+wrongTime+")");
			System.out.print("Guess a letter:");
			Scanner scanner = new Scanner(System.in);
			String c = scanner.nextLine();
			int j;
			for(j=0;j<answer.length();j++){
				if(answer.charAt(j)==c.charAt(0)){
					current = current.substring(0, j)+c+current.substring(j+1);
				}
			}
			if(j==10){
				wrongTime++;
			}
			if(!current.contains("_")){
				System.out.println("You win");
				System.out.println("You ar guessing:"+answer+" correctly");
			}
		}
	}
	
	public String pickMovieLetters(){
		int totalLineNum = checkLineNumber();
		String movieLetters = pickMovie(totalLineNum);
		System.out.println(movieLetters);
		return  movieLetters;
	}
	
}
