package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SpinnerListModel;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;


public class BillGenerateNewBill {

	String addr;
	JFrame frameNewBill;
	JLabel lblConsumerName;
	JLabel label_cno;
	JLabel lblCityName;
	JButton btnPayNow ;
	JSpinner sp_unit_price;
	JSpinner sp_unit_consumed;
	JTextArea textArea;
	
	static String unitConsumed;
	static String unitPrice;
	static String billAmount;
	
//	final JLabel lblConsumerName 
	JSpinner spinner, spinner_1;
	private JTextField accontNumber;

	String dateB;
	String mo = new String();
	String yr = new String();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillGenerateNewBill window = new BillGenerateNewBill();
					window.frameNewBill.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillGenerateNewBill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frameNewBill = new JFrame();
		frameNewBill.setIconImage(Toolkit.getDefaultToolkit().getImage(BillGenerateNewBill.class.getResource("/com/arav/minorproject/power_icon.png")));
		frameNewBill.setResizable(false);
		frameNewBill.setTitle("Generate New Bill");
		frameNewBill.setBounds(100, 100, 966, 706);
		frameNewBill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameNewBill.getContentPane().setLayout(null);
		
		
		
		JLabel lblEnterDetailsFor = new JLabel("Enter details for bill");
		lblEnterDetailsFor.setBounds(10, 35, 940, 23);
		lblEnterDetailsFor.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblEnterDetailsFor.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(lblEnterDetailsFor);
		
		JLabel label = new JLabel("_____________________________________________");
		label.setBounds(10, 57, 940, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(label);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter Account Number");
		lblEnterAccountNumber.setBounds(10, 82, 940, 14);
		lblEnterAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(lblEnterAccountNumber);
		

		
		
		accontNumber = new JTextField();
		accontNumber.setBounds(340, 107, 280, 20);
		accontNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(accontNumber);
		accontNumber.setColumns(10);
		

		JLabel lblK = new JLabel("Login Name");
		lblK.setBounds(718, 644, 232, 23);
		lblK.setHorizontalAlignment(SwingConstants.RIGHT);
		lblK.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		frameNewBill.getContentPane().add(lblK);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(10, 196, 160, 14);
		lblCustomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblCustomerName);
		
		lblConsumerName = new JLabel("");
		lblConsumerName.setBounds(340, 182, 280, 28);
		lblConsumerName.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(lblConsumerName);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(91, 221, 79, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblNewLabel);
		
		JLabel lblCity = new JLabel("City/District");
		lblCity.setBounds(69, 308, 94, 14);
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblCity);
		
		sp_unit_consumed = new JSpinner();
		sp_unit_consumed.setBounds(460, 386, 160, 20);
		sp_unit_consumed.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		frameNewBill.getContentPane().add(sp_unit_consumed);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(92, 283, 71, 14);
		lblContact.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblContact);
		
		JLabel label_1 = new JLabel("+91");
		label_1.setBounds(340, 283, 31, 14);
		frameNewBill.getContentPane().add(label_1);
		
		label_cno = new JLabel("");
		label_cno.setBounds(340, 283, 258, 14);
		label_cno.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(label_cno);
		
		lblCityName = new JLabel("");
		lblCityName.setBounds(340, 302, 280, 20);
		lblCityName.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(lblCityName);
		
		JLabel lblUnitsConsumed = new JLabel("Units Consumed");
		lblUnitsConsumed.setBounds(283, 389, 107, 14);
		lblUnitsConsumed.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblUnitsConsumed);
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnitPrice.setBounds(311, 420, 79, 14);
		frameNewBill.getContentPane().add(lblUnitPrice);
		
		sp_unit_price = new JSpinner();
		sp_unit_price.setModel(new SpinnerNumberModel(8, 6, 10, 1));
		sp_unit_price.setBounds(559, 417, 61, 20);
		frameNewBill.getContentPane().add(sp_unit_price);
		
		JLabel lblMinnmax = new JLabel("6-10");
		lblMinnmax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinnmax.setBounds(666, 417, 46, 20);
		frameNewBill.getContentPane().add(lblMinnmax);

		lblMinnmax.setVisible(true);
		
		btnPayNow = new JButton("Pay Now");
		frameNewBill.getContentPane().add(btnPayNow);
		btnPayNow.setVisible(false);
		btnPayNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//btnSubmit.setEnabled(true);	
			}
		});
		btnPayNow.setBounds(421, 543, 127, 23);
		
