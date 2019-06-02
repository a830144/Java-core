package Banking;

import java.util.Scanner;


public class BankTeller {
	
	private static Bank bank = new Bank(5);

	public static void main(String args[])
	{
		getMainMenu();
		System.out.println("Please enter a command or type ?"); 
		Scanner scanner = new Scanner(System.in);
        String line = null; 
        while ((line = scanner.nextLine()) != null) {
            System.out.println(line);
            if(line.equals("a"))
            {
            	addAccount(scanner);
            }else if(line.equals("b")){
            	removeAccount(scanner);
            }else if(line.equals("c")){
            	displayAccounts();
            }else if(line.equals("d")){
            	countAccounts();
            }else if(line.equals("e")){
            	sortAccounts();
            }else if(line.equals("f")){
            	updateAccount(scanner);
            }else if(line.equals("?")){
            	getMainMenu();
            }else if(line.equals("q")){
            	System.out.println("GOOD BYE!"); 
            	System.exit(0);
            }
            System.out.println("Please enter a command or type ?"); 
        }
        
	}
	
	public static void getMainMenu()
	{
		System.out.println("Bank Teller Options");
		System.out.println("-----------------------------------");
		System.out.println("a: add an account to the bank");
		System.out.println("b: remove an account from the bank");
		System.out.println("c: display the accounts in the bank");
		System.out.println("d: count the accounts in the bank");
		System.out.println("e: sort the accounts in the bank");
		System.out.println("f: update an account in the bank");
		System.out.println("?: display the menu again");
		System.out.println("q: quit this program");
	}
	
	public static void addAccount(Scanner scanner)
	{
		System.out.println("Enter 1 for Savings Account or 2 for Checking Account:");
		String line = scanner.nextLine();
		while (line == null || (!line.equals("1") && !line.equals("2")))
		{			
			System.out.println("Enter 1 for Savings Account or 2 for Checking Account:");
			line = scanner.nextLine();
		}
		if(line.equals("1"))
		{
			System.out.println("Enter account holder name:");
			String name = scanner.nextLine();
			while(name.equals("") || name ==null)
			{
				System.out.println("Your account holder name is empty");
				System.out.println("Enter account holder name:");
				name = scanner.nextLine();
			}
			System.out.println("Enter interest rate:");
			String interestRateStr = scanner.nextLine();
			while(!isNumeric(interestRateStr) || interestRateStr.equals("") || interestRateStr ==null)
			{
				System.out.println("Your interestRate is wrong");
				System.out.println("Enter interest rate:");
				interestRateStr = scanner.nextLine();
			}
			double interestRate = Double.parseDouble(interestRateStr);
			SavingsAccount savingsAccount = new SavingsAccount(name,interestRate);
			bank.add(savingsAccount);
		}else if(line.equals("2"))
		{
			System.out.println("Enter account holder name:");
			String name = scanner.nextLine();
			while(name.equals("") || name ==null)
			{
				System.out.println("Your account holder name is empty");
				System.out.println("Enter account holder name:");
				name = scanner.nextLine();
			}
			System.out.println("Enter starting check number:");
			String checkNumberStr = scanner.nextLine();
			while(!isNumeric(checkNumberStr) || checkNumberStr.equals("") || checkNumberStr ==null)
			{
				System.out.println("Your starting check number is wrong");
				System.out.println("Enter starting check number:");
				checkNumberStr = scanner.nextLine();
			}
			int checkNumber = Integer.parseInt(checkNumberStr);
			CheckingAccount checkingAccount = new CheckingAccount(name,checkNumber);
			bank.add(checkingAccount);
		}
		System.out.println("Bank Account successfully added.");
	}
	
	public static void removeAccount(Scanner scanner)
	{
		System.out.println("Enter account number:");
		String line = scanner.nextLine();
		while (line == null || !isNumeric(line))
		{			
			System.out.println("account number wrong");
			System.out.println("Enter account number:");
			line = scanner.nextLine();
		}
		int accountNumber = Integer.parseInt(line);
		BankAccount bankAccount = bank.find(accountNumber);
		if(bank.remove(bankAccount))
		{
			System.out.println("Bank Account successfully removed.");
		}
		else
		{
			System.out.println("Bank Account not found. Cannot remove.");
		}
	}
	
	public static void displayAccounts()
	{
		System.out.println(bank.toString());
	}
	
	public static void countAccounts()
	{
		System.out.println("There are "+ bank.getCount() + " BankAccounts in the bank");
	}
	
	public static void sortAccounts()
	{
		bank.sort();
	}
	
	public static void updateAccount(Scanner scanner)
	{
		System.out.println("Enter account number:");
		String line = scanner.nextLine();
		while (line == null || !isNumeric(line))
		{			
			System.out.println("account number wrong");
			System.out.println("Enter account number:");
			line = scanner.nextLine();
		}
		int accountNumber = Integer.parseInt(line);
		System.out.println("Enter 1 for deposit or 2 for withdraw:");
		line = scanner.nextLine();
		while (line == null || (!line.equals("1") && !line.equals("2")))
		{			
			System.out.println("Enter 1 for deposit or 2 for withdraw:");
			line = scanner.nextLine();
		}
		if(line.equals("1"))
		{
			System.out.println("Enter amount:");
			line = scanner.nextLine();
			while (line == null || !isNumeric(line))
			{			
				System.out.println("amount wrong");
				System.out.println("Enter amount:");
				line = scanner.nextLine();
			}
			double amount = Double.parseDouble(line);
			BankAccount bankAccount = bank.find(accountNumber);
			if(bankAccount == null)
			{
				System.out.println("There is no this account");
			}
			else
			{
			    bankAccount.deposit(amount);
			    if(bankAccount instanceof CheckingAccount)
			    {
			    	CheckingAccount checkingAccount = (CheckingAccount)bankAccount;
			    	checkingAccount.writeCheck();
			    }
			    System.out.println("Transaction successful");
			    System.out.println("Saving Account Updated:");
			    System.out.println(bankAccount);
			}
		}
		else if(line.equals("2"))
		{
			System.out.println("Enter amount:");
			line = scanner.nextLine();
			while (line == null || !isNumeric(line))
			{			
				System.out.println("amount wrong");
				System.out.println("Enter amount:");
				line = scanner.nextLine();
			}
			double amount = Double.parseDouble(line);
			BankAccount bankAccount = bank.find(accountNumber);
			if(bankAccount == null)
			{
				System.out.println("There is no this account");
			}
			else
			{
			    bankAccount.withdraw(amount);
			    if(bankAccount instanceof CheckingAccount)
			    {
			    	CheckingAccount checkingAccount = (CheckingAccount)bankAccount;
			    	checkingAccount.writeCheck();
			    }
			    System.out.println("Transaction successful");
			    System.out.println("Checking Account Updated:");
			    System.out.println(bankAccount);
			}
		}
		
		
	}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
}
