package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.TransactionType;
import model.UserModel;
import view.ATMView;
import view.CashView;
import database.AccountHandler;

public class ATMController {
	private ATMView atmView;
	private UserModel userModel;
	
	public ATMController(final ATMView atmView, final UserModel userModel){
		this.atmView = atmView;
		this.userModel = userModel;
		
		atmView.getWelcomeLabel().setText("Welcome, " + userModel.getFirstName() +" "+ userModel.getLastName() +"!");
		AccountHandler accountHandler = new AccountHandler();
		this.userModel = accountHandler.initAccount(userModel);
		
		atmView.getBtnInquireBalance().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atmView.getBalancePanel().setVisible(true);
				inquireBalance();
			}
		});
		
		atmView.getBtnWithdraw().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atmView.getATMJFrame().dispose();
				@SuppressWarnings("unused")
				CashController cashController = new CashController(new CashView(), userModel, TransactionType.WITHDRAW);
			}
		});
		
		atmView.getBtnDeposit().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atmView.getATMJFrame().dispose();
				@SuppressWarnings("unused")
				CashController cashController = new CashController(new CashView(), userModel, TransactionType.DEPOSIT);
			}
		});
	}

	public void inquireBalance() { 
		atmView.getSavingsField().setText(userModel.getSavingsAccount().getBalance()+"");
		atmView.getBusinessField().setText(userModel.getBusinessAccount().getBalance()+"");
		atmView.getCheckingsField().setText(userModel.getCheckingsAccount().getBalance()+"");
	}
	
}
