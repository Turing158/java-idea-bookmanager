package cn.itcast.bookmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	private String dbDriver = "org.sqlite.JDBC";
	public Connection getConnection()throws Exception{
	    Class.forName(dbDriver);
		Connection con = (Connection) DriverManager.getConnection("jdbc:sqlite::resource:bookmanage.db");
		System.out.println(con);
		return con;
	}

	public void closeCon (Connection con)throws Exception {
		if(con!=null){
			con.close();
		}
	}
	
}
