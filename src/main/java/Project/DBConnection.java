package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	 static Connection con=null;
	public static Connection getConnection() throws SQLException
	{//require 4 things
		//1. Load driver class for connectivity
		//class.forName tells the loader to load Driver class is memory at runtime
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//s2: create connection Object  jdbc:mysql://localhost:3306/javabase";
		String url="jdbc:mysql://localhost:3306/practice";
		String user="root";
		String password="Pradeepa@2309";
		con= DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
