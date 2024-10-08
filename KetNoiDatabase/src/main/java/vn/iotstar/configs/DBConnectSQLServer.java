package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;

//import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.DatabaseMetaData;

public class DBConnectSQLServer {
	private final String serverName = "LAPTOP-DTKDJMOS\\SQLEXPRESS";
	private final String dbName = "laptrinhweb";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "75591734";

	/*
	 * // Kết nối SQL Server với SQL Authentication public Connection
	 * getConnection() throws Exception { String url = "jdbc:sqlserver://" +
	 * serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
	 * if (instance == null || instance.trim().isEmpty()) url = "jdbc:sqlserver://"
	 * + serverName + ":" + portNumber + ";databaseName=" + dbName;
	 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); return
	 * DriverManager.getConnection(url, userID, password); }
	 */
	
	// Kết nối SQL Server với SQL Authentication 
	public Connection getConnection() {
		Connection conn = null;
																									//;integratedSecurity=true
		try {
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName="
					+ dbName;
																				//;integratedSecurity=true
			if (instance == null || instance.trim().isEmpty()) {
				url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

			}				
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//, userID, password
			return DriverManager.getConnection(url, userID, password);

			/*
			 * if (conn != null) { DatabaseMetaData dm = (DatabaseMetaData)
			 * conn.getMetaData(); System.out.println("Driver name: " + dm.getDriverName());
			 * System.out.println("Driver version: " + dm.getDriverVersion());
			 * System.out.println("Product name: " + dm.getDatabaseProductName());
			 * System.out.println("Product version: " + dm.getDatabaseProductVersion());
			 * 
			 * return conn; }
			 */
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// Kết nối SQL Server với Windows Authentication
	public Connection getConnectionW() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
				+ ";integratedSecurity=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";integratedSecurity=true;databaseName="
					+ dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQLServer().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}