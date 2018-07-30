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
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class SignUpPage {

	JFrame frameSignUp;
	private JTextField txtFullName;
	private JTextField txtUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage();
					window.frameSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSignUp = new JFrame();
		frameSignUp.setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpPage.class.getResource("/com/arav/minorproject/power_icon.png")));
		frameSignUp.setResizable(false);
		frameSignUp.setTitle("Sign Up to continue");
		frameSignUp.setBounds(100, 100, 915, 658);
		frameSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSignUp.getContentPane().setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("GTWalsheimLight", Font.PLAIN, 23));
		lblSignUp.setBounds(10, 104, 889, 36);
		frameSignUp.getContentPane().add(lblSignUp);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setBounds(154, 208, 70, 22);
		frameSignUp.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(154, 243, 70, 14);
		frameSignUp.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(154, 274, 70, 14);
		frameSignUp.getContentPane().add(lblPassword);
		
		txtFullName = new JTextField();
		txtFullName.setBounds(341, 209, 309, 20);
		frameSignUp.getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(341, 240, 309, 20);
		frameSignUp.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(341, 271, 309, 20);
		frameSignUp.getContentPane().add(passwordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String xname=txtFullName.getText().toString();
				String yuname=txtUserName.getText().toString();
			//	String zpass2=passwordField.getPassword().toString();
				String zpass2=new String(passwordField.getPassword());
				
				//String zpass2="default-password-empty";
				String cnfrmd="0";
				
				if (xname.equals("")) {
					JOptionPane.showMessageDialog(frameSignUp, "Name cannot be blank");
					
				}
				
				else if (yuname.equals("")) {
					JOptionPane.showMessageDialog(frameSignUp, "Username cannot be blank ");
					
				}
				else if (yuname.contains(" ")) {
					JOptionPane.showMessageDialog(frameSignUp, "Username cannot have blank spaces! ");
					
				}
				else if (yuname.contains("admin")) {
					JOptionPane.showMessageDialog(frameSignUp, "Cannot use keyword 'admin' in username. Reserved for administrator. Try Again ");
					
				}
				else if (zpass2.equals("")) {
					JOptionPane.showMessageDialog(frameSignUp, "Password cannot be blank");
					
				}
				
				else{
				try{
					
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager.getConnection(  
					"jdbc:mysql://"+DBValues.dbhost+":"+DBValues.dbport+"/"+DBValues.dbname+"",""+DBValues.dbuname+"",""+DBValues.dbpass+"");  
					
					String qu3= "select * from users where uname='"+yuname+"'";
					Statement statement2= connection.createStatement();
//					int row2= statement2.executeUpdate(qu3);
					ResultSet row2= statement2.executeQuery(qu3);
					
					if (row2.first()) {
						JOptionPane.showMessageDialog(frameSignUp, " Username already exists!!");
					}
					else{
						String qu2= "insert into users(uname, upass, name, confirmed) values ('"+yuname+"','"+zpass2+"','"+xname+"','"+cnfrmd+"')";
						Statement statement= connection.createStatement();
						int row= statement.executeUpdate(qu2);
					//	System.out.println(row+" row updated");
						JOptionPane.showMessageDialog(frameSignUp, row+" user registered successfully!");
						
						LoginPage page = new LoginPage();
						page.frameLoginPage.setVisible(true);
						frameSignUp.dispose();	
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
		btnSignUp.setBounds(260, 344, 349, 23);
		frameSignUp.getContentPane().add(btnSignUp);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginPage page = new LoginPage();
				page.frameLoginPage.setVisible(true);
				frameSignUp.dispose();
				
			}
		});
		btnLogIn.setBounds(367, 428, 153, 23);
		frameSignUp.getContentPane().add(btnLogIn);
		
		JLabel label = new JLabel("______________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(289, 378, 269, 14);
		frameSignUp.getContentPane().add(label);
		
		JLabel lblAlreadyAUser = new JLabel("Already a User?");
		lblAlreadyAUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlreadyAUser.setBounds(357, 403, 153, 14);
		frameSignUp.getContentPane().add(lblAlreadyAUser);
		
		JLabel lblAsMerchant = new JLabel("as Merchant");
		lblAsMerchant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsMerchant.setBounds(20, 143, 879, 14);
		frameSignUp.getContentPane().add(lblAsMerchant);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SignUpPage.class.getResource("/com/arav/minorproject/back_3.jpg")));
		label_1.setBounds(-13, 0, 951, 685);
		frameSignUp.getContentPane().add(label_1);
	}
}
