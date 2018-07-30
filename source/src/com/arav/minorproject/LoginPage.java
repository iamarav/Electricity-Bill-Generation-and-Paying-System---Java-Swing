package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class LoginPage {

	static String unametopass;
	
	JFrame frameLoginPage;
	private JPasswordField passwordField;
	private JTextField textFieldUName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frameLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginPage() {
		initialize();
	}

	private void initialize() {
		frameLoginPage = new JFrame();
		frameLoginPage.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/com/arav/minorproject/power_icon.png")));
		frameLoginPage.setResizable(false);
		frameLoginPage.getContentPane().setBackground(Color.WHITE);
		frameLoginPage.setBackground(Color.WHITE);
		frameLoginPage.setTitle("Log In to continue");
		frameLoginPage.setBounds(100, 100, 924, 634);
		frameLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLoginPage.getContentPane().setLayout(null);

		
		JLabel lblLogInTo = new JLabel("Log In to continue");
		lblLogInTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInTo.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblLogInTo.setBounds(10, 69, 847, 67);
		frameLoginPage.getContentPane().add(lblLogInTo);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Raleway", Font.PLAIN, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(10, 184, 847, 23);
		frameLoginPage.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Raleway", Font.PLAIN, 15));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 252, 847, 39);
		frameLoginPage.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Password ");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(148, 302, 565, 23);
		frameLoginPage.getContentPane().add(passwordField);
		
		textFieldUName = new JTextField();
		textFieldUName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUName.setToolTipText("Enter Username");
		textFieldUName.setBounds(148, 218, 565, 23);
		frameLoginPage.getContentPane().add(textFieldUName);
		textFieldUName.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Raleway", Font.PLAIN, 13));
		btnLogIn.setBackground(new Color(100, 149, 237));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String username=textFieldUName.getText().toString();
				String password=new String(passwordField.getPassword());		

				unametopass=username;

				
				if (username.equals("")) {
					JOptionPane.showMessageDialog(frameLoginPage, "Username cannot be blank ");
					
				}
				else if (username.contains(" ")) {
					JOptionPane.showMessageDialog(frameLoginPage, "Username cannot have blank spaces! ");
					
				}
				else if (password.equals("")) {
					JOptionPane.showMessageDialog(frameLoginPage, "Password cannot be blank");
					
				}
				
				else{
				
				
				try{  
								
					//			String password=passwordField.getPassword().toString();
//					char[] password=passwordField.getPassword();
//					String password=new String(passwordField.getPassword().toString());
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection;
//					if (AdminConfigure.hostname!=null && AdminConfigure.portno!=null && AdminConfigure.dbname!=null && AdminConfigure.dbuname!=null && AdminConfigure.dbpassword!=null ) {
//						connection=DriverManager.getConnection(  
//								"jdbc:mysql://"+AdminConfigure.hostname+":"+AdminConfigure.portno+"/"+AdminConfigure.dbname+"",""+AdminConfigure.dbuname+"",""+AdminConfigure.dbpassword+"");  
//					}
//					
//					else{
					
					connection=DriverManager.getConnection(  
							"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  

					//}
					String qu2= "select * from users where uname='"+username+"'&& upass='"+password+"' && confirmed='1'";
				//	String qu2= "select * from users";
				//	String qu2= "select * from users where uname='arav'&& upass='pass'";
					//select * from users where uname='arav'&& upass='pass'
					
					Statement statement= connection.createStatement();
					ResultSet row= statement.executeQuery(qu2);
//					if(row.getString("confirmed")=="0"){
//						System.out.println("user not verified");
//					}
//					
//					else
					if (row.first()) {
						JOptionPane.showMessageDialog(frameLoginPage, " Logged In successfully!");
						
						LandingPage landingPage = new LandingPage();
						landingPage.frameLandingPage.setVisible(true);
						frameLoginPage.dispose();
						
					}
					else{
						JOptionPane.showMessageDialog(frameLoginPage, " Username/Password is Wrong or User is not verified by Admin. Contact Admin");
						
						
					}
						
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}  

				
				
			}
			}});
		btnLogIn.setBounds(225, 336, 401, 47);
		frameLoginPage.getContentPane().add(btnLogIn);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(363, 425, 115, 14);
		frameLoginPage.getContentPane().add(lblOr);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.setForeground(new Color(0, 0, 0));
		btnSignup.setBackground(new Color(0, 250, 154));
		btnSignup.setFont(new Font("Raleway", Font.PLAIN, 12));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignUpPage page = new SignUpPage();
				page.frameSignUp.setVisible(true);
				frameLoginPage.dispose();
				
				
			}
		});
		btnSignup.setBounds(290, 465, 271, 39);
		frameLoginPage.getContentPane().add(btnSignup);
		
		JLabel lblMerchantLogin = new JLabel("Merchant Login");
		lblMerchantLogin.setBackground(Color.LIGHT_GRAY);
		lblMerchantLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMerchantLogin.setFont(new Font("Raleway", Font.PLAIN, 20));
		lblMerchantLogin.setBounds(297, 27, 264, 47);
		frameLoginPage.getContentPane().add(lblMerchantLogin);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frameLoginPage.dispose();
			}
		});
		btnGoBack.setBounds(10, 10, 153, 23);
		frameLoginPage.getContentPane().add(btnGoBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginPage.class.getResource("/com/arav/minorproject/bg_gray.png")));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(0, 0, 918, 617);
		frameLoginPage.getContentPane().add(label);
	}
}
