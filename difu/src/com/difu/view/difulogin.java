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
		a1=new Font("����",Font.BOLD,120);
		ja1=new JLabel(new ImageIcon("tupian/timg.jpg"));
		//���Բ����ǣ�������Ϊ��
		this.getContentPane().setLayout(null);
		//��ͼƬ��Ϊ�����С��������������
		ja1.setBounds(0,0,740,650);
		this.getLayeredPane().add(ja1,new Integer(Integer.MIN_VALUE));
		
		//�������ContentPane��
		ja2=new JLabel("������");
		ja2.setFont(a1);
		jb1=new JButton("");
		
		
		this.getContentPane().setLayout(new FlowLayout());
		//�������ǿ��ת��������ͣ���Ϊ��͸��
		jc1=(JPanel)this.getContentPane();
		jc1.add(ja2);
		
		jc1.add(jb1);
		
		//�����Ϊ͸������ͼƬ��ɼ�
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