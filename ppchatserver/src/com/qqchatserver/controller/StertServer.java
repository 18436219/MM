package com.qqchatserver.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import com.yychat.model.user;

public class StertServer {
	ServerSocket ss;
	public StertServer(){
	try {//捕获异常
		//double 
		ss= new ServerSocket(3456);
		System.out.println("服务器已经启动，监听3456端口");
		Socket s= ss.accept();//接受连接请求
		System.out .println("连接成功:"+s);
		
		//接受uear
		ObjectInputStream oos=new ObjectInputStream (s.getInputStream());
		 user user=(user)oos.readObject();
		 System.out.println(user.getUserName());
		 System.out.println(user.getPassName());
	} catch (IOException e) {
		
		e.printStackTrace();//处理异常
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
