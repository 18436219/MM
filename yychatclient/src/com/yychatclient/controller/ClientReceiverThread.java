package com.yychatclient.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.yychat.model.Message;

public class ClientReceiverThread extends Thread{

	private Socket s;
	
	public ClientReceiverThread(Socket s){
		this.s=s;
	}
	public void run(){
		ObjectInputStream ois;
		while(true){
			try {
				ois = new ObjectInputStream(s.getInputStream());
				Message mess=(Message)ois.readObject();//接收聊天信息,线程阻塞
				String showMessage=mess.getSender()+"对"+mess.getReceiver()+"说："+mess.getContent();
				System.out.println(showMessage);
				//jta.append(showMessage+"\r\n");
				
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}
	}
}
