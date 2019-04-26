 package com.ppchatcllient.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{
	public static HashMap hmfriendChat1=new HashMap<String,FriendChat1>();//键值对
	CardLayout cardLayout;
	//NO.1
	//bei
	JPanel myhaoyou;
	JButton haoyou;
	//中
	JScrollPane myfriendJScrollPane;
	JPanel myfriendlistJPanel;
	static final int FRIEND=51;
	JLabel[] myfriendJLabel=new JLabel[FRIEND];
	
	
	
	//nan
	JPanel moshangrenmianban;
	JButton moshangren;
	JButton heimingdan;
	
	
	//NO.2
	//bei
	JPanel mymoshangren;
	JButton moshangren1;
	JButton haoyou1;
	//nan
	JPanel moshangrenmianban1;
	JButton heimingdan1;
	String userName;
	public FriendList(String userName){
		this.userName=userName;
		//NO.1被
		
		myhaoyou=new JPanel(new BorderLayout());
		haoyou=new JButton("我的好友");
		myhaoyou.add(haoyou,"North");
		//zhong
	

		myfriendlistJPanel=new JPanel(new GridLayout(FRIEND-1,1));
		 for(int i=1;i<FRIEND;i++){
			 myfriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			 myfriendJLabel[i].setEnabled(false);//未激活所有图标
			 //激活自己
			 /*if(Integer.parseInt(userName)==i)
				 myfriendJLanel[i].setEnabled(true);*/
			 myfriendJLabel[i].addMouseListener(this);//鼠标监听器
			 myfriendlistJPanel.add(myfriendJLabel[i]);
			 
		 }
		//激活自己
		 myfriendJLabel[Integer.parseInt(userName)].setEnabled(true);
		 myfriendJScrollPane=new JScrollPane(myfriendlistJPanel);
		 myhaoyou.add(myfriendJScrollPane);
		//NO.1nan
		moshangrenmianban=new JPanel(new GridLayout(2,1));
		moshangren=new JButton("我的陌生人");
		moshangren.addActionListener(this);//事件监听器
		heimingdan=new JButton("黑名单");
		moshangrenmianban.add(moshangren);
		moshangrenmianban.add(heimingdan);
		myhaoyou.add(moshangrenmianban,"South");
		//NO.2
		mymoshangren=new JPanel(new BorderLayout());
	
		//bei
		moshangrenmianban1=new JPanel(new GridLayout(2,1));
		haoyou1=new JButton("我的好友");
		haoyou1.addActionListener(this);//事件监听器
		moshangren1=new JButton("我的陌生人");

		moshangrenmianban1.add(haoyou1);
		moshangrenmianban1.add(moshangren1);
		mymoshangren.add(moshangrenmianban1,"North");
		//nan
		heimingdan1=new JButton("黑名单");
		mymoshangren.add(heimingdan1,"South");
		
		
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myhaoyou,"1");
		this.add(mymoshangren,"2");
		this.setSize(240,500);
		this.setTitle(userName+" dz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		//FriendList friendList=new FriendList();
		
		
	}
	public void setEnableFriendIcon(String friendString){
		//
		String[] friendName=friendString.split(" ");
		int count=friendName.length;
		for(int i=0;i<count;i++){
			System.out.println("friendName["+i+"]:"+friendName[i]);
			 myfriendJLabel[Integer.parseInt(friendName[i])].setEnabled(true);
		} 	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==moshangren){
			cardLayout.show(this.getContentPane(),"2");
		}
		if(arg0.getSource()==haoyou1){
			cardLayout.show(this.getContentPane(),"1");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount()==2){
			JLabel jlb1=(JLabel)arg0.getSource();
			String receiver=jlb1.getText();
			//FriendChat1 friendChat1=new FriendChat1(this.userName,receiver);
			// new Thread(new friendChat1(this.userName,receiver)).start();
			FriendChat1 friendChat1=(FriendChat1)hmfriendChat1.get(userName+"to"+receiver);
			if(friendChat1==null)
			{
				friendChat1=new FriendChat1(this.userName,receiver);
				hmfriendChat1.put(userName+"to"+receiver,friendChat1);
			}else
			{
				friendChat1.setVisible(true);
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	     JLabel jlabel=(JLabel)e.getSource();
	     jlabel.setForeground(Color.blue);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel jlabel=(JLabel)e.getSource();
	     jlabel.setForeground(Color.black);
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
