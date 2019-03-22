package com.ppchatcllient.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class friendChat extends JFrame implements ActionListener{

	//zhong
	JScrollPane jsp;
	JTextArea jta;
	
	//nan
	JPanel jk;
	JTextField jtb;
	JButton ji;
	
	public friendChat(String sender,String receiver){
		jta=new JTextArea();//нд╠╬©Р
		jta.setEditable(false);
		
		jsp=new JScrollPane(jta);
		this.add(jsp,"Center");
		//nan
		jk=new JPanel();
		jtb=new JTextField(15);
		ji=new JButton("fasong");
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
		if(arg0.getSource()==ji) jta.append(jtb.getText()+"\r\n");
		
	}

}
