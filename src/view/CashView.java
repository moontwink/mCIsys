package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.AccountType;

public class CashView {
	private JFrame jframe;
	private JPanel cashPanel;
	private JTextField cashField;
	private JButton btnEnter;
	ButtonGroup btnGroup;
	private JRadioButton rdbtnSavings;
	private JRadioButton rdbtnCheckings;
	private JRadioButton rdbtnBusiness;
	
	public CashView(){
		jframe = new JFrame();
		jframe.setSize(new Dimension(420, 175));
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.getContentPane().setLayout(null);
		
		cashPanel = new JPanel();
		cashPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enter Amount", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		cashPanel.setBounds(10, 11, 380, 119);
		jframe.getContentPane().add(cashPanel);
		cashPanel.setLayout(null);
		
		cashField = new JTextField();
		getCashField().setBounds(155, 53, 123, 20);
		cashPanel.add(getCashField());
		getCashField().setColumns(10);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(113, 84, 131, 23);
		cashPanel.add(btnEnter);
		
		Object[] currencies = {"PHP"};
		JComboBox currencyBox = new JComboBox(currencies);
		currencyBox.setBounds(84, 53, 61, 20);
		cashPanel.add(currencyBox);
		
		rdbtnSavings = new JRadioButton("SAVINGS");
		rdbtnSavings.setSelected(true);
		rdbtnSavings.setBounds(24, 23, 104, 23);
		cashPanel.add(rdbtnSavings);
		
		rdbtnCheckings = new JRadioButton("CHECKINGS");
		rdbtnCheckings.setBounds(148, 23, 104, 23);
		cashPanel.add(rdbtnCheckings);
		
		rdbtnBusiness = new JRadioButton("BUSINESS");
		rdbtnBusiness.setBounds(272, 23, 104, 23);
		cashPanel.add(rdbtnBusiness);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnBusiness);
		btnGroup.add(rdbtnCheckings);
		btnGroup.add(rdbtnSavings);
	}
	
	public JButton getBtnEnter(){
		return btnEnter;
	}
	
	public JFrame getJFrame(){
		return jframe;
	}
	
	public JPanel getCashPanel(){
		return cashPanel;
	}
	
	public JTextField getCashField(){
		return cashField;
	}

	public AccountType getSelectedValue() {
		if(rdbtnSavings.isSelected()){
			return AccountType.SAVINGS;
		} else if(rdbtnCheckings.isSelected()){
			return AccountType.CHECKINGS;
		} else if(rdbtnBusiness.isSelected()){
			return AccountType.BUSINESS;
		}
		return AccountType.SAVINGS;
	}
}
