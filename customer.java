package database_project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class customer extends User{
	Data_Manage_Ment  object = new Data_Manage_Ment();
	
    customer(int userId,String name, String password , String role){
        super(userId, name , password , role);
    }
    
    void viewCar(){
    	object.viewCar();
    }
    
    void getCar(int id,int userId) {
    	object.buyTheCar(id,userId);
    }
    
	int getId(String name , String password) {
		int ans = 0;
		try {
			PreparedStatement stm = Connect.getConnection().prepareStatement("select * from user where roleId = ? and name = ? and password = ?" );
			stm.setInt(1, 3);
			stm.setString(2, name);
			stm.setString(3, password);
			ResultSet result = stm.executeQuery();
			while(result.next()) {
				if(result.getString(2).equals(name) && result.getString(3).equals(password) && result.getInt(4) == 3) {
					ans =result.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}

}
