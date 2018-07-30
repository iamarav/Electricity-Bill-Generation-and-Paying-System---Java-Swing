package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class BillViewOldBillOptions {

	JFrame frmViewPreviousBills;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillViewOldBillOptions window = new BillViewOldBillOptions();
					window.frmViewPreviousBills.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillViewOldBillOptions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewPreviousBills = new JFrame();
		frmViewPreviousBills.setIconImage(Toolkit.getDefaultToolkit().getImage(BillViewOldBillOptions.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmViewPreviousBills.setResizable(false);
		frmViewPreviousBills.setTitle("View Previous Bills");
		frmViewPreviousBills.setBounds(100, 100, 943, 589);
		frmViewPreviousBills.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewPreviousBills.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome User");
		
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Cookie", Font.PLAIN, 35));
		lblWelcome.setBounds(10, 37, 917, 54);
		if(LoginPage.unametopass==null){
			lblWelcome.setText("Welcome User!");
			
		}
		
		else{
			lblWelcome.setText("Welcome "+LoginPage.unametopass+"!");
			
		}
		frmViewPreviousBills.getContentPane().add(lblWelcome);
		
		JButton btnViewUnpaidBills = new JButton("View Unpaid Bills");
		btnViewUnpaidBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillViewUnpaidBills viewUnpaidBills = new BillViewUnpaidBills();
				viewUnpaidBills.frmViewUnpaidBills.setVisible(true);
				frmViewPreviousBills.dispose();
				
//				BillViewOldBillOptions billOptions = new BillViewOldBillOptions();
//				billOptions.frmViewPreviousBills.dispose();
//				
			}
		});
		btnViewUnpaidBills.setBounds(103, 148, 276, 81);
		frmViewPreviousBills.getContentPane().add(btnViewUnpaidBills);
		
		JButton btnNewButton = new JButton("View Paid Bills");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillViewPaidBills viewUnpaidBills = new BillViewPaidBills();
				viewUnpaidBills.frmViewPaidBils.setVisible(true);
				frmViewPreviousBills.dispose();
			}
		});
		btnNewButton.setBounds(533, 148, 276, 81);
		frmViewPreviousBills.getContentPane().add(btnNewButton);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmViewPreviousBills.dispose();
			}
		});
		btnGoBack.setBounds(408, 327, 89, 23);
		frmViewPreviousBills.getContentPane().add(btnGoBack);
		
		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MerchantFeedback feedback = new MerchantFeedback();
				feedback.frmFeedback.setVisible(true);
				frmViewPreviousBills.dispose();
			}
		});
		btnFeedback.setBounds(357, 478, 200, 50);
		frmViewPreviousBills.getContentPane().add(btnFeedback);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BillViewOldBillOptions.class.getResource("/com/arav/minorproject/bg_gray.png")));
		label.setBounds(-17, 0, 968, 579);
		frmViewPreviousBills.getContentPane().add(label);
	}

}
