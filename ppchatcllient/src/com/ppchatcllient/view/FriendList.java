package com.ppchatcllient.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{
	CardLayout cardLayout;//
	//NO.1
	//bei
	JPanel myhaoyou;
	JButton haoyou;
	//��
	JScrollPane myfriendJScrollPane;
	JPanel myfriendlist;
	static final int FRIEND=51;
	JLabel[] myfriendJLanel=new JLabel[FRIEND];
	
	
	
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
		//NO.1��
		
		myhaoyou=new JPanel(new BorderLayout());
		haoyou=new JButton("�ҵĺ���");
		myhaoyou.add(haoyou,"North");
		//zhong
	
		 myfriendlist=new JPanel(new GridLayout(FRIEND-1,1));
		 for(int i=1;i<FRIEND;i++){
			 myfriendJLanel[i]=new JLabel(i+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			 myfriendJLanel[i].addMouseListener(this);//��������
			 myfriendlist.add(myfriendJLanel[i]);
		 }
		 myfriendJScrollPane=new JScrollPane(myfriendlist);
		 myhaoyou.add(myfriendJScrollPane);
		//NO.1nan
		moshangrenmianban=new JPanel(new GridLayout(2,1));
		moshangren=new JButton("�ҵ�İ����");
		moshangren.addActionListener(this);//�¼�������
		heimingdan=new JButton("������");
		moshangrenmianban.add(moshangren);
		moshangrenmianban.add(heimingdan);
		myhaoyou.add(moshangrenmianban,"South");
		//NO.2
		mymoshangren=new JPanel(new BorderLayout());
	
		//bei
		moshangrenmianban1=new JPanel(new GridLayout(2,1));
		haoyou1=new JButton("�ҵĺ���");
		haoyou1.addActionListener(this);//�¼�������
		moshangren1=new JButton("�ҵ�İ����");

		moshangrenmianban1.add(haoyou1);
		moshangrenmianban1.add(moshangren1);
		mymoshangren.add(moshangrenmianban1,"North");
		//nan
		heimingdan1=new JButton("������");
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
			new friendChat(this.userName,receiver);
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