package cn.itcast.bookmanager.demo;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DaoTest {
    @Test
    public void select()throws SQLException{
        Connection con = new Connection_SQL().getCon();
        String c = "select * from test.user";
        PreparedStatement run = con.prepareStatement(c);
        ResultSet resultSet = run.executeQuery(c);
        while(resultSet.next()){
            System.out.print(resultSet.getString("id")+"\t");
            System.out.print(resultSet.getString("name")+"\t");
            System.out.print(resultSet.getString("age")+"\t");
            System.out.print(resultSet.getString("sex")+"\t");
            System.out.println();
        }
    }


}
