package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
	 private static final String host = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
	 private static final String name = "LOLZZZYO";
	 private static final String pass = "741852963";
	 private static Connection connection;
	 
	 protected Connection connect(){
		try{     
		    connection = DriverManager.getConnection(host,name,pass);
		
		}catch (SQLException err){
		    System.out.println(err.getMessage());
		}
		return connection;
	 }
	 public void closeConnection() {
		 try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
}
