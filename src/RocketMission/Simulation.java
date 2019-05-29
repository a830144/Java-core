package RocketMission;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
	
	public ArrayList<Item> loadItems(String fileName){
		ArrayList<Item> arrayList = new ArrayList<Item>();
		try {
			File file = new File(fileName);	
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] arr = line.split("=");
				Item item = new Item(arr[0],Integer.parseInt(arr[1]));
				arrayList.add(item);
			}
			scanner.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public ArrayList<Rocket> loadU1(ArrayList<Item> arrayList){
		ArrayList<Rocket> arrayListU1 = new ArrayList<Rocket>();
		U1 u1 = new U1();
		for(int i =0;i<arrayList.size();i++){
			Item item = arrayList.get(i);
			if(u1.canCarry(item)){
				u1.carry(item);
			}else{
				arrayListU1.add(u1);
				u1 = new U1();
			}
		}
		return arrayListU1;
	}
	
	public ArrayList<Rocket> loadU2(ArrayList<Item> arrayList){
		ArrayList<Rocket> arrayListU2 = new ArrayList<Rocket>();
		U2 u2 = new U2();
		for(int i =0;i<arrayList.size();i++){
			Item item = arrayList.get(i);
			if(u2.canCarry(item)){
				u2.carry(item);
			}else{
				arrayListU2.add(u2);
				u2 = new U2();
			}
		}
		return arrayListU2;
	}
	
	public int runSimulation(ArrayList<Rocket> array){
		int budget = 0;
		for(int i =0;i<array.size();i++){
			Rocket rocket = array.get(i);
			boolean launch = false;
			boolean landing = false;
			while(!launch){
				launch =rocket.launch();
				budget+=rocket.getRocketCost();
			}
			while(!landing){
				landing =rocket.landing();
				budget+=rocket.getRocketCost();
			}
			
		}
		return budget;
		
	}
	
	public static void main(String[] args) {
		//Create a Simulation object
		Simulation s = new Simulation();
		//Load Items for Phase-1 and Phase-2
		ArrayList<Item> p1 = s.loadItems("Phase-1.txt");
		ArrayList<Item> p2 = s.loadItems("Phase-2.txt");
		p1.addAll(p2);
		//Load a fleet of U1 rockets for Phase-1 and then for Phase-2
		ArrayList<Rocket> arru1 = s.loadU1(p1);
		//Run the simulation using the fleet of U1 rockets and display the total budget required.Repeat the same for U2 rockets and display the total budget for that.
		int b1= s.runSimulation(arru1);
		System.out.println("budget for U1:"+b1);
		ArrayList<Rocket> arru2 = s.loadU2(p1);
		int b2= s.runSimulation(arru2);
		System.out.println("budget for U2:"+b2);
	}


}
