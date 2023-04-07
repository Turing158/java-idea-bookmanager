package cn.itcast.bookmanager.dao;


import cn.itcast.bookmanager.model.Book;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;

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
