package com.demo.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
		public static Connection getConnection() {
//				String dburl="jdbc:oracle:thin:@localhost:1521:ORCL";
				String dburl="jdbc:oracle:thin:@//175.178.170.246:1521/ORCLPDB";
				String username="system";
//				String password="Hulailai28951378";
				String password="123456";
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection conn=DriverManager.getConnection(dburl,username,password);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			return null;
		}
//			Connection conn=null;
//			Context ctx=null;
//			try {
//				ctx=new InitialContext();
//				DataSource source=(DataSource)ctx.lookup("java:comp/env/jdbc/volunteer");
//				Connection connection=source.getConnection();
//				if(connection!=null) {
//					conn=connection;
//				}
//			} catch (NamingException e) {
//				e.printStackTrace();
//			} catch(SQLException e) {
//				e.printStackTrace();
//			}
//			return conn;
//		}
}
