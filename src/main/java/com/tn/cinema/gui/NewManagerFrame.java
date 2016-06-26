package com.tn.cinema.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.alee.extended.image.WebDecoratedImage;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.filechooser.WebFileChooser;
import com.alee.laf.slider.WebSlider;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.controller.ManagerController;
import com.tn.cinema.controller.SuperAdminController;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.ValidatorsManager;

public class NewManagerFrame extends JFrame {
	
	//new manager panel
	private JPanel newManagerPanel;
	private WebTextField txtFirstName;
	private WebTextField txtNameManager;
	private WebTextField txtMobilePhone;
	private WebTextField txtEmail;
	private WebPasswordField txtPassword;
	private WebPasswordField txtValidatePassword;
	private File file = null;
	private WebButton btnChoose;
	WebDecoratedImage profileImg;
	private WebButton btnCancelManager;
	private WebButton btnNext;

	//new movie theater panel
	private JPanel newMovieTheaterPanel;
	private WebTextField txtName;
	private WebTextField txtAdress;
	private WebSlider sliderCapacity;
	private WebTextField txtPhone;
	private WebButton btnCancel;
	private WebButton btnSave;

	

	/**
	 * Create the frame.
	 */
	public NewManagerFrame() {
		setBounds(100, 100, 444, 276);
		ImageIcon frameIcon = new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		buildNewManagerPanel(); 
		setContentPane(newManagerPanel);
		setResizable(false);
	}
	

	public void buildNewManagerPanel() {
		newManagerPanel = new JPanel();
		newManagerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		newManagerPanel.setLayout(null);
		file = new File(NewAdminFrame.class.getResource("/images/defaultUser.png").getFile());
		ImageIcon defaultUserIcon = new ImageIcon(getClass().getResource("/images/defaultUser.png"));
		profileImg = new WebDecoratedImage(defaultUserIcon);
		profileImg.setLocation(278, 29);
		profileImg.setSize(134, 122);
		newManagerPanel.add(profileImg);
		
		JLabel lblFirstName = new JLabel(PropertyConstant.FIRST_NAME);
		lblFirstName.setBounds(10, 32, 65, 14);
		newManagerPanel.add(lblFirstName);

		JLabel lblName = new JLabel(PropertyConstant.NAME);
		lblName.setBounds(10, 57, 65, 14);
		newManagerPanel.add(lblName);

		JLabel lblMobilePhone = new JLabel(PropertyConstant.MOBILE_PHONE);
		lblMobilePhone.setBounds(10, 82, 108, 14);
		newManagerPanel.add(lblMobilePhone);

		JLabel lblEmail = new JLabel(PropertyConstant.EMAIL);
		lblEmail.setBounds(10, 122, 65, 14);
		newManagerPanel.add(lblEmail);

		JLabel lblPassword = new JLabel(PropertyConstant.PASSWORD);
		lblPassword.setBounds(10, 147, 65, 14);
		newManagerPanel.add(lblPassword);

		JLabel lblValidatePassword = new JLabel(PropertyConstant.VALIDATE_PASSWORD);
		lblValidatePassword.setBounds(10, 167, 108, 33);
		newManagerPanel.add(lblValidatePassword);

		txtFirstName = new WebTextField();
		txtFirstName.setBounds(124, 29, 116, 23);
		newManagerPanel.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtNameManager = new WebTextField();
		txtNameManager.setBounds(124, 54, 116, 23);
		newManagerPanel.add(txtNameManager);
		txtNameManager.setColumns(10);

		txtMobilePhone = new WebTextField();
		txtMobilePhone.setBounds(124, 79, 116, 23);
		newManagerPanel.add(txtMobilePhone);
		txtMobilePhone.setColumns(10);

		txtEmail = new WebTextField();
		txtEmail.setBounds(124, 119, 116, 23);
		newManagerPanel.add(txtEmail);
		txtEmail.setColumns(10);

		txtPassword = new WebPasswordField();
		txtPassword.setBounds(124, 144, 116, 20);
		newManagerPanel.add(txtPassword);
		txtPassword.setColumns(10);

		txtValidatePassword = new WebPasswordField();
		txtValidatePassword.setBounds(124, 173, 116, 20);
		newManagerPanel.add(txtValidatePassword);
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
				if (imageChooser.showOpenDialog(NewManagerFrame.this) == WebFileChooser.APPROVE_OPTION) {
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
		newManagerPanel.add(btnChoose);

		btnCancelManager = new WebButton(PropertyConstant.CANCEL,
				new ImageIcon(getClass().getResource("/images/Cancel-icon.png")));
		btnCancelManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.disposeNewManagerFrame();
			}
		});
		btnCancelManager.setBounds(321, 210, 91, 23);
		newManagerPanel.add(btnCancelManager);

		btnNext = new WebButton(PropertyConstant.SAVE, new ImageIcon(getClass().getResource("/images/Ok-icon.png")));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtFirstName.getText().isEmpty() || txtNameManager.getText().isEmpty() || txtEmail.getText().isEmpty()
						|| (txtPassword.getPassword().length == 0) || (txtValidatePassword.getPassword().length == 0)) {
					txtFirstName.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtNameManager.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtValidatePassword.setBorder(BorderFactory.createLineBorder(Color.RED));
				} else {
					if (ValidatorsManager.checkPasswordsEqual(String.valueOf(txtPassword.getPassword()),
							String.valueOf(txtValidatePassword.getPassword())) == false) {
						NotificationsManager.displayPasswordsNotMatchingPopUp();
					} else {
						if (ValidatorsManager.validateFields(txtFirstName.getText(), txtNameManager.getText(),
								txtEmail.getText(), String.valueOf(txtPassword.getPassword()),
								txtMobilePhone.getText())) {
							boolean res = ManagerController.insertManager(txtFirstName.getText(), txtNameManager.getText(),
									txtEmail.getText(), String.valueOf(txtPassword.getPassword()),
									txtMobilePhone.getText(), file);
							if(res){			
								NotificationsManager.displayCreatedSuccessPopUp("Manager");
							}else {
								NotificationsManager.displayAccountErrorPopUp();
							}
									
						} else {
							NotificationsManager.displayInputsErrorPopUp();
						}
					}

				}
			}
		});
		btnNext.setBounds(225, 210, 91, 23);
		newManagerPanel.add(btnNext);
	}
	
	
}
