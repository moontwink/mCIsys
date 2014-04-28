package model;

public class CheckingsAccount implements Account{
	private double balance;
	
	public CheckingsAccount(){
		balance = 0;
	}
	
	public CheckingsAccount(double balance){
		this.balance = balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	
}
