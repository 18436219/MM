package com.oracle.Game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class SnakeGame extends KeyAdapter implements Runnable {   
    private boolean start=false;
    private JFrame frame;
    private Thread timerThread;  
    int[] SnakeXs=new int[900];
    int[] SnakeYs=new int[900];
    int len=6;   
    int diraction=4;
    int a;
    int b;
    int score;
    int count;
    boolean IsGameOver = false;
    int time;
    boolean BiteWall ;
    public SnakeGame(){  
        for(int i=0;i<len;i++){
            SnakeXs[i]=(len-1-i)*20;SnakeYs[i]=0;
        }
        a=100;
        b=100;
       
        score=0;
       
        time=400;
        
        frame = new JFrame();
        frame.getContentPane().add(new Screen());
        frame.addKeyListener(this);   
       
        frame.setSize(600+5*2+200, 600+25+5*2);
        
        frame.setVisible(true);
        frame.repaint();
    } public void keyPressed(KeyEvent evt){
        switch(evt.getKeyCode()){    
        case KeyEvent.VK_ENTER:
            if(!start){
                timerThread = new Thread(this);
                timerThread.start();
                start = true;
            }
            break;
        case KeyEvent.VK_ESCAPE:
            start = false;
            System.exit(1);
            break;
        case KeyEvent.VK_LEFT:
          
            if(diraction==1||diraction==2)
                {
                diraction=3;
                }
            
            break;
        case KeyEvent.VK_RIGHT:
            
            if(diraction==1||diraction==2)
                {
                diraction=4;
                }
           
            break;
        case KeyEvent.VK_DOWN:
            
            if(diraction==3||diraction==4)
               {
                diraction=2;
               }
            
            break;
        case KeyEvent.VK_UP:
           
            if(diraction==3||diraction==4)
               {
                diraction=1;
               }
            
            break;    
        case KeyEvent.VK_R:
            BiteWall=!BiteWall;
            break;
    }

    frame.repaint();
}  public void run(){
    while(true){
        try{ 
            
            Thread.sleep(time);
        }catch (InterruptedException e){  
            e.printStackTrace();
        }
        
        if(start==false)
            return;
     
        frame.repaint();
    }
}

class Screen extends JComponent{   
    private static final long serialVersionUID = 1155019838145337862L;

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.orange);
        g2d.fillRect(0, 0, 800, 600);
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 600, 600);
        
     
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
        
                g2d.setColor(Color.white);
                g2d.drawRect(i*20,j*20 , 20,20);
                
              }
            }
          
        
        for(int i=0;i<len;i++){
             g2d.setColor(Color.green);
            g2d.fillRect(SnakeXs[i]+1,SnakeYs[i]+1,20-2,20-2);
        }
        
        
        
         g2d.setColor(Color.green);
         g2d.fillRect(a+1,b+1, 20-2, 20-2);
        if(SnakeXs[0]==a&&SnakeYs[0]==b){
            count++;
            len++;    
            score+=10;    
           




       a=(int)(Math.random()*30)*20; b=(int)(Math.random()*30)*20;
             g2d.setColor(Color.green);
            g2d.fillRect(a+1,b+1, 20-2, 20-2);
            
        } 
       
        if(BiteWall==true){
            if(SnakeXs[0]<0){
                SnakeXs[0] = 580;
            }else if(SnakeXs[0]>580){
                SnakeXs[0] = 0;
            }
            if(SnakeYs[0]<0){
                SnakeYs[0] = 580;
            }else if(SnakeYs[0]>580){
                SnakeYs[0] = 0;
            }
        }else{
            
            if(SnakeXs[0]<0 || SnakeXs[0]>580
                    ||SnakeYs[0]<0 || SnakeYs[0]>580){
                IsGameOver = true;
            }
        }
        for(int i=1;i<len;i++){
            if(SnakeXs[0]==SnakeXs[i]&&SnakeYs[0]==SnakeYs[i]){
                IsGameOver=true;
                break;
            }
        }
        if(IsGameOver){
            g2d.setFont(new Font("宋体",Font.BOLD,80));
            g2d.setColor(Color.orange);
            g2d.drawString("Game Over!!", 80, 250);
            start=false;
        }
        
            
            g2d.setFont(new Font("宋体",Font.BOLD,20));
            g2d.setColor(Color.red);
            g2d.drawString("分数："+score, 650, 200);
            g2d.drawString("吃了："+count+"个", 650, 300);
            g2d.setColor(Color.blue);
            g2d.drawString("巨无霸恐怖贪吃蛇", 620, 100);
            
            switch(score/100){
            case 1:
                time=300;
                break;
            case 2:
                time=200;
                break;
            case 3:
                time=100;
                break;
            case 4:
                time=50;
                break;
            }


for(int i=len-1;i>0;i--){
            SnakeXs[i]=SnakeXs[i-1];SnakeYs[i]=SnakeYs[i-1];
        }
        
          
        switch(diraction){
        case 1:
            SnakeYs[0]=SnakeYs[0]-20;
            break;
        case 2:
            SnakeYs[0]=SnakeYs[0]+20;
            break;
        case 3:
            SnakeXs[0]=SnakeXs[0]-20;
            break;
        case 4:
            SnakeXs[0]=SnakeXs[0]+20;
            break;
        
        }
        
       
    }
}


public static void main(String[] args){
   
    new SnakeGame();
}
}




   
