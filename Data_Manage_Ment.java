package database_project;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Data_Manage_Ment {
	void addSeller(Seller seller) {
		try {
			boolean temp = true;
			PreparedStatement pstm = Connect.getConnection().prepareStatement("select * from user where name = ? and password = ?");
			pstm.setString(1, seller.userName);
			pstm.setString(2, seller.password);
			ResultSet responce = pstm.executeQuery();
			
			while(responce.next()) {
				String name = responce.getString(2);
				String password = responce.getString(3);
				if(password.equals(seller.password) && name.equals(seller.userName)) {
					temp = false;
				}
			}
			if(temp) {
				PreparedStatement stm = Connect.getConnection().prepareStatement("insert into user(name,password,roleId) values(?,?,?)");
				stm.setString(1, seller.userName);
				stm.setString(2, seller.password);
				stm.setInt(3, 2);
				int result = stm.executeUpdate();
				if(result == 1) {
					System.out.println(Color.GREEN+"seller added succesfully"+Color.RESET);
				}
				else {
					System.out.println(Color.RED+"seller added failed"+Color.RESET);
				}
			}
			else {
				System.out.println(Color.RED+"you name and password already exited"+Color.RESET);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	void addCustomer(customer cus) {
		try {
			PreparedStatement stm = Connect.getConnection().prepareStatement("insert into user(name,password,roleId) values(?,?,?)");
			stm.setString(1, cus.userName);
			stm.setString(2, cus.password);
			stm.setInt(3,3);
			int result = stm.executeUpdate();
			if(result == 1) {
				System.out.println(Color.GREEN+"customer added succesfully"+Color.RESET);
			}
			else {
				System.out.println(Color.RED+"customer added failed"+Color.RESET);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void viewDetails(int roleId) {
		try {
			Statement stm = Connect.getConnection().createStatement();
			ResultSet result = stm.executeQuery("select * from user where roleId =" +roleId);
			System.out.println("---------------------------------------------------");
			System.out.printf("%-2s %-8s %-2s %-8s %-2s %-10s %-2s %-8s %-2s%n","|","userId","|","userName","|","password","|","roleId","|");
			System.out.println("---------------------------------------------------");
			while(result.next()) {
				int userId = result.getInt(1);
				String name = result.getString(2);
				String password = result.getString(3);
				int role = result.getInt(4);
				System.out.printf("%-2s %-8s %-2s %-8s %-2s %-10s %-2s %-8s %-2s%n","|",userId,"|",name,"|",password,"|",role,"|");
				System.out.println("---------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}	
	
	void addCar(Car car) {
		try {
			PreparedStatement stm = Connect.getConnection().prepareStatement("insert into carDetails(carBrand,carName,prize,manufactureYear,owner,isAvailable) value(?,?,?,?,?,?)");
			stm.setString(1, car.carBrand);
			stm.setString(2, car.carName);
			stm.setInt(3, car.prize);
			stm.setDate(4, car.manufacture);
			stm.setString(5, car.owner);
			stm.setBoolean(6, car.isAvailable);
			int result = stm.executeUpdate();
			if(result== 1) {
				System.out.println(Color.GREEN+"car added"+Color.RESET);
			}
			else {
				System.out.println(Color.RED+"enter the valid inputs "+Color.RESET);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	void viewCar() {
		try {
			PreparedStatement stm = Connect.getConnection().prepareStatement("select * from carDetails where isAvailable = ?");
			stm.setBoolean(1, true);
			ResultSet result = stm.executeQuery();
			
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.printf("%-2s %-8s %-2s %-8s %-2s %-10s %-2s %-8s %-2s %-10s %-2s %-8s %-2s %-8s %-2s%n", "|", "carId", "|", "carBrand", "|", "carName", "|", "prize", "|", "Year", "|", "owner", "|", "isAvailable", "|");
			System.out.println("------------------------------------------------------------------------------------------");
			while(result.next()) {
				int carId = result.getInt(1);
				String carBrand = result.getString(2);
				String carName = result.getString(3);
				int prize = result.getInt(4);
				Date manufactureYear = result.getDate(5);
				String owner = result.getString(6);
				boolean isAvailable = result.getBoolean(7);
				System.out.printf("%-2s %-8s %-2s %-8s %-2s %-10s %-2s %-8s %-2s %-8s %-2s %-8s %-2s %-11s %-2s%n", "|", carId, "|", carBrand, "|", carName, "|", prize, "|", manufactureYear, "|", owner, "|", isAvailable, "|");
				System.out.println("------------------------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	byte checkString(String str) {
		String[] list = str.split("/");
		if(list.length == 3) {
			if(list[0].length() ==4 && list[1].length() == 2 && list[2].length()<3) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return 0;
		}
	}
	
	
	void removeCar(int carId) {
		try {
			PreparedStatement stm = Connect.getConnection().prepareStatement("delete from carDetails where carId = ?");
			stm.setInt(1, carId);
			int result = stm.executeUpdate();
			if(result == 1) {
				System.out.println(Color.GREEN+"car remove succesfully"+Color.RESET);				
			}
			else {
				System.out.println(Color.RED+"enter the valid car id"+Color.RESET);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	void buyTheCar(int carId,int userId) {

        LocalDate currentDate = LocalDate.now();
		try {
			PreparedStatement stm = Connect.getConnection().prepareStatement("update carDetails set isAvailable = ? where carId = "+carId);
			stm.setBoolean(1, false);
			int result = stm.executeUpdate();
			if(result == 1) {
				System.out.println(Color.GREEN+"car purchase succesfully"+Color.RESET);
				try {
					PreparedStatement pstm = Connect.getConnection().prepareStatement("insert into sellingDetails(carId,buyerId,SellingDate) values(?,?,?)");
					pstm.setInt(1, carId);
					pstm.setInt(2, userId);
					pstm.setDate(3, Date.valueOf(currentDate));
					int resu =pstm.executeUpdate();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("enter the valid carid");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	void sellingDetails() {
		try {
			Statement stm = Connect.getConnection().createStatement();
			ResultSet resultSet = stm.executeQuery("select * from sellingDetails");
			
			System.out.println("+---------------------------------------------------+");
			System.out.printf("%-2s %-8s %-2s %-8s %-2s %-8s %-2s %-12s %-2s%n", "|", "saleId", "|", "carId", "|", "buyerId", "|", "sellingDate","|");
			System.out.println("+---------------------------------------------------+");
			while(resultSet.next()) {
				System.out.printf("%-2s %-8s %-2s %-8s %-2s %-8s %-2s %-12s %-2s%n","|", resultSet.getInt(1), "|", resultSet.getInt(2), "|", resultSet.getInt(3), "|", resultSet.getDate(4),"|");
				System.out.println("+---------------------------------------------------+");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
