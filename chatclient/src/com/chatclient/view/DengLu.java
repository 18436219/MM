package com.chatclient.view;

import java.awt.*;

import javax.swing.*;

public class DengLu extends JFrame{
	JLabel ji1;
	
	JTabbedPane j1;
	JPanel ja1;
	JLabel  jb1,jb2,jb3,jb4;
	JButton js1;
	JTextField jd1;
	JPasswordField jf1;
	JCheckBox jh1,jh2;
	
	
	
	JPanel ji2;
	JButton jk1,jk2,jk3;
	
	
	
	public DengLu(){
		ji1=new JLabel(new ImageIcon("tupain/tou.gif"));
		this.add(ji1,"North");
		
		j1=new JTabbedPane();
		ja1=new JPanel(new GridLayout(3,3));
		jb1=new JLabel("YYºÅÂë",JLabel.CENTER);
		jb2=new JLabel("YºÅÂë");jb3=new JLabel("ºÅÂë");jb4=new JLabel("Âë");
		js1=new JButton(new ImageIcon("tupain/clear.gif"));
		jd1=new JTextField();jf1=new JPasswordField();
		jh1=new JCheckBox("hugug ");  jh2=new JCheckBox("hiioiohioh ");
		
		ja1.add(jb1);ja1.add(jd1);ja1.add(js1);
		ja1.add(jb2);ja1.add(jf1);ja1.add(jb3);
		ja1.add(jh1);ja1.add(jh2);ja1.add(jb4);
		
		j1.add(ja1,"ÓÃ»§");
		this.add(j1);
		
		
		
		ji2=new JPanel();
		jk1=new JButton(new ImageIcon("tupain/denglu.gif"));
		jk2=new JButton(new ImageIcon("tupain/zhuce.gif"));
		jk3=new JButton(new ImageIcon("tupain/quxiao.gif"));
		ji2.add(jk1);ji2.add(jk2);ji2.add(jk3);
		this.add(ji2,"South");
		
		this.setSize(340,350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		DengLu dengLu=new DengLu();

	}

}
