package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminLanding {

	JFrame frmAdminLandingPage;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLanding window = new AdminLanding();
					window.frmAdminLandingPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminLanding() {
		initialize();
	}

	private void initialize() {
		frmAdminLandingPage = new JFrame();
		frmAdminLandingPage.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLanding.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmAdminLandingPage.setTitle("Admin Landing Page");
		frmAdminLandingPage.setResizable(false);
		frmAdminLandingPage.setBounds(100, 100, 1010, 703);
		frmAdminLandingPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLandingPage.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Verify Merchants");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminVerifyMerchant verifyMerchant= new AdminVerifyMerchant();
				verifyMerchant.frmVerifyMerchants.setVisible(true);
				frmAdminLandingPage.dispose();
				
			}
		});
		btnNewButton.setBounds(223, 226, 450, 50);
		frmAdminLandingPage.getContentPane().add(btnNewButton);
		
		JLabel lblHelloAdmin = new JLabel("Hello Admin!");
		lblHelloAdmin.setFont(new Font("Raleway", Font.PLAIN, 35));
		lblHelloAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloAdmin.setBounds(10, 56, 911, 61);
		frmAdminLandingPage.getContentPane().add(lblHelloAdmin);
		
		JButton btnViewAllMerchants = new JButton("View All Merchants");
		btnViewAllMerchants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewAllMerchant allMerchant = new ViewAllMerchant();
				allMerchant.frm.setVisible(true);
				frmAdminLandingPage.dispose();
				
			}
		});
		btnViewAllMerchants.setBounds(223, 301, 451, 50);
		frmAdminLandingPage.getContentPane().add(btnViewAllMerchants);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frmAdminLandingPage.dispose();
			}
		});
		btnLogOut.setBounds(357, 525, 200, 50);
		frmAdminLandingPage.getContentPane().add(btnLogOut);
		
		JButton btnViewFeedbacksFrom = new JButton("View Feedbacks from Merchant");
		btnViewFeedbacksFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewFeedbacks feedbacks = new ViewFeedbacks();
				feedbacks.frmViewFeedbackss.setVisible(true);
				frmAdminLandingPage.dispose();
				
			}
		});
		btnViewFeedbacksFrom.setBounds(223, 382, 450, 50);
		frmAdminLandingPage.getContentPane().add(btnViewFeedbacksFrom);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminLanding.class.getResource("/com/arav/minorproject/back_8.png")));
		label.setBounds(-23, 0, 1031, 700);
		frmAdminLandingPage.getContentPane().add(label);
	}
}
