package com.server.controller;

import java.io.IOException;
import java.net.*;

public class Server {
	ServerSocket ss;
	public Server(){
		try {
			 ss=new ServerSocket();
			 System.out.println("服务器已经启动");
			 while(true){
				 
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
