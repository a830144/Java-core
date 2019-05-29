package leetcode;

public class ZigZag {

	private Queue queue = new Queue();
	
	int require_rows;
	
	int require_columns;

	public String convert(String s, int numRows) {
		
		int num = s.length();
		this.require_rows = numRows;
		queue.enque(require_rows,0);
		for(int i=0;i<require_rows-2;i++){
			queue.enque(1,require_rows-(i+2));
		}
		queue.connect();
		Node current = queue.first;
		while(num>0){
			num = num-current.item;
			current = current.next;
			require_columns++;
		}
		String[][] arr= createArray();
		int controller =0;
		int current_row = 0;
		int current_col = 0;
		Node current_conrol = queue.first;
		while(s.length()>0){
			int item = current_conrol.item;
			int space = current_conrol.space;
			String c = s.substring(0, 1);
			arr[current_row+space][current_col]=c;
			controller ++;
			current_row++;
			if(controller ==item){
				controller = 0;
				current_row =0;
				current_col++;
				current_conrol = current_conrol.next;
			}
			s = s.substring(1);
		}
		
		return readArray(arr);
	}
	
	private String[][] createArray(){
		String[][] arr = new String[require_rows][require_columns];
		return arr;
	}
	
	private String readArray(String[][] arr){
		String result="";
		for(int i=0;i<arr.length;i++){
			for(int j=0;j< arr[i].length;j++){
				if(arr[i][j]!=null&& !"".equals(arr[i][j])){
					result += arr[i][j];
				}
			}
		}
		return result;
	}
	
	private class Node{
		Node next;
		int item;
		int space;
		
		Node(Node next,int item,int space){
			this.next = next;
			this.item = item;
			this.space = space;
		}
	}
	
	private class Queue{
		 Node first;
		 Node last;
		 
		 void enque(int item,int space){
			 Node newNode = new Node(null,item,space);
			 if(first==null){
				 first = newNode;
				 last = newNode;
			 }else{
				 Node old = last;
				 old.next = newNode;
				 last = newNode;
			 }
		 }
		 void connect(){
			 last.next = first;
		 }
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZag zigZag = new ZigZag();
		System.out.println(zigZag.convert("PAYPALISHIRING", 4));
		System.out.println("PINALSIGYAHRPI");
	}

}
