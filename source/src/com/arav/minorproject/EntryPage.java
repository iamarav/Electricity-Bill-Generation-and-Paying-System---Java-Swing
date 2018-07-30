package com.arav.minorproject;

public class EntryPage {
	 public static void main(String[]args)
	 {
	  Splash s=new Splash();
	  s.setVisible(true);
	  Thread t=Thread.currentThread();
	 
	  try{
	   t.sleep(9000);
	  }
	  catch(InterruptedException e)
	  {
	   e.printStackTrace();
	  }
	  s.dispose();
	  StartPage page = new StartPage();
	  page.frmWelcome.setVisible(true);
	  //page.frmWelcome
//	  Welcome w=new Welcome();
	 }

	}


