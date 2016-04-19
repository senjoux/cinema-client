package com.tn.cinema.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.alee.extended.image.WebDecoratedImage;
import com.alee.laf.button.WebButton;
import com.alee.laf.filechooser.WebFileChooser;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.controller.ManagerController;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.ValidatorsManager;

public class NewManagerPanel extends JPanel {

	private WebTextField txtFirstName;
	private WebTextField txtName;
	private WebTextField txtMobilePhone;
	private WebTextField txtEmail;
	private WebPasswordField txtPassword;
	private WebPasswordField txtValidatePassword;
	private File file = null;
	private WebButton btnChoose;
	WebDecoratedImage profileImg;
	private WebButton btnCancel;
	private WebButton btnSave;
	
	public NewManagerPanel() {
		setLayout(null);
		file = new File(NewAdminFrame.class.getResource("/images/defaultUser.png").getFile());
		ImageIcon defaultUserIcon = new ImageIcon(getClass().getResource("/images/defaultUser.png"));
		profileImg = new WebDecoratedImage(defaultUserIcon);
		profileImg.setLocation(278, 29);
		profileImg.setSize(134, 122);
		add(profileImg);
		
		JLabel lblFirstName = new JLabel(PropertyConstant.FIRST_NAME);
		lblFirstName.setBounds(10, 32, 65, 14);
		add(lblFirstName);

		JLabel lblName = new JLabel(PropertyConstant.NAME);
		lblName.setBounds(10, 57, 65, 14);
		add(lblName);

		JLabel lblMobilePhone = new JLabel(PropertyConstant.MOBILE_PHONE);
		lblMobilePhone.setBounds(10, 82, 108, 14);
		add(lblMobilePhone);

		JLabel lblEmail = new JLabel(PropertyConstant.EMAIL);
		lblEmail.setBounds(10, 122, 65, 14);
		add(lblEmail);

		JLabel lblPassword = new JLabel(PropertyConstant.PASSWORD);
		lblPassword.setBounds(10, 147, 65, 14);
		add(lblPassword);

		JLabel lblValidatePassword = new JLabel(PropertyConstant.VALIDATE_PASSWORD);
		lblValidatePassword.setBounds(10, 167, 108, 33);
		add(lblValidatePassword);

		txtFirstName = new WebTextField();
		txtFirstName.setBounds(124, 29, 116, 23);
		add(txtFirstName);
		txtFirstName.setColumns(10);

		txtName = new WebTextField();
		txtName.setBounds(124, 54, 116, 23);
		add(txtName);
		txtName.setColumns(10);

		txtMobilePhone = new WebTextField();
		txtMobilePhone.setBounds(124, 79, 116, 23);
		add(txtMobilePhone);
		txtMobilePhone.setColumns(10);

		txtEmail = new WebTextField();
		txtEmail.setBounds(124, 119, 116, 23);
		add(txtEmail);
		txtEmail.setColumns(10);

		txtPassword = new WebPasswordField();
		txtPassword.setBounds(124, 144, 116, 20);
		add(txtPassword);
		txtPassword.setColumns(10);

		txtValidatePassword = new WebPasswordField();
		txtValidatePassword.setBounds(124, 173, 116, 20);
		add(txtValidatePassword);
		txtValidatePassword.setColumns(10);

		btnChoose = new WebButton(PropertyConstant.UPLOAD + " Picture");
		btnChoose.addActionListener(new ActionListener() {
			private JFileChooser imageChooser = null;
			private ImageIcon image = null;

			public void actionPerformed(ActionEvent e) {
				if (imageChooser == null) {
					imageChooser = new JFileChooser();
					imageChooser.setMultiSelectionEnabled(false);
					imageChooser.setAcceptAllFileFilterUsed(false);
					imageChooser.setFileFilter(
							new FileNameExtensionFilter("Image extensions *.png *.jpeg *.jpg", "png", "jpeg", "jpg"));
				}
				if (file != null) {
					imageChooser.setSelectedFile(file);
				}
				if (imageChooser.showOpenDialog(getParent()) == WebFileChooser.APPROVE_OPTION) {
					file = imageChooser.getSelectedFile();

					// i ve choosen max size of file = 1024*1024*1.5 = 1572864 =
					// 1.5 mo
					if (file.length() > 1572864) {
						NotificationsManager.displayImageErrorPopUp();
					} else {
						image = new ImageIcon(file.getAbsolutePath());
						profileImg.setImage(image.getImage().getScaledInstance(134, 122, Image.SCALE_DEFAULT));
					}

				}
			}
		});

		btnChoose.setBounds(290, 172, 108, 23);
		add(btnChoose);

		btnCancel = new WebButton(PropertyConstant.CANCEL,
				new ImageIcon(getClass().getResource("/images/Cancel-icon.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerController.disposeNewManagerFrame();
			}
		});
		btnCancel.setBounds(321, 210, 91, 23);
		add(btnCancel);

		btnSave = new WebButton(PropertyConstant.SAVE, new ImageIcon(getClass().getResource("/images/Ok-icon.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtFirstName.getText().isEmpty() || txtName.getText().isEmpty() || txtEmail.getText().isEmpty()
						|| (txtPassword.getPassword().length == 0) || (txtValidatePassword.getPassword().length == 0)) {
					txtFirstName.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtName.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtValidatePassword.setBorder(BorderFactory.createLineBorder(Color.RED));
				} else {
					if (ValidatorsManager.checkPasswordsEqual(String.valueOf(txtPassword.getPassword()),
							String.valueOf(txtValidatePassword.getPassword())) == false) {
						NotificationsManager.displayPasswordsNotMatchingPopUp();
					} else {
						if (ValidatorsManager.validateFields(txtFirstName.getText(), txtName.getText(),
								txtEmail.getText(), String.valueOf(txtPassword.getPassword()),
								txtMobilePhone.getText())) {
							/*boolean res = ManagerController.insertManager(txtFirstName.getText(), txtName.getText(),
									txtEmail.getText(), String.valueOf(txtPassword.getPassword()),
									txtMobilePhone.getText(), file);*/
							
						} else {
							NotificationsManager.displayInputsErrorPopUp();
						}
					}

				}
			}
		});
		btnSave.setBounds(225, 210, 91, 23);
		add(btnSave);

	}

}
