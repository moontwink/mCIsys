package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserModel;

import org.junit.Test;

import view.LogInView;
import controller.LogInController;

public class LogInTest {

	@Test
	public void logInValid() throws ClassNotFoundException, SQLException {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		UserModel userModel = new UserModel();
		LogInView logInView = new LogInView();
		boolean valid = false;
		
		LogInController logInController = new LogInController(userModel, logInView);
		logInController.getAllUsers(userModelList);
		
		valid = logInController.checkIfValidCredentials(userModelList, "timohtey", "123456");
		
		assertEquals(true, valid);
	}
	
	@Test
	public void logInFailed() throws ClassNotFoundException, SQLException{
		List<UserModel> userModelList = new ArrayList<UserModel>();
		UserModel userModel = new UserModel();
		LogInView logInView = new LogInView();
		boolean valid = false;
		
		LogInController logInController = new LogInController(userModel, logInView);
		logInController.getAllUsers(userModelList);
		
		valid = logInController.checkIfValidCredentials(userModelList, "moontwink", "123456");
		
		assertEquals(false, valid);
	}

}
