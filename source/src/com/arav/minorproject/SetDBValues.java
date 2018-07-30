package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetDBValues {

	JFrame frmSetDbValues;
	JTextField tfHost;
	JTextField tfPort;
	JTextField tfDBName;
	JTextField tfDBUName;
	JTextField tfDBPass;

//	static String newHost, newPort, newDBuser, newDBPass, newDB; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetDBValues window = new SetDBValues();
					window.frmSetDbValues.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetDBValues() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetDbValues = new JFrame();
		frmSetDbValues.setIconImage(Toolkit.getDefaultToolkit().getImage(SetDBValues.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmSetDbValues.setTitle("Set DB Values");
		frmSetDbValues.setBounds(100, 100, 719, 552);
		frmSetDbValues.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetDbValues.getContentPane().setLayout(null);
		
		JLabel lblSetValuesFor = new JLabel("Set Values for Database ");
		lblSetValuesFor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblSetValuesFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetValuesFor.setBounds(10, 24, 628, 54);
		frmSetDbValues.getContentPane().add(lblSetValuesFor);
		
		JLabel lblNotePleaseFill = new JLabel("Note: Please fill the Values Carefully");
		lblNotePleaseFill.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotePleaseFill.setBounds(10, 78, 628, 41);
		frmSetDbValues.getContentPane().add(lblNotePleaseFill);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(70, 153, 133, 34);
		frmSetDbValues.getContentPane().add(lblHost);
		
		JLabel lblPortNumber = new JLabel("Port Number");
		lblPortNumber.setBounds(70, 198, 133, 34);
		frmSetDbValues.getContentPane().add(lblPortNumber);
		
		JLabel lblDbName = new JLabel("DB Name");
		lblDbName.setBounds(70, 243, 133, 34);
		frmSetDbValues.getContentPane().add(lblDbName);
		
		JLabel lblDbUserName = new JLabel("DB User Name");
		lblDbUserName.setBounds(70, 288, 133, 34);
		frmSetDbValues.getContentPane().add(lblDbUserName);
		
		JLabel lblDbUserPass = new JLabel("DB User Pass");
		lblDbUserPass.setBounds(70, 333, 133, 34);
		frmSetDbValues.getContentPane().add(lblDbUserPass);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//
//				newDB = tfDBName.getText().toString();
//				newHost = tfHost.getText().toString();
//				newDBPass = tfDBPass.getText().toString();
//				newPort = tfPort.getText().toString();
//				newDBuser = tfDBUName.getText().toString();
				//newDB = tfDBName.getText().toString();
				
//				if(newDB.equals("")||newHost.equals("")||newDBPass.equals("")||newPort.equals("")||newDBuser.equals("")){
//
//					JOptionPane.showMessageDialog(frmSetDbValues, "Can not Set Blank Values");
//					
//					String mix =newDB+newHost+newDBPass+newPort+newDBuser;
//					System.out.println(mix);
//					
//				}
//				else{
//			//	System.out.println(newDB+ newHost+ newPort+ newDBPass+ newDBuser);
//
//			
//					///////////////////
//				JOptionPane.showMessageDialog(frmSetDbValues, "Values has been Set Please Confirm these Values are Case-Sensitive and any bad information may lead to Working Failure");
//				
////				StartPage page = new StartPage();
////				page.frmWelcome.setVisible(true);
////				frmSetDbValues.dispose();
////				
//				}
				}
		});
		btnSubmit.setBounds(243, 394, 180, 23);
		frmSetDbValues.getContentPane().add(btnSubmit);
		
		JButton btnCreateTableIn = new JButton("Create Table in Database");
		btnCreateTableIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateTableIn.setBounds(115, 458, 422, 34);
		frmSetDbValues.getContentPane().add(btnCreateTableIn);
		
		tfHost = new JTextField();
		tfHost.setBounds(243, 160, 180, 20);
		frmSetDbValues.getContentPane().add(tfHost);
		tfHost.setColumns(10);
		
		tfPort = new JTextField();
		tfPort.setColumns(10);
		tfPort.setBounds(243, 205, 180, 20);
		frmSetDbValues.getContentPane().add(tfPort);
		
		tfDBName = new JTextField();
		tfDBName.setColumns(10);
		tfDBName.setBounds(243, 250, 180, 20);
		frmSetDbValues.getContentPane().add(tfDBName);
		
		tfDBUName = new JTextField();
		tfDBUName.setColumns(10);
		tfDBUName.setBounds(243, 295, 180, 20);
		frmSetDbValues.getContentPane().add(tfDBUName);
		
		tfDBPass = new JTextField();
		tfDBPass.setColumns(10);
		tfDBPass.setBounds(243, 340, 180, 20);
		frmSetDbValues.getContentPane().add(tfDBPass);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frmSetDbValues.dispose();
			}
		});
		btnGoBack.setBounds(10, 410, 89, 23);
		frmSetDbValues.getContentPane().add(btnGoBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				newDB = null;
//				newHost = null;
//				newDBPass = null;
//				newPort = null;
//				newDBuser = null;
			}
		});
		btnReset.setBounds(549, 410, 89, 23);
		frmSetDbValues.getContentPane().add(btnReset);
	}
}
