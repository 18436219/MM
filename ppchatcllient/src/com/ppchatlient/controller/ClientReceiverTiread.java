package com.ppchatlient.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.ppchatcllient.view.ClientLogin;
import com.ppchatcllient.view.FriendChat1;
import com.ppchatcllient.view.FriendList;
import com.yychat.model.Message;

public class ClientReceiverTiread extends Thread {
	
	ObjectInputStream ois;
	  private Socket s;
      public ClientReceiverTiread(Socket s){
    	  this.s=s;
      }
	  public void run() {
			//ObjectInputStream ois;
			while(true){
				try {
				
				ois = new ObjectInputStream(ClientConnect.s.getInputStream());
				Message mess=(Message)ois.readObject();
				String showMessage=mess.getSender()+"对"+mess.getReceiver()+"说"+mess.getContent();
				System.out.println(showMessage);
				if(mess.getMessageType().equals(Message.message_AddFriendFailure_NoUser)){
					JOptionPane.showMessageDialog(null ,"添加好友失败！用户不存在");
				}
				if(mess.getMessageType().equals(Message.message_AddFriendFailure_AlreadyFriend)){
					JOptionPane.showMessageDialog(null ,"添加好友失败！用户已经添加");
				}
				if(mess.getMessageType().equals(Message.message_AddFriendSuccess)){
					JOptionPane.showMessageDialog(null ,"添加好友成功");
					String allFriendName=mess.getContent();
					FriendList friendList=(FriendList)ClientLogin.hmFriendList.get(mess.getSender());
					friendList.updateFriendIcon(allFriendName);
					friendList.revalidate();
				}
				
				if(mess.getMessageType().equals(Message.message_Common)){
					//jta.append(showMessage+"\r\n");
					
					// 在好友界面上显示聊天信息
					//1.如何得到聊天信息
					FriendChat1 friendChat1=(FriendChat1)FriendList.hmfriendChat1.get(mess.getReceiver()+"to"+mess.getSender());
					//2.再显示信习
					friendChat1.appendJta(showMessage);
				}
				//第3步：客户端接受服务器发送来的在线好友信息，然后利用该信息激活在线好友的图标
				if(mess.getMessageType().equals(Message.message_OnlineFriend)){
					System.out.println("在线好友"+mess.getContent());
					
					//首先要拿到好友列表对象
					
					FriendList friendList=(FriendList)ClientLogin.hmFriendList.get(mess.getReceiver());
//					激活对应图标,
					
					friendList.setEnableFriendIcon(mess.getContent());	
				}
				
				
				if(mess.getMessageType().equals(Message.message_NewOnlineFriend)){
					System.out.println("新用户上线了，用户名"+mess.getContent());
					//首先要拿到好友列表对象
					FriendList  friendList=(FriendList)ClientLogin.hmFriendList.get(mess.getReceiver());
					System.out.println("FriendList的用户名"+mess.getReceiver());
//					激活对应图标,
					
					friendList.setEnableFriendIcon(mess.getContent());
					
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
				
			}
	  }
	  }
	