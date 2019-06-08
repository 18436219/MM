package com.chatclientserver.view;

import java.awt.event.*;

import javax.swing.*;

import com.server.controller.Server;

public class Fuwuqi extends JFrame implements ActionListener {
	
	JButton a1,a2;
	JPanel k1;
	
	public Fuwuqi(){
		a1=new JButton("启动");
		a1.addActionListener(this);
		a2=new JButton("关闭");
		k1=new JPanel();
		k1.add(a1);
		k1.add(a2);
		this.add(k1);
		
		this.setSize(250,250);
		this.setTitle("服务器");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		Fuwuqi fuwuqi=new Fuwuqi();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Server();
		
	}

}
