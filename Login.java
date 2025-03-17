package database_project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

public class Login {
	Data_Manage_Ment login = new Data_Manage_Ment();
	boolean loginChecking(String name , String password,int roleId) {
		boolean ans = false;
		try {
			PreparedStatement stm = Connect.getConnection().prepareStatement("select * from user where roleId = ? and name = ? and password = ?" );
			stm.setInt(1, roleId);
			stm.setString(2, name);
			stm.setString(3, password);
			ResultSet result = stm.executeQuery();
			while(result.next()) {
				if(result.getString(2).equals(name) && result.getString(3).equals(password) && result.getInt(4) == roleId) {
					ans =true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
	
	

}
