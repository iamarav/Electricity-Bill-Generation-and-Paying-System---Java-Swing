package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class MerchantFeedback {

	JFrame frmFeedback;
	private JTextField textField;
	 JLabel lblLoginName;
	 
	 JTextArea textArea ;
	static String uname=LoginPage.unametopass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MerchantFeedback window = new MerchantFeedback();
					window.frmFeedback.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MerchantFeedback() {
		initialize();
	}

	private void initialize() {
		frmFeedback = new JFrame();
		frmFeedback.setTitle("Feedback");
		frmFeedback.setResizable(false);
		frmFeedback.setIconImage(Toolkit.getDefaultToolkit().getImage(MerchantFeedback.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmFeedback.setBounds(100, 100, 1010, 762);
		frmFeedback.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeedback.getContentPane().setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmFeedback.dispose();
				
			}
		});
		btnCancel.setBounds(726, 11, 200, 50);
		frmFeedback.getContentPane().add(btnCancel);
		
		JLabel lblEnterYourFeedback = new JLabel("Enter Your Feedback...");
		lblEnterYourFeedback.setFont(new Font("Raleway", Font.PLAIN, 24));
		lblEnterYourFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourFeedback.setBounds(222, 110, 582, 56);
		frmFeedback.getContentPane().add(lblEnterYourFeedback);
		
		textField = new JTextField();
		textField.setBounds(363, 217, 306, 50);
		frmFeedback.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmaik = new JLabel("Enter Email");
		lblEmaik.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmaik.setBounds(353, 178, 306, 25);
		frmFeedback.getContentPane().add(lblEmaik);
		
		textArea = new JTextArea();
		textArea.setToolTipText("Enter your feedback here");
		textArea.setBounds(353, 337, 306, 155);
		frmFeedback.getContentPane().add(textArea);
		
		JLabel lblEnterMessage = new JLabel("Enter Message ");
		lblEnterMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterMessage.setBounds(363, 278, 306, 32);
		frmFeedback.getContentPane().add(lblEnterMessage);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String xemail=textField.getText().toString();
				String ymsg=textArea.getText().toString();
				
				if (xemail.equals("")) {
					JOptionPane.showMessageDialog(frmFeedback, "Email cannot be blank");
					
				}
				else{
					
					try{
						
				Class.forName("com.mysql.jdbc.Driver");  
				Connection connection=DriverManager.getConnection(  
				"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
				String qu2= "insert into merchantfeedback(uname, email, msg) values ('"+uname+"','"+xemail+"','"+ymsg+"')";
				Statement statement= connection.createStatement();
				int row= statement.executeUpdate(qu2);
				System.out.println(row+" row updated");
				
				JOptionPane.showMessageDialog(frmFeedback, " Your feedback has been Submitted successfully!! Thanks from developer. ");
				
//				LoginPage page = new LoginPage();
//				page.frameLoginPage.setVisible(true);
//				frmFeedback.dispose();	
			}	
			
		 catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();	
		}	
					
				}
					}
		});
		btnSubmit.setBounds(404, 515, 200, 50);
		frmFeedback.getContentPane().add(btnSubmit);
		
		lblLoginName = new JLabel();
		if (uname==null) {
			
			lblLoginName.setText("Hello User");
		}
		else{
			lblLoginName.setText("Logged in as: "+uname);
			
		}
		lblLoginName.setFont(new Font("Raleway", Font.PLAIN, 13));
		lblLoginName.setBounds(10, 29, 501, 50);
		frmFeedback.getContentPane().add(lblLoginName);
		
		JLabel lblMadeByGaurav = new JLabel("Made by Gaurav Sachdeva");
		lblMadeByGaurav.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeByGaurav.setBounds(342, 616, 329, 32);
		frmFeedback.getContentPane().add(lblMadeByGaurav);
		
		JButton btnAboutDeveloper = new JButton("About Developer");
		btnAboutDeveloper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDeveloper developer = new AboutDeveloper();
				developer.frmAboutDeveloper.setVisible(true);
				frmFeedback.dispose();
				
			}
		});
		btnAboutDeveloper.setBounds(267, 665, 479, 32);
		frmFeedback.getContentPane().add(btnAboutDeveloper);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MerchantFeedback.class.getResource("/com/arav/minorproject/back_4.jpg")));
		label.setBounds(0, -16, 1105, 796);
		frmFeedback.getContentPane().add(label);
	}
}
