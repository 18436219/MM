package com.difu.view;

import javax.swing.*;

public class DiFu extends JFrame{
    
	JLabel ja1;
	JButton jb1;
	
	public DiFu(){
		
		ja1=new JLabel(new ImageIcon("tupian/timg.jpg"));
		this.add(ja1);
		ja1.setLayout(null);
		
		
		this.setSize(1296,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		DiFu difu=new DiFu();
	}

}
