package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.UserModel;

public class UserHandler {

	public List<UserModel> getAllUsers(){
		List<UserModel> results = new ArrayList<UserModel>();
		UserModel userModel;
		
		try { 
			Connection c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM user");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				userModel = new UserModel();
				userModel.setId(rs.getInt(1));
				userModel.setFirstName(rs.getString(2));
				userModel.setLastName(rs.getString(3));
				userModel.setUsername(rs.getString(4));
				userModel.setPassword(rs.getString(5));
				
				results.add(userModel);
			}
			
			rs.close();
			ps.close();
			c.close();
			
	    } catch (SQLException e) { 
	    	Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, e);
	    } catch (ClassNotFoundException e) {
	    	Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, e);
		} 
		return results;
	}
}
