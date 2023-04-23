package cn.itcast.bookmanager.demo;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    @Test
    public void test1() throws SQLException {
        Connection con = new Connection_SQL().getCon();
        System.out.println(con);
    }


}
