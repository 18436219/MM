package com.qqchatserver.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import com.yychat.model.user;

public class StertServer {
	ServerSocket ss;
	public StertServer(){
	try {//�����쳣
		//double 
		ss= new ServerSocket(3456);
		System.out.println("�������Ѿ�����������3456�˿�");
		Socket s= ss.accept();//������������
		System.out .println("���ӳɹ�:"+s);
		
		//����uear
		ObjectInputStream oos=new ObjectInputStream (s.getInputStream());
		 user user=(user)oos.readObject();
		 System.out.println(user.getUserName());
		 System.out.println(user.getPassName());
	} catch (IOException e) {
		
		e.printStackTrace();//�����쳣
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}