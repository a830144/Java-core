package Banking;



public class CheckingAccount extends BankAccount{
	
	
	private int checkNumber = 1000;

	public CheckingAccount(String name, int checkNumber) {
		super(name);
		this.name = name;
		if(checkNumber > 0){
			this.checkNumber = checkNumber;
		}else{
			this.checkNumber = 1000;
		}
		
	}

	public int getCheckNumber() {
		return checkNumber;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("Checking Account").append(System.getProperty("line.separator")); 
	    sb.append(name).append(" [").append(getAccountNumber()).append("]").append(System.getProperty("line.separator"));
	    sb.append(date).append(System.getProperty("line.separator")); 
	    sb.append(balance).append(System.getProperty("line.separator"));;
	    sb.append("Next Check Number:     #").append(checkNumber).append(System.getProperty("line.separator"));;
	    return sb.toString();
	}
	
	public void writeCheck(){
		checkNumber++;
	}

}
