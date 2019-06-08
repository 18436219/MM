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
	try {//�����쳣
		//double 
		ss= new ServerSocket(3456);
		System.out.println("�������Ѿ�����������3456�˿�");
		while(true){
	    s= ss.accept();//������������
		System.out .println("���ӳɹ�:"+s);
		
		//����uear
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
		//������֤
		 mess=new Message();
		 mess.setSender("Senver");
		 mess.setReceiver(userName);
		
		// boolean loginSuccess=YyhatDbUtil.loginValidate(userName, passWord);
		if(loginSuccess){//����Ƚ�
			 mess.setMessageType(Message.message_LoginSuccess);//1Ϊ��֤ͨ��
			 //�������ݱ��к�����Ϣ��
			 String friendString=YyhatDbUtil.getFriendString(userName);
				
				mess.setContent(friendString);
				System.out.println(userName+"��relation�����ݱ���ѣ� "+friendString);
		 }else{
			 mess.setMessageType(Message.message_LoginFailure);//0Ϊ��֤ ��ͨ��
		 }
		 sendMessage(s,mess);
			//��������
			 if(loginSuccess){
			 //1.��
			 mess.setMessageType(Message.message_NewOnlineFriend);//������Ϣ������
			 mess.setSender("Server");
			 mess.setContent(userName);//������Ϣ������
			 //�õ��û���������
			Set onlineFriendSet=hmSocket.keySet();
			Iterator it=onlineFriendSet.iterator();
			String friendName;
			while(it.hasNext()){
				friendName=(String)it.next();
				mess.setReceiver(friendName);
				//��friendName������Ϣ
				Socket s1=(Socket)hmSocket.get(friendName);
				sendMessage(s1,mess);
			}
			 hmSocket.put(userName, s);
			 new ServerReceiverThread(s).start();
		 }	
		}
		}
		} catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();//�����쳣
	} 
	}
	private void sendMessage(Socket s,Message mess) throws IOException {
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		 oos.writeObject(mess);
	}
}
