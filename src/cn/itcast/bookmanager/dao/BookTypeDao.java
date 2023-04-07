package cn.itcast.bookmanager.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.itcast.bookmanager.model.BookType;
import cn.itcast.bookmanager.utils.toolUtil;
public interface BookTypeDao {
	
	// 图书类别添加
	public int add(Connection con,BookType bookType)throws Exception;
	
	//查询图书类别集合
	public ResultSet list(Connection con,BookType bookType)throws Exception;
	
	//删除图书类别
	public int delete(Connection con,String id)throws Exception;
	
	// 更新图示类别
	public int update(Connection con,BookType bookType)throws Exception;
}
