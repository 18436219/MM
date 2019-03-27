package com.ppchatserver.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.qqchatserver.controller.StertServer;

public class Chatserver extends JFrame implements ActionListener{

	JButton jb1;
	JButton jb2;
	JPanel jp;

	
	public Chatserver(){
		jb1=new JButton("启动");
		jb1.addActionListener(this);//事件监听器
		jb2=new JButton("关闭");
		jp=new JPanel();
		jp.add(jb1);
		jp.add(jb2);
		this.add(jp);
		
		this.setSize(240,300);
		this.setTitle("服务器");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Chatserver chatserver=new Chatserver();

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		StertServer stertserver=new StertServer();

		
	}

}
