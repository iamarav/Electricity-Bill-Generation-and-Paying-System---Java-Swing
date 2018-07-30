package com.arav.minorproject;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin {

//	String uname, upass;
	 JFrame frmAdminLogin;
	 JTextField tfUsername;
	 JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminLogin() {
		initialize();
	}

	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setResizable(false);
		frmAdminLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmAdminLogin.setTitle("Admin Login");
		frmAdminLogin.setBounds(100, 100, 922, 605);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		
		JLabel lblLogInAs = new JLabel("Log In As Super User");
		lblLogInAs.setFont(new Font("Raleway", Font.PLAIN, 20));
		lblLogInAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInAs.setBounds(10, 102, 896, 49);
		frmAdminLogin.getContentPane().add(lblLogInAs);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(216, 211, 476, 29);
		frmAdminLogin.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(216, 174, 476, 23);
		frmAdminLogin.getContentPane().add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 285, 476, 29);
		frmAdminLogin.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(216, 252, 476, 29);
		frmAdminLogin.getContentPane().add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				String username=tfUsername.getText().toString();
				String password=new String(passwordField.getPassword());		

				
	//				if (uname=="admin" && upassword="1") {
	//					JOptionPane.showMessageDialog(frmAdminLogin, "Admin");
	//					
	//				}
	//				
				
				if (username.equals("")) {
					JOptionPane.showMessageDialog(frmAdminLogin, "Username cannot be blank ");
					
				}
				else if (username.contains(" ")) {
					JOptionPane.showMessageDialog(frmAdminLogin, "Username cannot have blank spaces! ");
					
				}
				else if (password.equals("")) {
					JOptionPane.showMessageDialog(frmAdminLogin, "Password cannot be blank");
					
				}
				
				else{
					if (username.equals("admin") && password.equals("pass")) {
						
						JOptionPane.showMessageDialog(frmAdminLogin, "Login Success");
						
						AdminLanding adminLanding = new AdminLanding();
						adminLanding.frmAdminLandingPage.setVisible(true);
						frmAdminLogin.dispose();
						
					
					}
					else if (username.equals("arav") && password.equals("arav")) {

						
						JOptionPane.showMessageDialog(frmAdminLogin, "Login Success");
						
						AdminLanding adminLanding = new AdminLanding();
						adminLanding.frmAdminLandingPage.setVisible(true);
						frmAdminLogin.dispose();
	

					}
					else{
						JOptionPane.showMessageDialog(frmAdminLogin, "Login Failed!");

					}
					
				}
				
			}
		});
		btnLogIn.setBounds(279, 358, 350, 50);
		frmAdminLogin.getContentPane().add(btnLogIn);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frmAdminLogin.dispose();
			}
		});
		btnGoBack.setBounds(350, 500, 200, 50);
		frmAdminLogin.getContentPane().add(btnGoBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminLogin.class.getResource("/com/arav/minorproject/back_3.jpg")));
		label.setBounds(-23, 0, 955, 593);
		frmAdminLogin.getContentPane().add(label);
	}
}
