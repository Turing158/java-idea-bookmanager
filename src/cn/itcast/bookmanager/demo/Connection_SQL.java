package cn.itcast.bookmanager.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_SQL {
    private Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/?";
    private String user = "root";
    private String password = "123";

    public Connection getCon() throws SQLException {
        try{
            Class.forName(driver);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public void closeCon() throws SQLException {
        if(con!=null){
            con.close();
        }
    }
}
