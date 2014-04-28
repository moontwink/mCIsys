package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserModel;

import org.junit.Test;

import view.ATMView;
import view.LogInView;
import controller.ATMController;
import controller.LogInController;

public class InquireBalanceTest {

	@Test
	public void inquireSavingsBalanceValid() throws ClassNotFoundException, SQLException {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		UserModel userModel = new UserModel();
		LogInView logInView = new LogInView();
		
		LogInController logInController = new LogInController(userModel, logInView);
		logInController.getAllUsers(userModelList);
		
		userModel = userModelList.get(0);
		ATMView atmView = new ATMView();
		ATMController atmController = new ATMController(atmView, userModel);
		
		atmController.inquireBalance();
		
		assertEquals(userModel.getSavingsAccount().getBalance(), Double.parseDouble(atmView.getSavingsField().getText()),0);
	}
	
	public void inquireCheckingsBalanceValid() throws ClassNotFoundException, SQLException {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		UserModel userModel = new UserModel();
		LogInView logInView = new LogInView();
		
		LogInController logInController = new LogInController(userModel, logInView);
		logInController.getAllUsers(userModelList);
		
		userModel = userModelList.get(0);
		ATMView atmView = new ATMView();
		ATMController atmController = new ATMController(atmView, userModel);
		
		atmController.inquireBalance();
		
		assertEquals(userModel.getCheckingsAccount().getBalance(), Double.parseDouble(atmView.getCheckingsField().getText()),0);
	}
	
	public void inquireBusinessBalanceValid() throws ClassNotFoundException, SQLException {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		UserModel userModel = new UserModel();
		LogInView logInView = new LogInView();
		
		LogInController logInController = new LogInController(userModel, logInView);
		logInController.getAllUsers(userModelList);
		
		userModel = userModelList.get(0);
		ATMView atmView = new ATMView();
		ATMController atmController = new ATMController(atmView, userModel);
		
		atmController.inquireBalance();
		
		assertEquals(userModel.getBusinessAccount().getBalance(), Double.parseDouble(atmView.getBusinessField().getText()),0);
	}
}
