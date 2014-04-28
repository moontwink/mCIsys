package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;
import view.ATMView;
import view.LogInView;
import database.DBConnection;
import database.UserHandler;

public class LogInController {
	private static UserModel userModel;
	private LogInView logInView;
	private DBConnection dbConnection;
	private List<UserModel> userModelList;
	public LogInController(UserModel userModel, final LogInView logInView) throws ClassNotFoundException, SQLException{
		this.userModel = userModel;
		this.logInView = logInView;
		dbConnection = new DBConnection();
		userModelList = new ArrayList<UserModel>();
		getAllUsers(this.userModelList);
		createListeners();
	}

	public void getAllUsers(List<UserModel> userModelList) throws ClassNotFoundException, SQLException {
		String selectQuery = "SELECT * FROM user";

		Connection conn = dbConnection.getConnection();
				
		try { 
			conn = dbConnection.getConnection();
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(selectQuery);
			
			while(rs.next()){
				UserModel userModel = new UserModel();
				userModel.setId(rs.getInt(1));
				userModel.setFirstName(rs.getString(2));
				userModel.setLastName(rs.getString(3));
				userModel.setUsername(rs.getString(4));
				userModel.setPassword(rs.getString(5));
				
				userModelList.add(userModel);
			}
	    } catch (SQLException e) { 
	    	Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, e);
	    } 
		
		try { 
			
			for(int i = 0; i<userModelList.size(); i++){
				String selectAccountsQuery = "SELECT * FROM user_accounts WHERE user_accounts_id = " + userModelList.get(i).getId();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectAccountsQuery);
				rs.next();
				userModelList.get(i).setSavingsAccount(new SavingsAccount(rs.getDouble(2)));
				userModelList.get(i).setBusinessAccount(new BusinessAccount(rs.getDouble(3)));
				userModelList.get(i).setCheckingsAccount(new CheckingsAccount(rs.getDouble(4)));
			}
	    } catch (SQLException e) { 
	    	Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, e);
	    } 
	
		dbConnection.closeConnection(conn);
	}

	private void createListeners() {
		int condition = JComponent.WHEN_FOCUSED;
		InputMap iMap = logInView.getPasswordField().getInputMap(condition);
		ActionMap aMap = logInView.getPasswordField().getActionMap();
		String enter = "enter";
		iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
		aMap.put(enter, new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				if(checkIfValidCredentials(userModelList, logInView.getUserTxtField(),logInView.getPasswordTxtField())){
					JOptionPane.showMessageDialog(new JFrame(), "Log-in successful!");
					logInView.getLoginJFrame().dispose();
					
					createATMController();
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Username and password do not much!",
						    "Log-in error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	
		logInView.getLoginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkIfValidCredentials(userModelList, logInView.getUserTxtField(),logInView.getPasswordTxtField())){
					JOptionPane.showMessageDialog(new JFrame(), "Log-in successful!");
					logInView.getLoginJFrame().dispose();
					
					createATMController();
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Username and password do not much!",
						    "Log-in error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	public boolean checkIfValidCredentials(List<UserModel> userModelList, String username, String password){
		boolean valid = false;
		
		for(int index = 0; index < userModelList.size(); index++){
			if(username.equals(userModelList.get(index).getUsername()) 
					&& password.equals(userModelList.get(index).getPassword())){
				UserHandler userHandler = new UserHandler();
				for(UserModel u : userHandler.getAllUsers()){
					if(username.equals(u.getUsername())
							&& password.equals(u.getPassword())){
						valid = true;
						userModel = u;
						break;
					}
				}
			}
		}
		
		return valid;
	}
	
	public static void createATMController(){
		ATMView atmView = new ATMView();
		new ATMController(atmView, userModel);
	}
}
