package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class ATMView {
	private JFrame jframe;
	private JTextField savingsField;
	private JTextField checkingsField;
	private JTextField businessField;
	private JPanel balancePanel;
	private JLabel welcomeLabel;
	private JButton btnInquireBalance;
	private JButton btnWithdraw;
	private JButton btnDeposit;
	private JPanel buttonsPanel;
	
	public ATMView() {
		jframe = new JFrame();
		jframe.setSize(new Dimension(600, 360));
		jframe.setVisible(true);
		jframe.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		jframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setSize(new Dimension(360, 360));
		
		welcomeLabel = new JLabel();
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(0, 35, 340, 25);
		welcomeLabel.setFont(new Font("Cambria", Font.BOLD, 21));
		panel.add(welcomeLabel);
		
		balancePanel = new JPanel();
		getBalancePanel().setBorder(new TitledBorder(null, "Balance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getBalancePanel().setBounds(349, 68, 206, 221);
		panel.add(getBalancePanel());
		getBalancePanel().setLayout(null);
		getBalancePanel().setVisible(false);
		
		JLabel lblSavings = new JLabel("SAVINGS");
		lblSavings.setBounds(22, 36, 60, 14);
		getBalancePanel().add(lblSavings);
		lblSavings.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		setSavingsField(new JTextField());
		getSavingsField().setBounds(46, 52, 132, 20);
		getBalancePanel().add(getSavingsField());
		getSavingsField().setEditable(false);
		getSavingsField().setBackground(Color.LIGHT_GRAY);
		getSavingsField().setColumns(10);
		
		JLabel lblCheckingsAccount = new JLabel("CHECKINGS ACCOUNT");
		lblCheckingsAccount.setBounds(22, 83, 156, 14);
		getBalancePanel().add(lblCheckingsAccount);
		lblCheckingsAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		setCheckingsField(new JTextField());
		getCheckingsField().setBounds(46, 100, 132, 20);
		getBalancePanel().add(getCheckingsField());
		getCheckingsField().setEditable(false);
		getCheckingsField().setColumns(10);
		getCheckingsField().setBackground(Color.LIGHT_GRAY);
		
		JLabel lblBusinessAccount = new JLabel("BUSINESS ACCOUNT");
		lblBusinessAccount.setBounds(22, 131, 156, 14);
		getBalancePanel().add(lblBusinessAccount);
		lblBusinessAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		setBusinessField(new JTextField());
		getBusinessField().setBounds(46, 156, 132, 20);
		getBalancePanel().add(getBusinessField());
		getBusinessField().setEditable(false);
		getBusinessField().setColumns(10);
		getBusinessField().setBackground(Color.LIGHT_GRAY);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonsPanel.setBounds(24, 95, 316, 165);
		panel.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		btnInquireBalance = new JButton("Inquire Balance");
		getBtnInquireBalance().setBounds(21, 24, 132, 50);
		buttonsPanel.add(getBtnInquireBalance());
		
		getBtnInquireBalance().setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnWithdraw = new JButton("Withdraw");
		getBtnWithdraw().setBounds(163, 24, 132, 50);
		buttonsPanel.add(getBtnWithdraw());
		getBtnWithdraw().setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnDeposit = new JButton("Deposit");
		getBtnDeposit().setBounds(163, 92, 132, 50);
		buttonsPanel.add(getBtnDeposit());
		getBtnDeposit().setFont(new Font("Tahoma", Font.PLAIN, 12));
	}
	
	public JPanel getButtonsPanel(){
		return buttonsPanel;
	}
	
	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}
	
	public void setWelcomeLabel(JLabel welcomeLabel) {
		this.welcomeLabel = welcomeLabel;
	}

	public JButton getBtnInquireBalance() {
		return btnInquireBalance;
	}

	public JButton getBtnWithdraw() {
		return btnWithdraw;
	}

	public JButton getBtnDeposit() {
		return btnDeposit;
	}

	public JPanel getBalancePanel() {
		return balancePanel;
	}

	public JTextField getSavingsField() {
		return savingsField;
	}

	public void setSavingsField(JTextField savingsField) {
		this.savingsField = savingsField;
	}

	public JTextField getCheckingsField() {
		return checkingsField;
	}

	public void setCheckingsField(JTextField checkingsField) {
		this.checkingsField = checkingsField;
	}

	public JTextField getBusinessField() {
		return businessField;
	}

	public void setBusinessField(JTextField businessField) {
		this.businessField = businessField;
	}
	
	public JFrame getATMJFrame(){
		return jframe;
	}
}
