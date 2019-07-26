package com.chinasoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ⹤����
 * @author Administrator
 *
 */
public class DBUtil {

	//������
	private static final String DRIVER ="com.mysql.jdbc.Driver";//oracle.jdbc.driver.OracleDriver
	//���ӵ�ַ
	private static final String URL ="jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8";//jdbc:oracle:thin:@localhost:1521:orcl
	//�û���
	private static final String USERNAME ="root"; //root
	//����
	private static final String PASSWORD ="root";  //root
	
	//��������
	 static {
		 try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			 System.out.println("��鿴Oracle/MySql JDBC��������ȷ��");
			}
	 }
	 //������ӵķ���
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
	 //�ر���Դ����
	 public static void release(Statement stmt,Connection conn)
	 {
		 release(null,stmt,conn);
	 }
	 //��������
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
