package cn.itcast.bookmanager.dao;


import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import cn.itcast.bookmanager.model.Book;
import cn.itcast.bookmanager.utils.toolUtil;

public interface BookDao {
	
	// 图书添加
	public int add(Connection con,Book book)throws Exception;
	
	// 图书信息查询
	public ResultSet list(Connection con,Book book)throws Exception;

	// 图书信息查询(学生)
	public ResultSet listCan(Connection con,Book book)throws Exception;
	
	//图书信息删除
	public int delete(Connection con,String id)throws Exception;
	
	//图书信息修改
	public int update(Connection con,Book book)throws Exception;
	
}
