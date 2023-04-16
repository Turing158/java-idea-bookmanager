package cn.itcast.bookmanager.utils;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
public class DbUtil {
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/bookmanager?characterEncoding=utf-8";
	private String dbUserName = "root";
	private String dbPassword = "123";

	public Connection getConnection()throws Exception{
	    Class.forName(dbDriver);
		Connection con = (Connection) DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}

	public void closeCon (Connection con)throws Exception {
		if(con!=null){
			con.close();
		}
	}
}
