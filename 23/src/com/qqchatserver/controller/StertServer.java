package com.qqchatserver.controller;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.yychat.model.Message;
import com.yychat.model.user;

public class StertServer {
	 public static HashMap hmSocket=new HashMap<String,Socket>();
	String userName;
	Socket s;
	Message mess;
	String passWord;
	ServerSocket ss;
	public StertServer(){
	try {//捕获异常
		//double 
		ss= new ServerSocket(3456);
		System.out.println("服务器已经启动，监听3456端口");
		while(true){
	    s= ss.accept();//接受连接请求
		System.out .println("连接成功:"+s);
		
		//接受uear
		ObjectInputStream ois=new ObjectInputStream (s.getInputStream());
		 user user=(user)ois.readObject();
		 userName=user.getUserName();
		 passWord=user.getPassName();
		 System.out.println(userName);
		 System.out.println(passWord);
		 //从数据库中实现用户的登路
		 //1.加载驱动程序
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("已经加载了数据库驱动！");
		//2、连接数据库
		//String url="jdbc:mysql://127.0.0.1:3306/yychat";
		//中文用户名必须用下面的url
		String url="jdbc:mysql://127.0.0.1:3306/yychat?useUnicode=true&characterEncoding=UTF-8";
		String dbUser="root";
		String dbPass="";				
		Connection conn=DriverManager.getConnection(url,dbUser,dbPass);
		//3、创建PreparedStatement对象，用来执行SQL语句
		String user_Login_Sql="select * from user where username=? and password=?";
		PreparedStatement ptmt=conn.prepareStatement(user_Login_Sql);
		ptmt.setString(1, userName);
		ptmt.setString(2, passWord);
		
		//4、执行查询，返回结果集
		ResultSet rs=ptmt.executeQuery();
		
		//5、根据结果集来判断是否能登录
		boolean loginSuccess=rs.next();	
		 
		 
		 
		 
		 
		//密码验证
		 mess=new Message();
		 mess.setSender("Senver");
		 mess.setReceiver(passWord);
		
		 if(passWord.equals("123456")){//对象比较
			 mess.setMessageType(Message.message_LoginSuccess);//1为验证通过
		 }else{
			 mess.setMessageType(Message.message_LoginFailure);//0为验证 不通过
		 }
		 sendMessage(s,mess);
			//接受聊天
		 if(passWord.equals("123456")){
			 //1.在
			 mess.setMessageType(Message.message_NewOnlineFriend);//发送消息的类型
			 mess.setSender("Server");
			 mess.setContent(this.userName);//发送消息的内容
			 //拿到用户的名字了
			Set onlineFriendSet=hmSocket.keySet();
			Iterator it=onlineFriendSet.iterator();
			
			String friendName;
			while(it.hasNext()){
				friendName=(String)it.next();
				mess.setReceiver(friendName);
				//向friendName发送消息
				Socket s1=(Socket)hmSocket.get(friendName);
				sendMessage(s1,mess);
			}
			
			 
			 hmSocket.put(userName, s);
			 new ServerReceiverThread(s).start();
		 }	
		}
	} catch (IOException e) {
		
		e.printStackTrace();//处理异常
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	}
	private void sendMessage(Socket s,Message mess) throws IOException {
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		 oos.writeObject(mess);
	}
}
