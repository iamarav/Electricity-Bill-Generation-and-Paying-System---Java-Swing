package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class BillViewUnpaidBills {

	JFrame frmViewUnpaidBills;
	private JTextField textField;
	String data_upb;
	JList list;
	JLabel lblName_1 ,lblAcNo,lblAddr,lblCno, lblCityyy ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillViewUnpaidBills window = new BillViewUnpaidBills();
					window.frmViewUnpaidBills.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillViewUnpaidBills() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewUnpaidBills = new JFrame();
		frmViewUnpaidBills.setIconImage(Toolkit.getDefaultToolkit().getImage(BillViewUnpaidBills.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmViewUnpaidBills.setResizable(false);
		frmViewUnpaidBills.setTitle("View Unpaid Bills");
		frmViewUnpaidBills.setBounds(100, 100, 868, 649);
		frmViewUnpaidBills.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewUnpaidBills.getContentPane().setLayout(null);
		
		
		list = new JList();

		list.setBounds(67, 306, 684, 194);
		frmViewUnpaidBills.getContentPane().add(list);
		
		JButton btnSubmit = new JButton("View Unpaid Bills");
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 17));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//START
				String acno2=textField.getText().toString();

				if (acno2.equals("")) {
					JOptionPane.showMessageDialog(frmViewUnpaidBills, "Please enter Account Number");
				}

				else if (acno2.contains(" ")) {
					JOptionPane.showMessageDialog(frmViewUnpaidBills, "Account Number cannot have spaces.");
				}

				else{
					try{
//						data_upb=
						
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager
							.getConnection(  
									"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
					
					String qu3= "select * from billdetails where acno='"+acno2+"'  && paid='0'";
					Statement statement2= connection.createStatement();
//					int row2= statement2.executeUpdate(qu3);
					ResultSet row2= statement2.executeQuery(qu3);
					

					if (row2.next()) {


//						lblCityName.setText(row2.getString("custcity"));
						lblAcNo.setText(row2.getString("acno"));
						lblName_1.setText(row2.getString("custname"));
						lblAddr.setText(row2.getString("custaddr"));
						lblCno.setText(row2.getString("custContact"));
						lblCityyy.setText(row2.getString("custcity"));
						
						
						
						DefaultListModel model = new DefaultListModel();
						
//						String ss=row2.first();
						 String firstEl=row2.getString("unitconsumed");
						 
						 String monthfr=row2.getString("billDate"); 
						 String billAmt2=row2.getString("billAmt"); 
						 String data2= "Consumed units: "+firstEl+" for Month: "+monthfr+" Amount: "+billAmt2;
					        model.addElement(data2); //add each item to the model

						 while (row2.next()) //go through each row that your query returns
						    {
						        String itemCode = row2.getString("unitconsumed"); //get the element in column "item_code"
						//        String data3=
						        String monthfr2=row2.getString("billDate"); 
						        String billAmt=row2.getString("billAmt"); 
								 String data22= "Consumed units: "+itemCode+" for Month: "+monthfr2+" Amount: "+billAmt;
							          
						        model.addElement(data22); //add each item to the model
						    }
						 
						 list.setModel(model);
//						 resultSet.close
						
						JOptionPane.showMessageDialog(frmViewUnpaidBills, " User have Unpaid Bills");
						
					}
					else{
						JOptionPane.showMessageDialog(frmViewUnpaidBills, " No Unpaid Bills");
					
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
		btnSubmit.setBounds(214, 111, 404, 33);
		frmViewUnpaidBills.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(214, 85, 404, 20);
		frmViewUnpaidBills.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterAccontNumber = new JLabel("Enter Account Number");
		lblEnterAccontNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblEnterAccontNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAccontNumber.setBounds(323, 28, 219, 33);
		frmViewUnpaidBills.getContentPane().add(lblEnterAccontNumber);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillViewOldBillOptions viewOldBillOptions = new BillViewOldBillOptions();
				viewOldBillOptions.frmViewPreviousBills.setVisible(true);
				frmViewUnpaidBills.dispose();
			}
		});
		btnGoBack.setBounds(191, 548, 141, 23);
		frmViewUnpaidBills.getContentPane().add(btnGoBack);
		
		JButton btnGoHome = new JButton("Go Home");
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmViewUnpaidBills.dispose();
			}
		});
		btnGoHome.setBounds(488, 548, 141, 23);
		frmViewUnpaidBills.getContentPane().add(btnGoHome);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(67, 171, 200, 50);
		frmViewUnpaidBills.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(67, 207, 200, 33);
		frmViewUnpaidBills.getContentPane().add(lblNewLabel);
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setBounds(67, 232, 200, 33);
		frmViewUnpaidBills.getContentPane().add(lblContactDetails);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(67, 155, 200, 41);
		frmViewUnpaidBills.getContentPane().add(lblAccountNumber);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(67, 262, 200, 33);
		frmViewUnpaidBills.getContentPane().add(lblCity);
		
		lblName_1 = new JLabel(".");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setBounds(540, 171, 211, 50);
		frmViewUnpaidBills.getContentPane().add(lblName_1);
		
		lblAcNo = new JLabel(".");
		lblAcNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcNo.setBounds(580, 150, 171, 50);
		frmViewUnpaidBills.getContentPane().add(lblAcNo);
		
		lblAddr = new JLabel(".");
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddr.setBounds(551, 207, 200, 32);
		frmViewUnpaidBills.getContentPane().add(lblAddr);
		
		lblCno = new JLabel(".");
		lblCno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCno.setBounds(619, 237, 132, 23);
		frmViewUnpaidBills.getContentPane().add(lblCno);
		
		lblCityyy = new JLabel(".");
		lblCityyy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCityyy.setBounds(551, 267, 200, 23);
		frmViewUnpaidBills.getContentPane().add(lblCityyy);
		
		JButton btnPayBill = new JButton("Pay Bill");
		btnPayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillPayBill payBill = new BillPayBill();
				payBill.frmPayBillsHere.setVisible(true);
				frmViewUnpaidBills.dispose();
			}
		});
		btnPayBill.setBounds(299, 511, 200, 23);
		frmViewUnpaidBills.getContentPane().add(btnPayBill);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BillViewUnpaidBills.class.getResource("/com/arav/minorproject/back_6.jpg")));
		label.setBounds(-15, 0, 902, 668);
		frmViewUnpaidBills.getContentPane().add(label);
		

	}
}
