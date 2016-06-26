package com.tn.cinema.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.alee.extended.button.WebSwitch;
import com.alee.extended.image.WebDecoratedImage;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.filechooser.WebFileChooser;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.controller.SuperAdminController;
import com.tn.cinema.delegate.AdministratorServiceDelegate;
import com.tn.cinema.delegate.ManagerServiceDelegate;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.Utils;
import com.tn.cinema.utility.ValidatorsManager;

public class ManagerDetailsFrame extends JFrame {

	private JPanel contentPane;
	private WebTextField txtFirstName;
	private WebTextField txtName;
	private WebTextField txtMobilePhone;
	private WebTextField txtEmail;
	private WebDecoratedImage profileImg;
	private WebButton btnCancel;

	

	/**
	 * Create the frame.
	 */
	public ManagerDetailsFrame(Manager m) {
		setBounds(100, 100, 393, 193);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ImageIcon frameIcon = new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		BufferedImage image = null;
		image = Utils.convertToImage(m.getImage());
		contentPane.setLayout(null);

		profileImg = new WebDecoratedImage();
		profileImg.setBounds(263, 28, 91, 93);
		profileImg.setImage(image.getScaledInstance(91, 93, Image.SCALE_DEFAULT));
		contentPane.add(profileImg);

		JLabel lblFirstName = new JLabel(PropertyConstant.FIRST_NAME);
		lblFirstName.setBounds(10, 32, 65, 14);
		contentPane.add(lblFirstName);

		JLabel lblName = new JLabel(PropertyConstant.NAME);
		lblName.setBounds(10, 57, 65, 14);
		contentPane.add(lblName);

		JLabel lblMobilePhone = new JLabel(PropertyConstant.MOBILE_PHONE);
		lblMobilePhone.setBounds(10, 82, 108, 14);
		contentPane.add(lblMobilePhone);

		JLabel lblEmail = new JLabel(PropertyConstant.EMAIL);
		lblEmail.setBounds(10, 107, 65, 14);
		contentPane.add(lblEmail);

		txtFirstName = new WebTextField(m.getFirstName());
		txtFirstName.setBounds(124, 29, 116, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtName = new WebTextField(m.getName());
		txtName.setBounds(124, 54, 116, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtMobilePhone = new WebTextField(m.getMobilePhone().toString());
		txtMobilePhone.setBounds(124, 79, 116, 20);
		contentPane.add(txtMobilePhone);
		txtMobilePhone.setColumns(10);

		txtEmail = new WebTextField(m.getEmail());
		txtEmail.setBounds(124, 104, 116, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnCancel = new WebButton(PropertyConstant.CANCEL,
				new ImageIcon(getClass().getResource("/images/Cancel-icon.png")));
		btnCancel.setBounds(263, 132, 91, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.disposeManagerDetailsFrame();
			}
		});
		contentPane.add(btnCancel);
	}

	
	
}