//		mo=spinner.getValue().toString();
//		yr=spinner_1.getValue().toString();
		//GETTING DATE FRM SPINNER
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frameNewBill.dispose();
			}
		});
		
		
		JButton btnGetDetails = new JButton("Get Details");
		btnGetDetails.setBounds(340, 134, 280, 23);
		btnGetDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//START
	
				String accountNumber=accontNumber.getText().toString();
				
				try{
					
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager.getConnection(  
							"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
					
					String qu3= "select * from customerdetails where acno='"+accountNumber+"'";
					Statement statement2= connection.createStatement();
//					int row2= statement2.executeUpdate(qu3);
					ResultSet row2= statement2.executeQuery(qu3);
					
					if (row2.first()) {
						JOptionPane.showMessageDialog(frameNewBill, " Details found for: "+accountNumber);
						//while(row2.next()){
							
							lblConsumerName.setText(row2.getString("custname"));
							label_cno.setText(row2.getString("custContact"));
							addr=row2.getString("custaddr");
							textArea.setText(row2.getString("custaddr"));
							lblCityName.setText(row2.getString("custcity"));
						    //.setText(rs.getString("e_id"));
						 //   }
						
					}
					else{
						JOptionPane.showMessageDialog(frameNewBill, "No such Account Number exist! Please check again");
						
//						String qu2= "insert into users(uname, upass, name, confirmed) values ('"+yuname+"','"+zpass2+"','"+xname+"','"+cnfrmd+"')";
//						Statement statement= connection.createStatement();
//						int row= statement.executeUpdate(qu2);
//					//	System.out.println(row+" row updated");
//						JOptionPane.showMessageDialog(frameSignUp, row+" user registered successfully!");
//						
//						LoginPage page = new LoginPage();
//						page.frameLoginPage.setVisible(true);
//						frameSignUp.dispose();	
					}	
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}  

			}
		
				
				//
				//				select * from billdata where acno ='"accountNumber"'
				//ADD HERE
			
		});
		frameNewBill.getContentPane().add(btnGetDetails);
		
		
		
		
		btnGoBack.setBounds(445, 592, 89, 23);
		frameNewBill.getContentPane().add(btnGoBack);
		

		if(LoginPage.unametopass!=null){
		lblK.setText("Logged in as: "+LoginPage.unametopass);
		}
		else{
			lblK.setText("Logged in as: Anonymous");
	
		}
		
		unitConsumed=sp_unit_consumed.getValue().toString();
		unitPrice=sp_unit_price.getValue().toString();
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPayNow.setVisible(true);

//				lblConsumerName.setText(row2.getString("custname"));
//				label_cno.setText(row2.getString("custContact"));
//				lblFlatb.setText(row2.getString("custaddr"));
//				lblCityName.setText(row2.getString("custcity"));
				
				
				//START
				String acno2=accontNumber.getText().toString();
				String custname=lblConsumerName.getText().toString();
				String address=addr;
				String contactno=label_cno.getText().toString();
				String cityName=lblCityName.getText().toString();
				String unitC=sp_unit_consumed.getValue().toString();
				String unitP=sp_unit_price.getValue().toString();
				String paidStatus="0";
				
				String mo1=spinner.getValue().toString();
				String yr1=spinner_1.getValue().toString();
				String dateB1= mo1+" "+yr1 ;
				
				String t2 = String.valueOf(Integer.valueOf(unitC) * Integer.valueOf(unitP));
			//	System.out.println(t2);
		//	int billAmount=unitC * unitP;
