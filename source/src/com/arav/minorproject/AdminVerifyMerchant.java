package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

public class AdminVerifyMerchant {

	JList list;
	 JFrame frmVerifyMerchants;
	 JTextField textField;

	 String uname2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminVerifyMerchant window = new AdminVerifyMerchant();
					window.frmVerifyMerchants.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminVerifyMerchant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVerifyMerchants = new JFrame();
		frmVerifyMerchants.setResizable(false);
		frmVerifyMerchants.setTitle("Verify Merchants");
		frmVerifyMerchants.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminVerifyMerchant.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmVerifyMerchants.setBounds(100, 100, 1261, 677);
		frmVerifyMerchants.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVerifyMerchants.getContentPane().setLayout(null);
		
		JButton btnVerifyMerchants = new JButton("Verify Merchants");
		btnVerifyMerchants.setForeground(Color.WHITE);
		btnVerifyMerchants.setBackground(Color.WHITE);
		btnVerifyMerchants.setEnabled(false);
		btnVerifyMerchants.setBounds(10, 11, 1235, 50);
		frmVerifyMerchants.getContentPane().add(btnVerifyMerchants);
		
		JLabel lblListOfNon = new JLabel("List of Non Verified Merchants");
		lblListOfNon.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfNon.setBounds(698, 72, 547, 39);
		frmVerifyMerchants.getContentPane().add(lblListOfNon);
		
		list = new JList();
		list.setBounds(708, 165, 537, 473);
		frmVerifyMerchants.getContentPane().add(list);
		
		JLabel lblVerifyMerchants = new JLabel("Verify Merchants");
		lblVerifyMerchants.setBackground(Color.YELLOW);
		lblVerifyMerchants.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerifyMerchants.setBounds(10, 84, 678, 27);
		frmVerifyMerchants.getContentPane().add(lblVerifyMerchants);
		
		textField = new JTextField();
		textField.setBounds(10, 145, 678, 50);
		frmVerifyMerchants.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ss
				uname2=textField.getText().toString();
			
				//	String billAmt3=label_
							//label_6.setText(row2.getString("billDate"));
					String unam=textField.getText().toString();
							
					if (uname2.equals("")) {
						JOptionPane.showMessageDialog(frmVerifyMerchants, "Please enter Account Number");
					}

					else if (uname2.contains(" ")) {
						JOptionPane.showMessageDialog(frmVerifyMerchants, "Account Number cannot have spaces.");
					}

					else{
						
						try{
						Class.forName("com.mysql.jdbc.Driver");  
						Connection connection=DriverManager
								.getConnection(  
										"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
						
//						String billdate=row2.getString("billDate");
				
	//
						//System.out.println(billdate);
//						String qu34= "select * from billdetails where acno='"+acno23+"'";
//						Statement statement24= connection.createStatement();
////						
//						ResultSet row23= statement24.executeQuery(qu34);
//						if (row23.first()) {
//							label_4.setText(row23.getString("custname"));
//							
//						}
//						row23.close();
//						//JUST TO GET NAME
						
//						String qu3= "select * from billdetails where acno='"+acno23+"'  && paid='0'";
						String qu3= "update users set confirmed='1' where uname='"+unam+"' ";
						Statement statement2= connection.createStatement();
//						int row2= statement2.executeUpdate(qu3);
						int row2= statement2.executeUpdate(qu3);

					
						int response = JOptionPane.showConfirmDialog(null, " Verified!!! "
								+ "Do you want to continue?", "Verified",
						        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    if (response == JOptionPane.NO_OPTION) {
						     AdminLanding page = new AdminLanding();
						     page.frmAdminLandingPage.setVisible(true);
						     frmVerifyMerchants.dispose();
						    	
						    } else if (response == JOptionPane.YES_OPTION) {
						    	
						    	frmVerifyMerchants.dispose();
						    	
						    	AdminVerifyMerchant n= new AdminVerifyMerchant();
						    	n.frmVerifyMerchants.setVisible(true);
						     
						    } else if (response == JOptionPane.CLOSED_OPTION) {
						     
						    }
						  
						
						
						
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e2) {
							
							e2.printStackTrace();
						}  
						
				
					}
				//dd
				
			}
		});
		btnVerify.setBounds(243, 242, 200, 50);
		frmVerifyMerchants.getContentPane().add(btnVerify);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLanding adminLanding = new AdminLanding();
				adminLanding.frmAdminLandingPage.setVisible(true);
				frmVerifyMerchants.dispose();
				
			}
		});
		btnGoBack.setBounds(10, 505, 200, 133);
		frmVerifyMerchants.getContentPane().add(btnGoBack);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//START
							
					try{
//						data_upb=
						
				//	String username = textField.getText().toString();
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager
							.getConnection(  
									"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
					
					String qu3= "select * from users where confirmed='0'";
					Statement statement2= connection.createStatement();
//					int row2= statement2.executeUpdate(qu3);
					ResultSet row2= statement2.executeQuery(qu3);
					

					if (row2.next()) {
						
						DefaultListModel model = new DefaultListModel();
						
//						String ss=row2.first();
						 String cno=row2.getString("uname");
						 
					//	 String acnoo=row2.getString("acno"); 
						 String name=row2.getString("name"); 
						 String data2=" Name: "+name+" Username: "+cno;
					        model.addElement(data2); //add each item to the model

						 while (row2.next()) //go through each row that your query returns
						    {
							 String cno2=row2.getString("uname");

							 String name2=row2.getString("name"); 
						        String data22= " Name: "+name2+" Username: "+cno2;
							          
						        model.addElement(data22); //add each item to the model
						    }
						 
						 list.setModel(model);
//						 resultSet.close
						
						JOptionPane.showMessageDialog(frmVerifyMerchants, " You have non verified users");
						
					}
					else{
						JOptionPane.showMessageDialog(frmVerifyMerchants, " No Entries");
					
//						frmAddNewCustomer.dispose();	
					}	
					
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}  
					
				}
				
				//STOP
				
				
			
		});
		btnRefresh.setBounds(708, 113, 537, 39);
		frmVerifyMerchants.getContentPane().add(btnRefresh);
		
		JLabel lblEnterUsernameTo = new JLabel("Enter Username to be verified");
		lblEnterUsernameTo.setForeground(Color.RED);
		lblEnterUsernameTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUsernameTo.setBounds(10, 120, 678, 14);
		frmVerifyMerchants.getContentPane().add(lblEnterUsernameTo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminVerifyMerchant.class.getResource("/com/arav/minorproject/bg_gray.png")));
		label.setBounds(-21, 0, 1336, 689);
		frmVerifyMerchants.getContentPane().add(label);
	}

}
