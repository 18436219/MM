package com.difu.view;

import java.awt.*;
import java.awt.*;

import javax.swing.*;

public class difulogin extends JFrame{
	
	JLabel ja1,ja2,ja3;
	JButton jb1;
	JTextField j1;
	Container j;
	Font a1;
	JPanel jc1;
	
	public difulogin(){
		a1=new Font("黑体",Font.BOLD,120);
		ja1=new JLabel(new ImageIcon("tupian/timg.jpg"));
		//绝对布局是，布局设为空
		this.getContentPane().setLayout(null);
		//将图片设为窗体大小，覆盖整个界面
		ja1.setBounds(0,0,740,650);
		this.getLayeredPane().add(ja1,new Integer(Integer.MIN_VALUE));
		
		//组件放在ContentPane层
		ja2=new JLabel("往生舟");
		ja2.setFont(a1);
		jb1=new JButton("");
		
		
		this.getContentPane().setLayout(new FlowLayout());
		//内容面板强制转化面板类型，设为不透明
		jc1=(JPanel)this.getContentPane();
		jc1.add(ja2);
		
		jc1.add(jb1);
		
		//面板设为透明，其图片层可见
		jc1.setOpaque(false);
		

		this.setSize(740,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
	difulogin DiFulogin=new difulogin();
	}

}
