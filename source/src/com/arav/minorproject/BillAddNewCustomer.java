package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class BillAddNewCustomer {

	protected static final JOptionPane spinnerCity = null;
	JFrame frmAddNewCustomer;
	private JTextField tFCustName;
	private JTextField tFAcNo;
	private JTextField tFContactNo;
	JTextArea tfAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillAddNewCustomer window = new BillAddNewCustomer();
					window.frmAddNewCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillAddNewCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddNewCustomer = new JFrame();
		frmAddNewCustomer.setTitle("Add New Customer");
		frmAddNewCustomer.setBounds(100, 100, 910, 631);
		frmAddNewCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddNewCustomer.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 11, 874, 28);
		if (LoginPage.unametopass!=null) {
			lblWelcome.setText("Welcome "+LoginPage.unametopass);
		}
		else{
			lblWelcome.setText("Welcome User");
		}
		frmAddNewCustomer.getContentPane().add(lblWelcome);
		
		JLabel label = new JLabel("____________________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 128, 874, 14);
		frmAddNewCustomer.getContentPane().add(label);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(76, 153, 141, 24);
		frmAddNewCustomer.getContentPane().add(lblCustomerName);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(76, 206, 102, 14);
		frmAddNewCustomer.getContentPane().add(lblAccountNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(76, 239, 102, 14);
		frmAddNewCustomer.getContentPane().add(lblAddress);
		
		JLabel lblCitydistrict = new JLabel("City/District");
		lblCitydistrict.setBounds(76, 327, 116, 14);
		frmAddNewCustomer.getContentPane().add(lblCitydistrict);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(76, 369, 102, 14);
		frmAddNewCustomer.getContentPane().add(lblContactNumber);
		
		tFCustName = new JTextField();
		tFCustName.setBounds(237, 153, 510, 33);
		frmAddNewCustomer.getContentPane().add(tFCustName);
		tFCustName.setColumns(10);
		
		tFAcNo = new JTextField();
		tFAcNo.setBounds(237, 203, 510, 20);
		frmAddNewCustomer.getContentPane().add(tFAcNo);
		tFAcNo.setColumns(10);
		
		tFContactNo = new JTextField();
		tFContactNo.setBounds(237, 366, 229, 20);
		frmAddNewCustomer.getContentPane().add(tFContactNo);
		tFContactNo.setColumns(10);
		
		
		JSpinner spinnerCity = new JSpinner();
		spinnerCity.setModel(new SpinnerListModel(new String[] {"Panipat", "Rohtak", "Gurugram", "Samalkha", "Other"}));
		spinnerCity.setBounds(237, 324, 229, 20);
		frmAddNewCustomer.getContentPane().add(spinnerCity);
		
		final String s2=(String) spinnerCity.getValue();
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//START
				String acno=tFAcNo.getText().toString();
				String custname=tFCustName.getText().toString();
				String address=tfAddress.getText().toString();
				String contactno=tFContactNo.getText().toString();
				String city=s2;
				//String city=(String) spinnerCity.getValue();
				if(custname.equals("")) {
					JOptionPane.showMessageDialog(frmAddNewCustomer, "Please enter Customer Name");
				}
				else if (acno.equals("")) {
					JOptionPane.showMessageDialog(frmAddNewCustomer, "Please enter Account Number");
				}

				else if (acno.contains(" ")) {
					JOptionPane.showMessageDialog(frmAddNewCustomer, "Account Number cannot have spaces.");
				}
				
				else if (address.equals("")) {
					JOptionPane.showMessageDialog(frmAddNewCustomer, "Please enter address");
				}
				
				else if (contactno.equals("")) {
					JOptionPane.showMessageDialog(frmAddNewCustomer, "Contact Number cannot be blank!");
				}

				else if (contactno.length()!=10) {
					JOptionPane.showMessageDialog(frmAddNewCustomer, "Invalid Contact Number");
				}
			
				else if (contactno.contains("abc")) {
					JOptionPane.showMessageDialog(frmAddNewCustomer, "Invalid Number");
				}
				
				else{
					try{

					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager
							.getConnection(  
									"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
					
					String qu3= "select * from customerdetails where acno='"+acno+"'";
					Statement statement2= connection.createStatement();
//					int row2= statement2.executeUpdate(qu3);
					ResultSet row2= statement2.executeQuery(qu3);

					if (row2.first()) {
						JOptionPane.showMessageDialog(frmAddNewCustomer, " Account Number already exists!!");
					}
					else{
						String qu2= "insert into customerdetails(acno, custname, custaddr, custcity, custcontact) values ('"+acno+"','"+custname+"','"+address+"','"+city+"','"+contactno+"')";
						Statement statement= connection.createStatement();
						int row= statement.executeUpdate(qu2);
					//	System.out.println(row+" row updated");

//						JOptionPane.showMessageDialog(frmAddNewCustomer, row+" user added successfully!");
						
						int response = JOptionPane.showConfirmDialog(null, row+" user added successfully! "
								+ "Do you want to continue?", "User Added Successfully",
						        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    if (response == JOptionPane.NO_OPTION) {
						     LandingPage page = new LandingPage();
						     page.frameLandingPage.setVisible(true);
						     frmAddNewCustomer.dispose();
						    	
						    } else if (response == JOptionPane.YES_OPTION) {
						    	
						    	tFAcNo.setText("");
						    	tfAddress.setText("");
						    	tFContactNo.setText("");
						    	tFCustName.setText("");
						    	
						    	
						     
						    } else if (response == JOptionPane.CLOSED_OPTION) {
						     
						    }
						  
						
						
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
		btnSubmit.setBounds(332, 408, 278, 23);
		frmAddNewCustomer.getContentPane().add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmAddNewCustomer.dispose();
			}
		});
		btnCancel.setBounds(400, 442, 151, 23);
		frmAddNewCustomer.getContentPane().add(btnCancel);
		
		tfAddress = new JTextArea();
		tfAddress.setBounds(237, 234, 510, 73);
		frmAddNewCustomer.getContentPane().add(tfAddress);
		
		JLabel label_1 = new JLabel("____________________________________________");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 36, 874, 14);
		frmAddNewCustomer.getContentPane().add(label_1);
		
		JLabel lblAddANew = new JLabel("Add a New Customer");
		lblAddANew.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblAddANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddANew.setBounds(10, 70, 864, 32);
		frmAddNewCustomer.getContentPane().add(lblAddANew);
		
		JLabel lblPleaseFillThe = new JLabel("Please fill the following form with correct information");
		lblPleaseFillThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseFillThe.setBounds(10, 113, 874, 14);
		frmAddNewCustomer.getContentPane().add(lblPleaseFillThe);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(BillAddNewCustomer.class.getResource("/com/arav/minorproject/back_6.jpg")));
		label_2.setBounds(0, 0, 911, 612);
		frmAddNewCustomer.getContentPane().add(label_2);

	}

}
