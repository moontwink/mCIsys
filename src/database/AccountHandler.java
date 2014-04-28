package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.AccountType;
import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;
import exception.WithdrawalException;


public class AccountHandler {
	
	public UserModel initAccount(UserModel user){
		UserModel useraccount = user;
		
		try { 
			Connection c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM user_accounts WHERE user_accounts_id = " + user.getId());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			useraccount.setSavingsAccount(new SavingsAccount(rs.getDouble(2)));
			useraccount.setBusinessAccount(new BusinessAccount(rs.getDouble(3)));
			useraccount.setCheckingsAccount(new CheckingsAccount(rs.getDouble(4)));
			
			rs.close();
			ps.close();
			c.close();
			
	    } catch (SQLException e) { 
	    	Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
	    } catch (ClassNotFoundException e) {
	    	Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
		}
		return useraccount; 
	}
	
	public int depositCash(Double depositAmt, UserModel user, AccountType accountType){
		String accountAttribute = "";
		Double accountBalance = 0.0;
		int success = 0;
		
		try{
			Connection c = DBConnection.getConnection();
			
			switch(accountType){
				case BUSINESS:
					accountAttribute = "business_account_balance";
					accountBalance = user.getBusinessAccount().getBalance();
					break;
				case CHECKINGS:
					accountAttribute = "checkings_account_balance";
					accountBalance = user.getCheckingsAccount().getBalance();
					break;
				case SAVINGS:
					accountAttribute = "savings_account_balance";
					accountBalance = user.getSavingsAccount().getBalance();
					break;
				default:
					break;
			}
			
			PreparedStatement ps = c.prepareStatement("UPDATE user_accounts SET `" + accountAttribute 
					+ "` = " + addCash(accountBalance, depositAmt) + " WHERE `user_accounts_id` = " + user.getId());
			success = ps.executeUpdate();
			
			ps.close();
			c.close();
			
		} catch(SQLException e){
			Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
		} catch (ClassNotFoundException e) {
			Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
		}
		
		return success;
		
	}
	
	public int withdrawCash(Double withdrawAmt, UserModel user, AccountType accountType) throws WithdrawalException{
		String accountAttribute = "";
		Double accountBalance = 0.0;
		int success = 0;
		
		try{
			Connection c = DBConnection.getConnection();
			
			switch(accountType){
				case BUSINESS:
					accountAttribute = "business_account_balance";
					accountBalance = user.getBusinessAccount().getBalance();
					break;
				case CHECKINGS:
					accountAttribute = "checkings_account_balance";
					accountBalance = user.getCheckingsAccount().getBalance();
					break;
				case SAVINGS:
					accountAttribute = "savings_account_balance";
					accountBalance = user.getSavingsAccount().getBalance();
					break;
				default:
					break;
			}
			
			Double newAmount = subtractCash(accountBalance, withdrawAmt);
			if(newAmount == -1.0) {
				throw new WithdrawalException();
			}
			
			PreparedStatement ps = c.prepareStatement("UPDATE user_accounts SET `" + accountAttribute 
					+ "` = " + newAmount + " WHERE `user_accounts_id` = " + user.getId());
			success = ps.executeUpdate();
			
			ps.close();
			c.close();
			
		} catch(SQLException e){
			Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
		} catch (ClassNotFoundException e) {
			Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
		}
		
		return success;
		
	}
	
	private Double addCash(Double amount1, Double amount2){
		return amount1 + amount2;
	}
	
	private Double subtractCash(Double amount1, Double amount2){
		if(amount1 < amount2) {
			return -1.0;
		}
		return amount1 - amount2;
	}
}
