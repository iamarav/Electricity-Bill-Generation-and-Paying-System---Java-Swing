package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class LandingPage {

	JFrame frameLandingPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage window = new LandingPage();
					window.frameLandingPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LandingPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLandingPage = new JFrame();
		frameLandingPage.setIconImage(Toolkit.getDefaultToolkit().getImage(LandingPage.class.getResource("/com/arav/minorproject/power_icon.png")));
		frameLandingPage.setResizable(false);
		frameLandingPage.setTitle("Welcome Page");
		frameLandingPage.setBounds(100, 100, 1038, 765);
		frameLandingPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLandingPage.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, Logged in as Merchant");
		lblWelcome.setFont(new Font("Sacramento", Font.PLAIN, 30));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 70, 864, 45);
		frameLandingPage.getContentPane().add(lblWelcome);
		
		JLabel lblHelloUser = new JLabel("");
		lblHelloUser.setFont(new Font("Cookie", Font.PLAIN, 30));
		lblHelloUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloUser.setBounds(10, 146, 1012, 34);
		frameLandingPage.getContentPane().add(lblHelloUser);

		if(LoginPage.unametopass != null){
		lblHelloUser.setText("Hello "+LoginPage.unametopass);
		}
		else{
			lblHelloUser.setText("Hello User!");
				
		}
		JLabel label = new JLabel("_______________________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 115, 1012, 14);
		frameLandingPage.getContentPane().add(label);
		
		JButton btnCalculator = new JButton("Calculator");
		btnCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalculator.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		btnCalculator.setBounds(154, 228, 89, 23);
		
		JLabel label_1 = new JLabel("_______________________________________________");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 510, 1012, 26);
		frameLandingPage.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("____________");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 178, 1012, 14);
		frameLandingPage.getContentPane().add(label_2);
		
		JButton btnGenerateANew = new JButton("Generate a new bill");
		btnGenerateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillGenerateNewBill newBill = new BillGenerateNewBill();
				newBill.frameNewBill.setVisible(true);
				frameLandingPage.dispose();
				
			}
		});
		btnGenerateANew.setBounds(363, 262, 298, 68);
		frameLandingPage.getContentPane().add(btnGenerateANew);
		
		JButton btnPayBill = new JButton("Pay Bill");
		btnPayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillPayBill payBill = new BillPayBill();
				payBill.frmPayBillsHere.setVisible(true);
				frameLandingPage.dispose();
			}
		});
		btnPayBill.setBounds(668, 262, 298, 68);
		frameLandingPage.getContentPane().add(btnPayBill);
		
		JButton btnAddNewCustomer = new JButton("Add New Customer");
		btnAddNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillAddNewCustomer addNewCustomer = new BillAddNewCustomer();
				//addNewCustomer.f
			   addNewCustomer.frmAddNewCustomer.setVisible(true);
				frameLandingPage.dispose();	
			
			}
		});
		btnAddNewCustomer.setBounds(55, 261, 298, 68);
		frameLandingPage.getContentPane().add(btnAddNewCustomer);
		
		JButton btnViewPreviousBills = new JButton("View Previous Bills");
		btnViewPreviousBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BillViewOldBillOptions viewOldBillOptions = new BillViewOldBillOptions();
			viewOldBillOptions.frmViewPreviousBills.setVisible(true);
			frameLandingPage.dispose();
				
			}
		});
		btnViewPreviousBills.setBounds(363, 357, 298, 63);
		frameLandingPage.getContentPane().add(btnViewPreviousBills);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(Color.RED);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frameLandingPage.dispose();
			}
		});
		btnLogOut.setBounds(363, 473, 298, 26);
		frameLandingPage.getContentPane().add(btnLogOut);
		
		JButton btnAboutDeveloper = new JButton("About Developer");
		btnAboutDeveloper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AboutDeveloper aboutDeveloper = new AboutDeveloper();
				aboutDeveloper.frmAboutDeveloper.setVisible(true);
				frameLandingPage.dispose();
				
			}
		});
		btnAboutDeveloper.setBounds(390, 602, 237, 23);
		frameLandingPage.getContentPane().add(btnAboutDeveloper);
		
		JLabel lblMadeByGaurav = new JLabel("Made");
		lblMadeByGaurav.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMadeByGaurav.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeByGaurav.setBounds(10, 636, 1012, 26);
		frameLandingPage.getContentPane().add(lblMadeByGaurav);
		
		JLabel lblBy = new JLabel("by");
		lblBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblBy.setBounds(10, 661, 1012, 23);
		frameLandingPage.getContentPane().add(lblBy);
		
		JLabel lblGauravSachdeva = new JLabel("Gaurav Sachdeva");
		lblGauravSachdeva.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauravSachdeva.setFont(new Font("Cookie", Font.PLAIN, 28));
		lblGauravSachdeva.setBounds(10, 681, 1012, 45);
		frameLandingPage.getContentPane().add(lblGauravSachdeva);
		
		JLabel lblElectricityBillGeneration = new JLabel("Electricity Bill Generation and Paying System");
		lblElectricityBillGeneration.setFont(new Font("Raleway", Font.PLAIN, 17));
		lblElectricityBillGeneration.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectricityBillGeneration.setBounds(10, 11, 1012, 48);
		frameLandingPage.getContentPane().add(lblElectricityBillGeneration);
		
		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MerchantFeedback page = new MerchantFeedback();
				page.frmFeedback.setVisible(true);
				frameLandingPage.dispose();
			}
		});
		btnFeedback.setBounds(407, 547, 200, 34);
		frameLandingPage.getContentPane().add(btnFeedback);
		
		JButton btnViewAllCustomers = new JButton("View All Customers");
		btnViewAllCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllCustomer viewAllCustomer = new ViewAllCustomer();
				viewAllCustomer.frmViewAllCustomers.setVisible(true);
				frameLandingPage.dispose();
				
			}
		});
		btnViewAllCustomers.setBounds(55, 357, 298, 63);
		frameLandingPage.getContentPane().add(btnViewAllCustomers);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(LandingPage.class.getResource("/com/arav/minorproject/back_5.jpg")));
		label_3.setBounds(0, 0, 1053, 760);
		frameLandingPage.getContentPane().add(label_3);
		
		JButton btnNewButton = new JButton("OTP via SMS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		btnNewButton.setBounds(141, 203, 117, 34);
	//	frameLandingPage.getContentPane().add(btnNewButton);
		//TODO: Remove above comment
	}

}
