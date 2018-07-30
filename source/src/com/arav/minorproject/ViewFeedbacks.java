package com.arav.minorproject;

import java.awt.EventQueue;
import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ViewFeedbacks {

	JFrame frmViewFeedbackss;

	JList list;
	private JButton btnGet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFeedbacks window = new ViewFeedbacks();
					window.frmViewFeedbackss.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewFeedbacks() {
		initialize();
	}


	private void initialize() {
		frmViewFeedbackss = new JFrame();
		frmViewFeedbackss.setResizable(false);
		frmViewFeedbackss.setTitle("View All Customers");
		frmViewFeedbackss.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewFeedbacks.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmViewFeedbackss.setBounds(100, 100, 874, 560);
		frmViewFeedbackss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewFeedbackss.getContentPane().setLayout(null);
		
		JLabel lblHereIsThe = new JLabel("Here are the feedbacks from merchants");
		lblHereIsThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereIsThe.setBounds(10, 11, 848, 45);
		frmViewFeedbackss.getContentPane().add(lblHereIsThe);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLanding landingPage = new AdminLanding();
				landingPage.frmAdminLandingPage
				.setVisible(true);
				frmViewFeedbackss.dispose();
			}
		});
		btnGoBack.setBounds(10, 6, 200, 64);
		frmViewFeedbackss.getContentPane().add(btnGoBack);
		
		list = new JList();
		list.setBounds(10, 81, 848, 440);
		frmViewFeedbackss.getContentPane().add(list);
		
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

				String qu32= "select * from merchantfeedback";
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
					 String unamee=row223.getString("uname");
					 
					 String emaill=row223.getString("email"); 
					 String msgg=row223.getString("msg"); 
					 String data2= "Username: "+unamee+" | Email: "+emaill+" | Message: "+msgg;
				        model.addElement(data2); //add each item to the model

					 while (row223.next()) //go through each row that your query returns
					    {
					    
						 String unamee2=row223.getString("uname");
						 
						 String emaill2=row223.getString("email"); 
						 String msgg2=row223.getString("msg"); 
							 String data22= "Username: "+unamee2+" | Email: "+emaill2+" | Message: "+msgg2;
						          
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
		frmViewFeedbackss.getContentPane().add(btnGet);
	}
}
