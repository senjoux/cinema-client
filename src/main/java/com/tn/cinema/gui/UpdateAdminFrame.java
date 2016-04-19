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
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.Utils;
import com.tn.cinema.utility.ValidatorsManager;

public class UpdateAdminFrame extends JFrame {

	private JPanel contentPane;
	private WebTextField txtFirstName;
	private WebTextField txtName;
	private WebTextField txtMobilePhone;
	private WebTextField txtEmail;
	private WebPasswordField txtPassword;
	private WebPasswordField txtValidatePassword;
	private WebSwitch wsIsLocked;
	private JLabel lblIsLocked;
	private WebButton btnChoose;
	private WebDecoratedImage profileImg;
	private WebButton btnCancel;
	private WebButton btnSave;
	private boolean imageChanged;
	private File file = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				WebLookAndFeel.install();
				try {
					UpdateAdminFrame frame = new UpdateAdminFrame(
							AdministratorServiceDelegate.findAdministratorByID(1));
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
	public UpdateAdminFrame(Administrator a) {
		setBounds(100, 100, 444, 296);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon frameIcon = new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		BufferedImage image = null;
		image = Utils.convertToImage(a.getImage());
		contentPane.setLayout(null);

		profileImg = new WebDecoratedImage();
		profileImg.setBounds(278, 29, 134, 122);
		profileImg.setImage(image.getScaledInstance(134, 122, Image.SCALE_DEFAULT));
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

		JLabel lblPassword = new JLabel(PropertyConstant.PASSWORD);
		lblPassword.setBounds(10, 137, 65, 14);
		contentPane.add(lblPassword);

		JLabel lblValidatePassword = new JLabel(PropertyConstant.VALIDATE_PASSWORD);
		lblValidatePassword.setBounds(10, 156, 108, 33);
		contentPane.add(lblValidatePassword);

		txtFirstName = new WebTextField(a.getFirstName());
		txtFirstName.setBounds(124, 29, 116, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtName = new WebTextField(a.getName());
		txtName.setBounds(124, 54, 116, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtMobilePhone = new WebTextField(a.getMobilePhone().toString());
		txtMobilePhone.setBounds(124, 79, 116, 20);
		contentPane.add(txtMobilePhone);
		txtMobilePhone.setColumns(10);

		txtEmail = new WebTextField(a.getEmail());
		txtEmail.setBounds(124, 104, 116, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtPassword = new WebPasswordField();
		txtPassword.setBounds(124, 134, 116, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		txtValidatePassword = new WebPasswordField();
		txtValidatePassword.setBounds(124, 162, 116, 20);
		contentPane.add(txtValidatePassword);
		txtValidatePassword.setColumns(10);

		btnChoose = new WebButton(PropertyConstant.UPLOAD + " Picture");
		btnChoose.setBounds(290, 172, 108, 23);
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
				if (imageChooser.showOpenDialog(UpdateAdminFrame.this) == WebFileChooser.APPROVE_OPTION) {
					file = imageChooser.getSelectedFile();

					// i ve choosen max size of file = 1024*1024*1.5 = 1572864 =
					// 1.5 mo
					if (file.length() > 1572864) {
						NotificationsManager.displayImageErrorPopUp();
					} else {
						image = new ImageIcon(file.getAbsolutePath());
						profileImg.setImage(image.getImage().getScaledInstance(134, 122, Image.SCALE_DEFAULT));
						imageChanged = true;
					}

				}
			}
		});
		contentPane.add(btnChoose);

		btnCancel = new WebButton(PropertyConstant.CANCEL,
				new ImageIcon(getClass().getResource("/images/Cancel-icon.png")));
		btnCancel.setBounds(321, 237, 91, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.diposeUpdateAdminFrame();
			}
		});
		contentPane.add(btnCancel);

		btnSave = new WebButton(PropertyConstant.SAVE, new ImageIcon(getClass().getResource("/images/Ok-icon.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtFirstName.getText().isEmpty() || txtName.getText().isEmpty() || txtEmail.getText().isEmpty()) {
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
							boolean res=SuperAdminController.updateAdmin(a,txtFirstName.getText(), txtName.getText(),
									txtEmail.getText(), String.valueOf(txtPassword.getPassword()),
									txtMobilePhone.getText(),file,imageChanged,wsIsLocked.isSelected());
							if (res) {
								NotificationsManager.displayUpdateSuccessPopUp("Admin");
								SuperAdminController.loadAdmins();
								
							} else {
								NotificationsManager.displayUpdateErrorPopUp("admin");
							}
						}else{
							NotificationsManager.displayInputsErrorPopUp();
						}
					}
				}
			}
		});
		btnSave.setBounds(222, 237, 91, 23);
		contentPane.add(btnSave);

		lblIsLocked = new JLabel("Locked");
		lblIsLocked.setBounds(10, 193, 46, 20);
		contentPane.add(lblIsLocked);
		wsIsLocked = new WebSwitch();
		wsIsLocked.setLocation(124, 193);
		wsIsLocked.setSize(65, 23);
		wsIsLocked.setRound(8);
		wsIsLocked
				.setLeftComponent(createSwitchIcon(new ImageIcon(getClass().getResource("/images/tiny_on.png")), 4, 0));
		wsIsLocked.setRightComponent(
				createSwitchIcon(new ImageIcon(getClass().getResource("/images/tiny_off.png")), 0, 4));
		wsIsLocked.setSelected(a.isLocked());
		System.out.println(wsIsLocked.isSelected());
		contentPane.add(wsIsLocked);

	}

	private WebLabel createSwitchIcon(ImageIcon icon, final int left, final int right) {
		final WebLabel rightComponent = new WebLabel(icon, WebLabel.CENTER);
		rightComponent.setMargin(2, left, 2, right);
		return rightComponent;
	}
	
	
}
