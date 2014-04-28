package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.AccountType;
import model.TransactionType;
import model.UserModel;
import view.CashView;
import database.AccountHandler;
import exception.WithdrawalException;

public class CashController {
	private CashView cashView;
	private UserModel userModel;
	
	public CashController(final CashView cashView, final UserModel userModel, final TransactionType type) {
		this.cashView = cashView;
		this.userModel = userModel;
		
		if(type == TransactionType.WITHDRAW) {
			cashView.getBtnEnter().setText("WITHDRAW");
		} else {
			cashView.getBtnEnter().setText("DEPOSIT");
		}
		
		//Create Listeners
		int condition = JComponent.WHEN_FOCUSED;
		InputMap iMap = cashView.getCashField().getInputMap(condition);
		ActionMap aMap = cashView.getCashField().getActionMap();
		String enter = "enter";
		iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
		aMap.put(enter, new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				processTransaction(type);
				
			}
		});
		
		cashView.getBtnEnter().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				processTransaction(type);
				
			}
		});
		
	}
	
	private void processTransaction(TransactionType type){
		switch(type){
			case WITHDRAW: 
					withdrawalProcess();
				break;
				
			case DEPOSIT: 
				depositProcess();
				break;
				
			default: 
				break;
		}
	}
	
	private void withdrawalProcess(){
		AccountHandler accountHandler = new AccountHandler();
		try{
			Double withdrawAmt = Double.parseDouble(cashView.getCashField().getText());
		
			AccountType accountType = cashView.getSelectedValue();
			int success = accountHandler.withdrawCash(withdrawAmt, userModel, accountType);
			
			if(success == 1) {
				JOptionPane.showMessageDialog(new JFrame(),
				    "Transaction Successful!",
				    "Transaction",
				    JOptionPane.INFORMATION_MESSAGE);
			} else {	
				//Causes of Failure
			}
			
			cashView.getJFrame().dispose();
			LogInController.createATMController();
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(new JFrame(),
				    "Failed Transaction due to empty Field.",
				    "Transaction",
				    JOptionPane.ERROR_MESSAGE);
		}catch(WithdrawalException ex){
			JOptionPane.showMessageDialog(new JFrame(),
				    "Failed Transaction due to bigger withdrawal amount.",
				    "Transaction",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void depositProcess(){
		AccountHandler accountHandler = new AccountHandler();
		
		try{
			Double depositAmt = Double.parseDouble(cashView.getCashField().getText());
		
			AccountType accountType = cashView.getSelectedValue();
			int success = accountHandler.depositCash(depositAmt, userModel, accountType);
			
			if(success == 1) {
				JOptionPane.showMessageDialog(new JFrame(),
				    "Transaction Successful!",
				    "Transaction",
				    JOptionPane.INFORMATION_MESSAGE);
			} else {	
				//Causes of Failure
			}
			
			cashView.getJFrame().dispose();
			LogInController.createATMController();
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(new JFrame(),
				    "Failed Transaction due to empty Field.",
				    "Transaction",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
}
