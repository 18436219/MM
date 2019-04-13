package com.ppchatlient.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.ppchatcllient.view.FriendChat1;
import com.ppchatcllient.view.FriendList;
import com.yychat.model.Message;

public class ClientReceiverTiread extends Thread {
	
	  private Socket s;
      public ClientReceiverTiread(Socket s){
    	  this.s=s;
      }
	  public void run() {
			ObjectInputStream ois;
			while(true){
				try {
				
				ois = new ObjectInputStream(ClientConnect.s.getInputStream());
				Message mess=(Message)ois.readObject();
				String showMessage=mess.getSender()+"对"+mess.getReceiver()+"说"+mess.getContent();
				System.out.println(showMessage);
				
				//jta.append(showMessage+"\r\n");
				
				// 在好友界面上显示聊天信息
				//1.如何得到聊天信息
				FriendChat1 friendChat1=(FriendChat1)FriendList.hmfriendChat1.get(mess.getReceiver()+"to"+mess.getSender());
				//2.再显示信习
				friendChat1.appendJta(showMessage);
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
				
			}
	  }
	  }
	