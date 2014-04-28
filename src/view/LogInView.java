package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInView {
	private JTextField userNameTxtField;
	private JPasswordField passwordTxtField;
	private JButton btnLogin;
	private JFrame logInFrame;
	private JPanel loginPanel;
	
	public LogInView(){
		initComponents();
	}

	private void initComponents() {
		logInFrame = new JFrame("Log-in");
		logInFrame.setSize(new Dimension(345, 298));
		logInFrame.getContentPane().setLayout(null);
		logInFrame.setLocationRelativeTo(null);
		
		loginPanel = new JPanel();
		loginPanel.setBounds(10, 11, 309, 238);
		logInFrame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(28, 87, 79, 14);
		loginPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		userNameTxtField = new JTextField();
		userNameTxtField.setBounds(97, 85, 165, 20);
		loginPanel.add(userNameTxtField);
		userNameTxtField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 119, 65, 14);
		loginPanel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		passwordTxtField = new JPasswordField();
		passwordTxtField.setBounds(97, 116, 165, 20);
		loginPanel.add(passwordTxtField);
		
		JLabel lblLogin = new JLabel("Log-in");
		lblLogin.setBounds(28, 31, 95, 33);
		loginPanel.add(lblLogin);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnLogin = new JButton("Log-in");
		btnLogin.setBounds(117, 165, 97, 30);
		loginPanel.add(btnLogin);
		logInFrame.setVisible(true);
	}
	
	public JFrame getLoginJFrame(){
		return logInFrame;

	}
	
	public JTextField getPasswordField(){
		return passwordTxtField;
	}
	
	public String getUserTxtField(){
		System.out.println("Username: " +userNameTxtField.getText());
		return userNameTxtField.getText();
	}
	
	public String getPasswordTxtField(){
		return new String(passwordTxtField.getPassword());
	}
	
	public JButton getLoginBtn(){
		return btnLogin;
	}
	
	public JPanel getloginPanel(){
		return loginPanel;
	}
	
	
}
