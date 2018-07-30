package com.arav.minorproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AboutDeveloper {

	JFrame frmAboutDeveloper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutDeveloper window = new AboutDeveloper();
					window.frmAboutDeveloper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AboutDeveloper() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAboutDeveloper = new JFrame();
		frmAboutDeveloper.setIconImage(Toolkit.getDefaultToolkit().getImage(AboutDeveloper.class.getResource("/com/arav/minorproject/power_icon.png")));
		frmAboutDeveloper.setResizable(false);
		frmAboutDeveloper.setTitle("About Developer");
		frmAboutDeveloper.setBounds(100, 100, 892, 625);
		frmAboutDeveloper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAboutDeveloper.getContentPane().setLayout(null);
		
		JLabel lblAboutDeveloper = new JLabel("About Developer");
		lblAboutDeveloper.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutDeveloper.setBounds(10, 34, 866, 14);
		frmAboutDeveloper.getContentPane().add(lblAboutDeveloper);
		
		JLabel label = new JLabel("___________________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 48, 866, 14);
		frmAboutDeveloper.getContentPane().add(label);
		
		JLabel lblGauravSachdeva = new JLabel("Gaurav Sachdeva");
		lblGauravSachdeva.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauravSachdeva.setFont(new Font("Cookie", Font.PLAIN, 43));
		lblGauravSachdeva.setBounds(10, 71, 866, 53);
		frmAboutDeveloper.getContentPane().add(lblGauravSachdeva);
		
		JLabel lblArav = new JLabel("Arav");
		lblArav.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblArav.setHorizontalAlignment(SwingConstants.CENTER);
		lblArav.setBounds(10, 118, 866, 28);
		frmAboutDeveloper.getContentPane().add(lblArav);
		
		JLabel lblMearavml = new JLabel("me@arav.ml");
		lblMearavml.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblMearavml.setHorizontalAlignment(SwingConstants.CENTER);
		lblMearavml.setBounds(263, 331, 116, 23);
		frmAboutDeveloper.getContentPane().add(lblMearavml);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(65, 336, 46, 14);
		frmAboutDeveloper.getContentPane().add(lblEmail);
		
		JLabel lblElectricityBillGenerating = new JLabel("Electricity Bill Generating and Paying System ");
		lblElectricityBillGenerating.setFont(new Font("Raleway", Font.PLAIN, 17));
		lblElectricityBillGenerating.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectricityBillGenerating.setBounds(255, 441, 414, 28);
		frmAboutDeveloper.getContentPane().add(lblElectricityBillGenerating);
		
		JLabel lblASwingjdbcBased = new JLabel("A Swing-JDBC Based Application on Windows");
		lblASwingjdbcBased.setHorizontalAlignment(SwingConstants.CENTER);
		lblASwingjdbcBased.setBounds(333, 481, 266, 14);
		frmAboutDeveloper.getContentPane().add(lblASwingjdbcBased);
		
		JButton btnGoToHome = new JButton("Go to Home");
		btnGoToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frmAboutDeveloper.dispose();
			}
		});
		btnGoToHome.setBounds(333, 542, 239, 23);
		frmAboutDeveloper.getContentPane().add(btnGoToHome);
		
		JLabel lblThankYouFor = new JLabel("Thank You for using this application!");
		lblThankYouFor.setFont(new Font("Raleway", Font.PLAIN, 14));
		lblThankYouFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYouFor.setBounds(255, 513, 383, 18);
		frmAboutDeveloper.getContentPane().add(lblThankYouFor);
		
		JLabel lblWebDeveloperAndroid = new JLabel("Web Developer, Android Developer, Java Developer");
		lblWebDeveloperAndroid.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblWebDeveloperAndroid.setHorizontalAlignment(SwingConstants.CENTER);
		lblWebDeveloperAndroid.setBounds(10, 151, 866, 38);
		frmAboutDeveloper.getContentPane().add(lblWebDeveloperAndroid);
		
		JLabel lblInterestsAndHobbies = new JLabel("Contact Information");
		lblInterestsAndHobbies.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterestsAndHobbies.setBounds(10, 292, 496, 28);
		frmAboutDeveloper.getContentPane().add(lblInterestsAndHobbies);
		
		JLabel label_1 = new JLabel("__________________________________");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 187, 866, 14);
		frmAboutDeveloper.getContentPane().add(label_1);
		
		JLabel lblWeb = new JLabel("Web");
		lblWeb.setBounds(65, 361, 46, 23);
		frmAboutDeveloper.getContentPane().add(lblWeb);
		
		JLabel lblWwwaravml = new JLabel("www.arav.ml");
		lblWwwaravml.setHorizontalAlignment(SwingConstants.CENTER);
		lblWwwaravml.setBounds(263, 365, 116, 14);
		frmAboutDeveloper.getContentPane().add(lblWwwaravml);
		
		JLabel lblBlog = new JLabel("Blog URL");
		lblBlog.setBounds(65, 395, 76, 18);
		frmAboutDeveloper.getContentPane().add(lblBlog);
		
		JLabel lblWwwdozyin = new JLabel("www.arav.ga");
		lblWwwdozyin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWwwdozyin.setBounds(255, 397, 127, 14);
		frmAboutDeveloper.getContentPane().add(lblWwwdozyin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Photography by Arav (Gaurav Sachdeva)");
		lblNewLabel.setIcon(new ImageIcon(AboutDeveloper.class.getResource("/com/arav/minorproject/wa3.jpeg")));
		lblNewLabel.setBounds(533, 212, 320, 174);
		frmAboutDeveloper.getContentPane().add(lblNewLabel);
		
		JLabel lblInterestsAndHobbies_1 = new JLabel("Interests and Hobbies");
		lblInterestsAndHobbies_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterestsAndHobbies_1.setBounds(10, 212, 496, 28);
		frmAboutDeveloper.getContentPane().add(lblInterestsAndHobbies_1);
		
		JLabel lblPhotographyBlogging = new JLabel("Photography, Blogging");
		lblPhotographyBlogging.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhotographyBlogging.setFont(new Font("Raleway", Font.PLAIN, 15));
		lblPhotographyBlogging.setBounds(10, 237, 496, 30);
		frmAboutDeveloper.getContentPane().add(lblPhotographyBlogging);
		
		JLabel label_2 = new JLabel("______________");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 279, 496, 14);
		frmAboutDeveloper.getContentPane().add(label_2);
		
		JLabel label_4 = new JLabel("_____________________________");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(10, 428, 866, 14);
		frmAboutDeveloper.getContentPane().add(label_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(AboutDeveloper.class.getResource("/com/arav/minorproject/back_3.jpg")));
		label_3.setBounds(-22, 0, 929, 614);
		frmAboutDeveloper.getContentPane().add(label_3);
	}

}
