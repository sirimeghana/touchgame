/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygames;
import javax.swing.JApplet;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.awt.Button;
import java.awt.event.*;
import java.applet.*;

import java.awt.event.MouseMotionListener;

/**
 *
 * @author Siri Meghana
 */
public class Game extends Applet implements Runnable, MouseListener,ActionListener {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    
    Thread t;
    int delay; int x=0,y=40;
    int j=0;
    int score=0;
    public void init() {
        // TODO st0art asynchronous download of heavy resources
		Button button1 = new Button("start");
                //TextField tf=new TextField();
                //tf.setText("press start to start the game");
		add(button1);
                //add(tf);
                button1.setBounds(20,20,20,20);
		button1.addActionListener(this);
        	addMouseListener(this);
        
    }
    
public void actionPerformed(ActionEvent ea) {
{
	if(t==null)
  	{
         
                 j=1;
                 delay=2000;
                 x=0;
                 y=40;
                 score=0;
  		 t=new Thread(this,"New Thread");//New side Thread created on start of applet.
  		 t.start();
  	}
}
public void start()
 {
        //showStatus("press start to start the game");
 }
  public void stop()
 {
  if(t!=null)
  {
   t=null;//On stop of applet the created thread is destroyed.
  }
 }
  public void run()
 {
  Thread t1=Thread.currentThread();
  while(true)
  {
   repaint();
   try
   {
    Thread.sleep(delay);
   }
   catch(Exception e)
   {   }
  }
 }
  public void paint(Graphics g){
    
      if(j==0)
          showStatus("press start to start the game");
      if(j>0)
    showStatus("game started. score="+score);
      if(j<0)
        showStatus("game ended. Total score="+score+". Press start to again start the game");  
     
    setBackground(Color.cyan);
    g.setColor(Color.PINK);
    g.fillOval(x, y, 40, 40);
    if(j>=0)
    {
    x+=10;
    x=x%350;
    }
    
    
 
 }

    // TODO overwrite start(), stop() and destroy() methods

    public void mouseClicked(MouseEvent e) {  
        int x1=e.getX();
        int y1=e.getY();
        if(x1>x&&x1<x+40&&y1>y&&y1<y+40)
        {
            delay/=2;
            if(score==0)
                score=1;
            if(score>0)
                score=score*2;
        }
        else
        {
            j=-1;
            t=null;
        }
        //System.out.println(speed+" "+e.getYOnScreen()+" "+e.getXOnScreen());
        
    } 
 @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   /* int x1=e.getXOnScreen();
        int y1=e.getYOnScreen();
        //if(x1>x&&x1<x+40&&y1>y&&y1<y+40)
            speed/=2;
        System.out.println(speed+" "+e.getYOnScreen()+" "+e.getXOnScreen());*/
   
           
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
