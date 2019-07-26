package com.chinasoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DBUtil {

	//驱动名
	private static final String DRIVER ="com.mysql.jdbc.Driver";//oracle.jdbc.driver.OracleDriver
	//连接地址
	private static final String URL ="jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8";//jdbc:oracle:thin:@localhost:1521:orcl
	//用户名
	private static final String USERNAME ="root"; //root
	//密码
	private static final String PASSWORD ="root";  //root
	
	//加载驱动
	 static {
		 try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			 System.out.println("请查看Oracle/MySql JDBC驱动的正确性");
			}
	 }
	 //获得连接的方法
	 public static Connection getConn()
	 {
		 Connection conn = null;
		 try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
	 }
	 //关闭资源方法
	 public static void release(Statement stmt,Connection conn)
	 {
		 release(null,stmt,conn);
	 }
	 //方法重载
	 public static void release(ResultSet rs ,Statement stmt,Connection conn)
	 {
		  if (rs != null)
		  {
			  try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }
		  
		  if (stmt != null)
		  {
			  try {
				  stmt.close();
				  stmt = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }
		  
		  if (conn != null)
		  {
			  try {
				  conn.close();
				  conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }
	 }
}
