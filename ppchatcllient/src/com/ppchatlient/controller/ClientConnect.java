package com.ppchatlient.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;


import com.yychat.model.Message;
import com.yychat.model.user;

public class ClientConnect {
	
	public static Socket s;
	
	public static HashMap hmSocket=new HashMap<String,Socket>();

	public ClientConnect(){
		try {
			s = new Socket("127.0.0.1", 3456);// 本机地址，回测地址
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean  loginValidate(user user){
		boolean loginSuccess=false;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		Message mess=null;
	try {
		oos=new ObjectOutputStream (s.getOutputStream());
		oos.writeObject(user);
		
		ois=new ObjectInputStream(s.getInputStream());
		 mess=(Message)ois.readObject();
		if(mess.getMessageType().equals(Message.message_LoginSuccess)){
			loginSuccess=true;
				System.out.println(user.getUserName()+"登陆成功");
				hmSocket.put(user.getUserName(), s);
				 new ClientReceiverTiread(s).start();
			}
		
	} catch (IOException | ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	return loginSuccess;
	}
}
