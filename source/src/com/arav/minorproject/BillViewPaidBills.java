package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class BillViewPaidBills {

	JFrame frmViewPaidBils;
	private JTextField textField;

	JList list ;
	JLabel lblName_12 ,lblAcNo2,lblAddr2,lblCno2, lblCityyy2 ;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillViewPaidBills window = new BillViewPaidBills();
					window.frmViewPaidBils.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BillViewPaidBills() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewPaidBils = new JFrame();
		frmViewPaidBils.setResizable(false);
		frmViewPaidBils.setIconImage(Toolkit.getDefaultToolkit().getImage(BillViewPaidBills.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmViewPaidBils.setTitle("View Paid Bills");
		frmViewPaidBils.setBounds(100, 100, 885, 664);
		frmViewPaidBils.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewPaidBils.getContentPane().setLayout(null);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter Account Number");
		lblEnterAccountNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblEnterAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAccountNumber.setBounds(317, 31, 233, 41);
		frmViewPaidBils.getContentPane().add(lblEnterAccountNumber);
		
		textField = new JTextField();
		textField.setBounds(163, 83, 489, 33);
		frmViewPaidBils.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		list = new JList();
		list.setToolTipText("\r\n");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(69, 358, 722, 167);
		frmViewPaidBils.getContentPane().add(list);
		
		
		JButton btnSubmit = new JButton("View Paid Bills");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//START
				String acno2=textField.getText().toString();

				if (acno2.equals("")) {
					JOptionPane.showMessageDialog(frmViewPaidBils, "Please enter Account Number");
				}

				else if (acno2.contains(" ")) {
					JOptionPane.showMessageDialog(frmViewPaidBils, "Account Number cannot have spaces.");
				}

				else{
					
				
					try{
						
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager
							.getConnection(
									"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
					
					String qu39= "select * from billdetails where acno='"+acno2+"'  && paid='1'";
					Statement statement29= connection.createStatement();
//					int row2= statement2.executeUpdate(qu3);
					ResultSet row22= statement29.executeQuery(qu39);
					

					if (row22.first()) {
						
						String data=row22.getString("acno");
					//	list.setda
						JOptionPane.showMessageDialog(frmViewPaidBils, " User have Paid Bill Entries");
						
						Class.forName("com.mysql.jdbc.Driver");  
						Connection connection2=DriverManager
								.getConnection(  
						"jdbc:mysql://localhost:3309/swing_electricity_bill","root","arav");  
						
						String qu32= "select * from billdetails where acno='"+acno2+"'  && paid='1'";
						Statement statement22= connection2.createStatement();
//						int row22= statement2.executeUpdate(qu3);
						ResultSet row223= statement22.executeQuery(qu32);
						

						if (row223.next()) {


//							lblCityName.setText(row22.getString("custcity"));
							lblAcNo2.setText(row223.getString("acno"));
							lblName_12.setText(row223.getString("custname"));
							lblAddr2.setText(row223.getString("custaddr"));
							lblCno2.setText(row223.getString("custContact"));
							lblCityyy2.setText(row223.getString("custcity"));
							
							
							
							DefaultListModel model = new DefaultListModel();
							
//							String ss=row2.first();
							 String firstEl=row22.getString("unitconsumed");
							 
							 String monthfr=row22.getString("billDate"); 
							 String billAmt2=row22.getString("billAmt"); 
							 String data2= "Consumed units: "+firstEl+" for Month: "+monthfr+" Amount: "+billAmt2;
						        model.addElement(data2); //add each item to the model

							 while (row22.next()) //go through each row that your query returns
							    {
							        String itemCode = row22.getString("unitconsumed"); //get the element in column "item_code"
							//        String data3=
							        String monthfr2=row22.getString("billDate"); 
							        String billAmt=row22.getString("billAmt"); 
									 String data22= "Consumed units: "+itemCode+" for Month: "+monthfr2+" Amount: "+billAmt;
								          
							        model.addElement(data22); //add each item to the model
							    }
							 
							 list.setModel(model);
//							 resultSet.close
							
							
					}
					
					
					}else{
						//JOptionPane.showMessageDialog(frmViewPaidBils, " User have some Pending Bills");
						JOptionPane.showMessageDialog(frmViewPaidBils, " User have Unpaid Bills");
						
						
						
//						frmAddNewCustomer.dispose();	
					}	
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}  
					
				}
				
				//STOP

				
				
				
				
			}
		});
		btnSubmit.setBounds(163, 127, 489, 41);
		frmViewPaidBils.getContentPane().add(btnSubmit);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillViewOldBillOptions viewOldBillOptions = new BillViewOldBillOptions();
				viewOldBillOptions.frmViewPreviousBills.setVisible(true);
				frmViewPaidBils.dispose();

			}
		});
		btnGoBack.setBounds(226, 536, 147, 23);
		frmViewPaidBils.getContentPane().add(btnGoBack);
		
		JButton btnGoHome = new JButton("Go Home");
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmViewPaidBils.dispose();
			}
		});
		btnGoHome.setBounds(482, 536, 147, 23);
		frmViewPaidBils.getContentPane().add(btnGoHome);
		
		
		//START

		JLabel lblName2 = new JLabel("Name");
		lblName2.setBounds(104, 206, 200, 50);
		frmViewPaidBils.getContentPane().add(lblName2);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(104, 248, 200, 33);
		frmViewPaidBils.getContentPane().add(lblNewLabel);
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setBounds(104, 282, 200, 33);
		frmViewPaidBils.getContentPane().add(lblContactDetails);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(104, 179, 200, 41);
		frmViewPaidBils.getContentPane().add(lblAccountNumber);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(104, 314, 200, 33);
		frmViewPaidBils.getContentPane().add(lblCity);
		
		lblName_12 = new JLabel(".");
		lblName_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_12.setBounds(467, 206, 211, 50);
		frmViewPaidBils.getContentPane().add(lblName_12);
		
		lblAcNo2 = new JLabel(".");
		lblAcNo2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcNo2.setBounds(507, 174, 171, 50);
		frmViewPaidBils.getContentPane().add(lblAcNo2);
		
		lblAddr2 = new JLabel(".");
		lblAddr2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddr2.setBounds(477, 248, 200, 32);
		frmViewPaidBils.getContentPane().add(lblAddr2);
		
		lblCno2 = new JLabel(".");
		lblCno2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCno2.setBounds(548, 287, 132, 23);
		frmViewPaidBils.getContentPane().add(lblCno2);
		
		lblCityyy2 = new JLabel(".");
		lblCityyy2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCityyy2.setBounds(480, 319, 200, 23);
		frmViewPaidBils.getContentPane().add(lblCityyy2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BillViewPaidBills.class.getResource("/com/arav/minorproject/back_6.jpg")));
		label.setBounds(-15, 0, 934, 705);
		frmViewPaidBils.getContentPane().add(label);
		


	}
}
