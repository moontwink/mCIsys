package model;

public class SavingsAccount implements Account{
	private double balance;
	
	public SavingsAccount(){
		balance = 0;
	}
	
	public SavingsAccount(double balance){
		this.balance = balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
		
	}

	public double getBalance() {
		return balance;
	}	
}
