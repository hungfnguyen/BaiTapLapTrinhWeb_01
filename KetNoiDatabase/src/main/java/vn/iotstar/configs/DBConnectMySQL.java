/*configs dung de ket noi database*/
package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {

	private static String USERNAME = "root";
	private static String PASSWORD = "75591734";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/laptrinhweb";

	public static Connection getDatabaseConnection() throws SQLException, Exception {

		try {	
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Test Chuong Trinh
	public static void main(String[] args) {
		try {
			new DBConnectMySQL();
			System.out.println(DBConnectMySQL.getDatabaseConnection());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
