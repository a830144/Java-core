package Banking;

import java.util.Date;
import java.util.Random;
public class BankAccount{
	
	public BankAccount() {
		super();
	}

	protected String name;
	protected double balance;
	protected int acctNum;
	protected Date date;
	protected static int accountsCreated;

public BankAccount(String newName){
	name = newName;
	balance = 0;
	generateAcctNum();
	date = new Date();
	++accountsCreated;
}

public double getBalance(){
	return balance;
}

public boolean deposit(double amount){
	if(amount >= 0){
		balance += amount;
		return true;
	}
	else
		return false;
}

public boolean withdraw(double amount){
	if(amount >= 0 && amount <= balance){
		balance -= amount;
		return true;
	}
	else
		return false;
}

public String toString(){
	return String.format("%s [%d]\n%s\n$%.2f", name, acctNum, date, balance);
}

public boolean equals(BankAccount two){
	if(acctNum == two.acctNum)
		return true;
	else
		return false;
}


private int generateAcctNum(){
	Random rand = new Random();
	int  num1 = rand.nextInt((999 - 100) + 1) + 100;
	int  num2 = rand.nextInt((999 - 100) + 1) + 100;
	int  num3 = rand.nextInt((999 - 100) + 1) + 100;
	String acctNumString = "" + num1 +  num2 + num3;
	acctNum = Integer.parseInt(acctNumString);
	return acctNum;
}

public int getAccountNumber() {
    return acctNum;
  }

public static int getAccountsCreated(){
	return accountsCreated;
}

public boolean transfer(BankAccount two, double amount){
	if(balance>=amount && amount>=0){
		balance -= amount;
		two.balance += amount;
		return true;
	}
	else
		return false;
}

}

