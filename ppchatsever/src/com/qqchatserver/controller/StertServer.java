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
import com.yychat.model.User;
 

public class StertServer {
	 public static HashMap hmSocket=new HashMap<String,Socket>();
	String userName;
	Socket s;
	Message mess;
	String passWord;
	ServerSocket ss;
	public StertServer() {
	try {//捕获异常
		//double 
		ss= new ServerSocket(3456);
		System.out.println("服务器已经启动，监听3456端口");
		while(true){
	    s= ss.accept();//接受连接请求
		System.out .println("连接成功:"+s);
		
		//接受uear
		 ObjectInputStream ois=new ObjectInputStream (s.getInputStream());
		 User user=(User)ois.readObject();
		 userName=user.getUserName();
		 passWord=user.getPassName();
		 System.out.println(passWord);
		 System.out.println(user.getuserMessageType());
		if(user.getuserMessageType().equals("USER_REGISTER")){
			 boolean seekUserResult=YyhatDbUtil.seekUser(userName);
			 mess=new Message();
			 mess.setSender("sender");
			 mess.setReceiver(userName);
		
		if(seekUserResult){
			 mess.setMessageType(Message.message_RegisterFailure);
		 }else{
			 YyhatDbUtil.addUser(userName,passWord);
			 mess.setMessageType(Message.message_RegisterSuccess);
		 }
		sendMessage(s,mess);
		s.close();
		}
		System.out.println(user.getuserMessageType());
		if(user.getuserMessageType().equals("UESR_LOGIN")){
			System.out.println(1);
		boolean loginSuccess=YyhatDbUtil.loginValidate(userName, passWord);
		//密码验证
		 mess=new Message();
		 mess.setSender("Senver");
		 mess.setReceiver(userName);
		
		// boolean loginSuccess=YyhatDbUtil.loginValidate(userName, passWord);
		if(loginSuccess){//对象比较
			 mess.setMessageType(Message.message_LoginSuccess);//1为验证通过
			 //利用数据表中好友信息来
			 String friendString=YyhatDbUtil.getFriendString(userName);
				
				mess.setContent(friendString);
				System.out.println(userName+"的relation的数据表好友： "+friendString);
		 }else{
			 mess.setMessageType(Message.message_LoginFailure);//0为验证 不通过
		 }
		 sendMessage(s,mess);
			//接受聊天
			 if(loginSuccess){
			 //1.在
			 mess.setMessageType(Message.message_NewOnlineFriend);//发送消息的类型
			 mess.setSender("Server");
			 mess.setContent(userName);//发送消息的内容
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
		}
		} catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();//处理异常
	} 
	}
	private void sendMessage(Socket s,Message mess) throws IOException {
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		 oos.writeObject(mess);
	}
}
