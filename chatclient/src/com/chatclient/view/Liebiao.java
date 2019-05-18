package com.chatclient.view;

import java.awt.CardLayout;
import java.awt.*;

import javax.swing.*;

public class Liebiao extends JFrame{
	CardLayout cardLayout;
	//第一张卡片
	JButton wdhy,wdmsr,hmd;
	JPanel myfriend1;
	
	//第二张卡片
	JButton wdhy1,wdmsr1,hmd1;
	JPanel myfriend2;
	
	
	public Liebiao(){
		//第一张
		//上部
		/*wdhy=new JButton("我的好友");
		this.add(wdhy,"North");
		//下部
		myfriend1=new JPanel(new GridLayout(2,1));
		wdmsr=new JButton("我的抹上人");
		hmd=new JButton("黑名单");
		myfriend1.add(wdmsr);myfriend1.add(hmd);
		this.add(myfriend1,"South");*/
		//第二张
		//上部
		myfriend2=new JPanel(new GridLayout(2,1));
		wdhy1=new JButton("我的好友");
		wdmsr1=new JButton("我的抹上人");
		myfriend2.add(wdhy1);
		myfriend2.add(wdmsr1);
		this.add(myfriend2,"North");
		//下部
		hmd1=new JButton("黑名单");
		this.add(hmd1,"South");
		
		
		
		
		
		
		
		
		
		
		
		//窗口属性
		
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
