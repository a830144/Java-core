package Banking;

public class Bank {
  private BankAccount[] accounts;
  private int count;

  public Bank(int cap) {
    accounts = new BankAccount[cap];
    count = 0;
  }

  private int indexOf(BankAccount a) {
	  if (a == null) return -1;
		for (int i = 0; i < count; i++) {
			if (accounts[i].equals(a))
				return i;
		}
    return -1;
  }


  public boolean contains(BankAccount a) {
    return indexOf(a) != -1;
  }

  public boolean add(BankAccount a) {
	  if(!contains(a)){
		  if(full())
			  doubleCapacity();
	  accounts[count] = a;
	  ++count;
	  return true;
	  }
	  else
	  return false;
  }

  public boolean remove(BankAccount a) {
	  if(contains(a)){
	  for(int i = indexOf(a)+1; i<count; i++)
		  accounts[indexOf(a)] = accounts[i];
	  accounts[count-1] = null;
	  --count;
	  return true;  
	  }
	  else
	  return false;
  }

  public int getCount() {
    return count;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Bank Accounts\n");
    for (BankAccount a : accounts)
      sb.append(a + "\n    **************    \n");
    return sb.toString();
  }

  public void sort() {
		for (int i = 1; i < count; i++) {
			for (int j = i; j > 0; j--) {
				if (accounts[i].getAccountNumber() > accounts[i - 1].getAccountNumber()) {
					BankAccount temp = accounts[i];
					accounts[i] = accounts[i - 1];
					accounts[i - 1] = temp;
				} else
					break;
			}
		}
   } 

  private void doubleCapacity() {
	  if(full()){
	  BankAccount[] temp =  new BankAccount[count*2];
	    for(int i = 0; i < count ; i++){
	        temp[i] = accounts[i];                  
	    }
		accounts = temp;
	  }
  }

  private boolean full() {
    return count == accounts.length;
  }
  
  public BankAccount find(int acct) {
	  for (int i = 0; i < count; i++)
	  if (accounts[i].getAccountNumber() == acct) return accounts[i];
	  return null;
	  }

}