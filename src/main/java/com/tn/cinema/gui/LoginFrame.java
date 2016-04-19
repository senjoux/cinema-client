package com.tn.cinema.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.alee.extended.painter.TitledBorderPainter;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;
import com.alee.managers.notification.NotificationIcon;
import com.alee.managers.notification.WebNotificationPopup;
import com.alee.managers.style.skin.web.WebLabelPainter;
import com.tn.cinema.controller.MainController;
import com.tn.cinema.controller.ManagerController;
import com.tn.cinema.entities.User;
import com.tn.cinema.utility.ValidatorsManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class LoginFrame extends WebFrame {

	private JPanel contentPane;

	private WebTextField txtEmail;
	private WebPasswordField txtPassword;
	private WebButton btnLogin;
	private WebLabel lblSignUpContainer;
	private WebLabel lblLogInContainer;
	private WebButton btnSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				WebLookAndFeel.install ();
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("MallaFilm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon frameIcon=new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		this.setResizable(false);
		//null to display at center of screen
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// btn sign up
		btnSignUp = new WebButton("Sign Up", new ImageIcon(getClass().getResource("/images/star-icon.png")));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerController.showNewManagerFrame();
				dispose();
			}
		});
		btnSignUp.setLocation(322, 36);
		btnSignUp.setSize(98, 24);
		contentPane.add(btnSignUp);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/Security-icon.png")));
		lblNewLabel.setBounds(10, 32, 132, 122);
		contentPane.add(lblNewLabel);

		// Email
		txtEmail = new WebTextField(15);
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setToolTipText("");
		txtEmail.setLocation(136, 45);
		txtEmail.setSize(143, 24);

		txtEmail.setInputPrompt("Enter email...");
		txtEmail.setInputPromptFont(txtEmail.getFont().deriveFont(Font.ITALIC));
		contentPane.add(txtEmail);

		// password
		txtPassword = new WebPasswordField(15);
		txtPassword.setLocation(136, 80);
		txtPassword.setSize(143, 24);
		txtPassword.setInputPrompt("Enter pass...");
		txtPassword.setHideInputPromptOnFocus(false);
		contentPane.add(txtPassword);

		// login button
		btnLogin = new WebButton("Simple");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtEmail.getText().isEmpty() || String.valueOf(txtPassword.getPassword()).isEmpty() 
												|| !ValidatorsManager.validateEmail(txtEmail.getText())){
					txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
				}else{
					MainController.loginDispatcher(txtEmail.getText(), String.valueOf(txtPassword.getPassword()));
				}
			}
		});
		btnLogin.setText("Log In");
		btnLogin.setLocation(136, 114);
		btnLogin.setSize(90, 24);
		contentPane.add(btnLogin);

		// lbl login container
		lblLogInContainer = new WebLabel();
		lblLogInContainer.setDrawShade(true);
		lblLogInContainer.setVerticalAlignment(SwingConstants.TOP);
		lblLogInContainer.setLocation(10, 11);
		lblLogInContainer.setSize(293, 143);
		lblLogInContainer.setPainter(new WebLabelPainter(new TitledBorderPainter("Hello again, "))).setMargin(5);
		contentPane.add(lblLogInContainer);

		// lbl sign in container
		lblSignUpContainer = new WebLabel();
		lblSignUpContainer.setDrawShade(true);
		lblSignUpContainer.setToolTipText("");
		lblSignUpContainer.setVerticalAlignment(SwingConstants.TOP);
		lblSignUpContainer.setLocation(313, 11);
		lblSignUpContainer.setSize(138, 58);
		lblSignUpContainer.setPainter(new WebLabelPainter(new TitledBorderPainter(" New here ?"))).setMargin(5);
		contentPane.add(lblSignUpContainer);

		
	}
}