//				
			//	System.out.println(billAmount);
				//String city=(String) spinnerCity.getValue();
//				if(custname.equals("")) {
//					JOptionPane.showMessageDialog(frameNewBill, "Please enter Customer Name");
//				}
				if (acno2.equals("")) {
					JOptionPane.showMessageDialog(frameNewBill, "Please enter Account Number");
				}

				else if (acno2.contains(" ")) {
					JOptionPane.showMessageDialog(frameNewBill, "Account Number cannot have spaces.");
				}
		
//				
				else{
					try{

					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager
							.getConnection(  
									"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
					
					String qu3= "select * from customerdetails where acno='"+acno2+"'";
					Statement statement2= connection.createStatement();
//					int row2= statement2.executeUpdate(qu3);
					ResultSet row2= statement2.executeQuery(qu3);
					

					if (row2.first()) {
//						JOptionPane.showMessageDialog(frameNewBill, " Account Number already exists!!");
						String qu2= "insert into billdetails(acno, custname, custaddr, custcity, custcontact, unitconsumed, unitprice,paid, billDate, billAmt) values ('"+acno2+"','"+custname+"','"+address+"','"+cityName+"','"+contactno+"','"+unitC+"','"+unitP+"','"+paidStatus+"','"+dateB1+"','"+t2+"')";
						Statement statement= connection.createStatement();
						int row= statement.executeUpdate(qu2);
					//	System.out.println(row+" row updated");

//						JOptionPane.showMessageDialog(frmAddNewCustomer, row+" user added successfully!");
						
						int response = JOptionPane.showConfirmDialog(null, row+" Bill Uploaded successfully!!! "
								+ "Do you want to continue?", "Bill Generated",
						        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    if (response == JOptionPane.NO_OPTION) {
						     LandingPage page = new LandingPage();
						     page.frameLandingPage.setVisible(true);
						     frameNewBill.dispose();
						    	
						    } else if (response == JOptionPane.YES_OPTION) {
						    	
						    	frameNewBill.dispose();
						    	
						    	BillGenerateNewBill n= new BillGenerateNewBill();
						    	n.frameNewBill.setVisible(true);
						     
						    } else if (response == JOptionPane.CLOSED_OPTION) {
						     
						    }
						  
						
						
					}
					else{
					
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
		btnSubmit.setBounds(340, 509, 280, 23);
		frameNewBill.getContentPane().add(btnSubmit);
		
		JLabel lblSelectBillCycle = new JLabel("Select Bill Cycle Month");
		lblSelectBillCycle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectBillCycle.setBounds(151, 436, 253, 50);
		frameNewBill.getContentPane().add(lblSelectBillCycle);
		

		
		spinner = new JSpinner();
		spinner.setToolTipText("Select Month");
		spinner.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		spinner.setModel(new SpinnerListModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		spinner.setBounds(459, 447, 89, 23);
		frameNewBill.getContentPane().add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setToolTipText("Select Year");
		spinner_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		spinner_1.setModel(new SpinnerNumberModel(2017, 2013, 2023, 1));
		spinner_1.setBounds(553, 447, 67, 23);
		frameNewBill.getContentPane().add(spinner_1);
		
		textArea = new JTextArea();
		textArea.setBounds(340, 216, 610, 50);
		frameNewBill.getContentPane().add(textArea);
		
		JLabel label_3 = new JLabel("_______________________________________________________");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 333, 940, 14);
		frameNewBill.getContentPane().add(label_3);
		
		JLabel lblEnterUnitsUnit = new JLabel("Enter Units, Unit Price and Bill Cycle");
		lblEnterUnitsUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUnitsUnit.setBounds(10, 358, 940, 14);
		frameNewBill.getContentPane().add(lblEnterUnitsUnit);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(BillGenerateNewBill.class.getResource("/com/arav/minorproject/bg_gray.png")));
		label_2.setBounds(-18, 0, 1031, 697);
		frameNewBill.getContentPane().add(label_2);
		
		
	}
}
