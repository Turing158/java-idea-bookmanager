package cn.itcast.bookmanager.dao;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import cn.itcast.bookmanager.model.BorrowDetail;

public interface BorrowDetailDao {
	
	public ResultSet list(Connection con,BorrowDetail borrowDetail)throws Exception;

	public int add(Connection con, BorrowDetail borrowDetail) throws Exception;

	public int returnBook(Connection con,BorrowDetail detail)throws Exception;
}
