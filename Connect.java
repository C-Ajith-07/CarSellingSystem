package database_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private Connect() {
		// TODO Auto-generated constructor stub
	}

	static Connection getConnection() throws SQLException {
		return  DriverManager.getConnection("jdbc:mysql://localhost:3306/Car_Selling_System_01","root","@jith07");
	}
}
