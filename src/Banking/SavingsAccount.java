package Banking;



public class SavingsAccount extends BankAccount {
	
	
	
	private double interestRate;

	public SavingsAccount(String name, double interestRate) {
		super(name);
		this.name = name;
		if(interestRate > 0 && interestRate < 0.1)
		{
		    this.interestRate = interestRate;
		}else{
			this.interestRate = 0.01;
		}
			
	}

	public SavingsAccount(String newName) {
		super(newName);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public double getRate(){
		return interestRate;
	}

	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("Savings Account").append(System.getProperty("line.separator")); 
	    sb.append(name).append(" [").append(getAccountNumber()).append("]").append(System.getProperty("line.separator"));
	    sb.append(date).append(System.getProperty("line.separator")); 
	    sb.append("$"+(balance + balance*interestRate)).append(System.getProperty("line.separator"));;
	    sb.append("Interest Rate:  %").append(interestRate*100).append(System.getProperty("line.separator"));;
	    return sb.toString();
				
	}

	public void addInterest(){
		balance = balance + balance*interestRate;
	}

}
