package com.arav.minorproject;

import java.awt.*;
import javax.swing.*;
public class Splash  extends JFrame{
 private JLabel imglabel;
 private ImageIcon img;
 private static JProgressBar pbar;
 Thread t=null;
 public Splash()
 {
	 //sh
	 setSize(600,400);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setLocationRelativeTo(null);
  setUndecorated(true);
  img=new ImageIcon(getClass().getResource("main_bg.jpg"));
  imglabel =new JLabel(img);
  add(imglabel);
  setLayout(null);
  pbar=new JProgressBar();
 
  pbar.setMinimum(0);
  pbar.setMaximum(100);
  pbar.setStringPainted(true);
  pbar.setForeground(Color.blue);
  //imglabel.setBounds(0, 0, 404, 310);
  imglabel.setBounds(0, 0, 600, 400);
  add(pbar);
  pbar.setBounds(0, 380, 600, 400);
  Thread t=new Thread()
  {
  
  public void run()
  {
   int i=0;
   while(i<=100)
   {
    pbar.setValue(i);
    try{
     sleep(90);
     }
    catch(InterruptedException e)
    {
     
    }
    i++;
   }
  }
  };
  t.start();
 }
 }



