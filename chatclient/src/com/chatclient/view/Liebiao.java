package com.chatclient.view;

import java.awt.CardLayout;
import java.awt.*;

import javax.swing.*;

public class Liebiao extends JFrame{
	CardLayout cardLayout;
	//��һ�ſ�Ƭ
	JButton wdhy,wdmsr,hmd;
	JPanel myfriend1;
	
	//�ڶ��ſ�Ƭ
	JButton wdhy1,wdmsr1,hmd1;
	JPanel myfriend2;
	
	
	public Liebiao(){
		//��һ��
		//�ϲ�
		/*wdhy=new JButton("�ҵĺ���");
		this.add(wdhy,"North");
		//�²�
		myfriend1=new JPanel(new GridLayout(2,1));
		wdmsr=new JButton("�ҵ�Ĩ����");
		hmd=new JButton("������");
		myfriend1.add(wdmsr);myfriend1.add(hmd);
		this.add(myfriend1,"South");*/
		//�ڶ���
		//�ϲ�
		myfriend2=new JPanel(new GridLayout(2,1));
		wdhy1=new JButton("�ҵĺ���");
		wdmsr1=new JButton("�ҵ�Ĩ����");
		myfriend2.add(wdhy1);
		myfriend2.add(wdmsr1);
		this.add(myfriend2,"North");
		//�²�
		hmd1=new JButton("������");
		this.add(hmd1,"South");
		
		
		
		
		
		
		
		
		
		
		
		//��������
		
		this.setSize(300,750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setTitle();
	}

	public static void main(String[] args) {
		Liebiao liebiao=new Liebiao();

	}

}
