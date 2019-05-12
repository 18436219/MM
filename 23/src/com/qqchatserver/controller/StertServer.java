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
	try {//�����쳣
		//double 
		ss= new ServerSocket(3456);
		System.out.println("�������Ѿ�����������3456�˿�");
		while(true){
	    s= ss.accept();//������������
		System.out .println("���ӳɹ�:"+s);
		
		//����uear
		ObjectInputStream ois=new ObjectInputStream (s.getInputStream());
		 user user=(user)ois.readObject();
		 userName=user.getUserName();
		 passWord=user.getPassName();
		 System.out.println(userName);
		 System.out.println(passWord);
		 //�����ݿ���ʵ���û��ĵ�·
		 //1.������������
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("�Ѿ����������ݿ�������");
		//2���������ݿ�
		//String url="jdbc:mysql://127.0.0.1:3306/yychat";
		//�����û��������������url
		String url="jdbc:mysql://127.0.0.1:3306/yychat?useUnicode=true&characterEncoding=UTF-8";
		String dbUser="root";
		String dbPass="";				
		Connection conn=DriverManager.getConnection(url,dbUser,dbPass);
		//3������PreparedStatement��������ִ��SQL���
		String user_Login_Sql="select * from user where username=? and password=?";
		PreparedStatement ptmt=conn.prepareStatement(user_Login_Sql);
		ptmt.setString(1, userName);
		ptmt.setString(2, passWord);
		
		//4��ִ�в�ѯ�����ؽ����
		ResultSet rs=ptmt.executeQuery();
		
		//5�����ݽ�������ж��Ƿ��ܵ�¼
		boolean loginSuccess=rs.next();	
		 
		 
		 
		 
		 
		//������֤
		 mess=new Message();
		 mess.setSender("Senver");
		 mess.setReceiver(passWord);
		
		 if(passWord.equals("123456")){//����Ƚ�
			 mess.setMessageType(Message.message_LoginSuccess);//1Ϊ��֤ͨ��
		 }else{
			 mess.setMessageType(Message.message_LoginFailure);//0Ϊ��֤ ��ͨ��
		 }
		 sendMessage(s,mess);
			//��������
		 if(passWord.equals("123456")){
			 //1.��
			 mess.setMessageType(Message.message_NewOnlineFriend);//������Ϣ������
			 mess.setSender("Server");
			 mess.setContent(this.userName);//������Ϣ������
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
	} catch (IOException e) {
		
		e.printStackTrace();//�����쳣
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
