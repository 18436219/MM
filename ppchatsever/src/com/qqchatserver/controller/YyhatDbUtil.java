package com.qqchatserver.controller;

import java.nio.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YyhatDbUtil {
	 //从数据库中实现用户的登路
	public static final String MYSQLDRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://127.0.0.1:3306/yychat?useUnicode=true&characterEncoding=UTF-8";
	public static final String DBUSER="root";
	public static final String DBPASS="";
	
	 //1.加载驱动程序
	public static void LoadDriver(){
		try{
			Class.forName(MYSQLDRIVER);
			System.out.println("已经加载了数据库驱动！");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	 public static Connection getConnection(){
		 LoadDriver();
		 Connection conn=null;
		 try{
			 conn = DriverManager.getConnection(URL,DBUSER,DBPASS);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		
	 }
	 public static boolean loginValidate(String userName,String passWord) {
		 boolean loginSuccess=false;
		 Connection conn=getConnection();
		//3、创建PreparedStatement对象，用来执行SQL语句
			String user_Login_Sql="select * from user where username=? and password=?";
			PreparedStatement ptmt=null;
         	ResultSet rs=null;
			try{
				ptmt=conn.prepareStatement(user_Login_Sql);
				ptmt.setString(1, userName);
				ptmt.setString(2, passWord);
			
			
			
			//4、执行查询，返回结果集
			 rs=ptmt.executeQuery();
			
			//5、根据结果集来判断是否能登录
			 loginSuccess=rs.next();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeDB(conn,ptmt,rs);
			}
			System.out.println("loginSuccess"+loginSuccess);
			return loginSuccess;
			
	 }
	 public static String getFriendString(String userName) {
		    Connection conn=getConnection();
		    String friend_Relation_Sql="select * from user where username=? and password=?";
			PreparedStatement ptmt=null;
			String friendString="";
			ResultSet rs=null;
			try{
			
			ptmt = conn.prepareStatement(friend_Relation_Sql);
			ptmt.setString(1, userName);
			rs=ptmt.executeQuery();
			while(rs.next()){
				friendString=friendString+rs.getString("slaveuser")+" ";
				}
			}catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				closeDB(conn,ptmt,rs);
			}
		 
		return friendString;
		 
	 }
	 public static void closeDB(Connection conn,PreparedStatement ptmt,ResultSet rs){
		 if(conn!=null){
			 try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 if(ptmt!=null){
			 try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(rs!=null){
			 try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 }
	 }
	
}