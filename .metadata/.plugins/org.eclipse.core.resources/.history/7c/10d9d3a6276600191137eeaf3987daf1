/*package com.ppchatcllient.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.ppchatlient.controller.ClientConnect;
import com.yychat.model.Message;

public class friendChat extends JFrame implements ActionListener,Runnable{

	//zhong
	JScrollPane jsp;
	JTextArea jta;
	
	//nan
	JPanel jk;
	JTextField jtb;
	JButton ji;

    String sender;
    String receiver;
	public friendChat(String sender,String receiver){
		this.sender=sender;
		this.receiver=receiver;
		jta=new JTextArea();//文本框
		jta.setEditable(false);
		
		jsp=new JScrollPane(jta);
		this.add(jsp,"Center");
		//nan
		jk=new JPanel();
		jtb=new JTextField(15);
		ji=new JButton("发送");
		ji.addActionListener(this);
		jk.add(jtb);
		jk.add(ji);
		this.add(jk,"South");
		
		this.setSize(350,240);
		this.setTitle(receiver);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		//friendChat friendChat=new friendChat();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==ji) {
			jta.append(jtb.getText()+"\r\n");
			//向服务器发送聊天信息
			Message mess=new Message();
			mess.setSender(sender);
			mess.setReceiver(receiver);
			mess.setContent(jtb.getText());
			mess.setMessageType(Message.message_Common);
			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(ClientConnect.s.getOutputStream());
				oos.writeObject(mess);
				
				/*ObjectInputStream ois = new ObjectInputStream(ClientConnect.s.getInputStream());
				mess=(Message)ois.readObject();
				String showMessage=mess.getSender()+"对"+mess.getReceiver()+"说"+mess.getClass();
				System.out.println(showMessage);
				
				jta.append(showMessage+"\r\n");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	/*@Override
	public void run() {
		ObjectInputStream ois;
		while(true){
			try {
			
			ois = new ObjectInputStream(ClientConnect.s.getInputStream());
			Message mess=(Message)ois.readObject();
			String showMessage=mess.getSender()+"对"+mess.getReceiver()+"说"+mess.getContent();
			System.out.println(showMessage);
			
			jta.append(showMessage+"\r\n");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		
		
	}

}
*/