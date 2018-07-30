package com.arav.minorproject;

import java.awt.EventQueue;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class ViewAllCustomer {

	JFrame frmViewAllCustomers;

	JList list;
	private JButton btnGet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllCustomer window = new ViewAllCustomer();
					window.frmViewAllCustomers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewAllCustomer() {
		initialize();
	}


	private void initialize() {
		frmViewAllCustomers = new JFrame();
		frmViewAllCustomers.setResizable(false);
		frmViewAllCustomers.setTitle("View All Customers");
		frmViewAllCustomers.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllCustomer.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmViewAllCustomers.setBounds(100, 100, 874, 560);
		frmViewAllCustomers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewAllCustomers.getContentPane().setLayout(null);
		
		JLabel lblHereIsThe = new JLabel("Here is the list of All Customers");
		lblHereIsThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereIsThe.setBounds(10, 11, 848, 45);
		frmViewAllCustomers.getContentPane().add(lblHereIsThe);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage landingPage = new LandingPage();
				landingPage.frameLandingPage.setVisible(true);
				frmViewAllCustomers.dispose();
			}
		});
		btnGoBack.setBounds(10, 6, 200, 64);
		frmViewAllCustomers.getContentPane().add(btnGoBack);
		
		list = new JList();
		list.setBounds(10, 81, 848, 440);
		frmViewAllCustomers.getContentPane().add(list);
		
		btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try{
					
				
				Class.forName("com.mysql.jdbc.Driver");  
				Connection connection=DriverManager
						.getConnection(
								"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
				
//				String qu39= "select * from billdetails where acno='"+acno2+"'  && paid='1'";
//				Statement statement29= connection.createStatement();
////				int row2= statement2.executeUpdate(qu3);
//				ResultSet row22= statement29.executeQuery(qu39);
//				

				String qu32= "select * from customerdetails";
				Statement statement22= connection.createStatement();
//				int row22= statement2.executeUpdate(qu3);
				ResultSet row223= statement22.executeQuery(qu32);
				

				if (row223.next()) {


//					lblCityName.setText(row22.getString("custcity"));
//					lblAcNo2.setText(row223.getString("acno"));
//					lblName_12.setText(row223.getString("custname"));
//					lblAddr2.setText(row223.getString("custaddr"));
//					lblCno2.setText(row223.getString("custContact"));
//					lblCityyy2.setText(row223.getString("custcity"));
					
					
					
					DefaultListModel model = new DefaultListModel();
					
//					String ss=row2.first();
					 String acno=row223.getString("acno");
					 
					 String namee=row223.getString("custname"); 
					 String cnoo=row223.getString("custContact"); 
					 String data2= "A/c No: "+acno+"| Name: "+namee+" |Contact Number: "+cnoo;
				        model.addElement(data2); //add each item to the model

					 while (row223.next()) //go through each row that your query returns
					    {
					        String acno2 = row223.getString("acno"); //get the element in column "item_code"
					//        String data3=x
					        String cno2=row223.getString("custContact"); 
					        String namee2=row223.getString("custname"); 
					        String data22= "A/c No: "+acno2+"| Name: "+namee2+" |Contact Number: "+cno2;
						          
					        model.addElement(data22); //add each item to the model
					    }
					 
					 list.setModel(model);
//					 resultSet.close
					
					
			}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}  
					
				}
				
				
				
			
		});
		btnGet.setBounds(334, 47, 200, 23);
		frmViewAllCustomers.getContentPane().add(btnGet);
	}
}
