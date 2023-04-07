package cn.itcast.bookmanager.dao;

import cn.itcast.bookmanager.model.BorrowDetail;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;

public interface BorrowDetailDao {
	
	public ResultSet list(Connection con,BorrowDetail borrowDetail)throws Exception;

	public int add(Connection con, BorrowDetail borrowDetail) throws Exception;

	public int returnBook(Connection con,BorrowDetail detail)throws Exception;
}
