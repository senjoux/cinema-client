package com.tn.cinema.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alee.laf.button.WebButton;
import com.alee.laf.slider.WebSlider;
import com.alee.laf.text.WebTextField;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.utility.NotificationsManager;

public class NewMovieTheaterFrame extends JFrame {

	private JPanel newMovieTheaterPanel;
	private WebTextField txtName;
	private WebTextField txtAdress;
	private WebSlider sliderCapacity;
	private WebTextField txtPhone;
	private WebButton btnCancel;
	private WebButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMovieTheaterFrame frame = new NewMovieTheaterFrame(null);
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
	public NewMovieTheaterFrame(Manager m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 279);
		newMovieTheaterPanel = new JPanel();
		newMovieTheaterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		newMovieTheaterPanel.setLayout(null);
		setContentPane(newMovieTheaterPanel);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 29, 65, 14);
		getContentPane().add(lblName);

		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(10, 63, 65, 14);
		getContentPane().add(lblAdress);

		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(10, 132, 108, 14);
		getContentPane().add(lblCapacity);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 97, 65, 14);
		getContentPane().add(lblPhone);

		txtName = new WebTextField();
		txtName.setBounds(124, 24, 116, 23);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAdress = new WebTextField();
		txtAdress.setBounds(124, 58, 116, 23);
		getContentPane().add(txtAdress);
		txtAdress.setColumns(10);

		sliderCapacity = new WebSlider();
		sliderCapacity.setBounds(114, 126, 263, 54);
		sliderCapacity.setMinimum(0);
		sliderCapacity.setMaximum(1000);
		sliderCapacity.setMinorTickSpacing(50);
		sliderCapacity.setMajorTickSpacing(100);
		sliderCapacity.setPaintTicks(true);
		sliderCapacity.setPaintLabels(true);
		sliderCapacity.setValue(500);
		getContentPane().add(sliderCapacity);

		txtPhone = new WebTextField();
		txtPhone.setBounds(124, 92, 116, 23);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);

		btnCancel = new WebButton(PropertyConstant.CANCEL,
				new ImageIcon(getClass().getResource("/images/Cancel-icon.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ManagerController.disposeNewManagerFrame();
			}
		});
		btnCancel.setBounds(321, 210, 91, 23);
		getContentPane().add(btnCancel);

		btnSave = new WebButton(PropertyConstant.SAVE, new ImageIcon(getClass().getResource("/images/Ok-icon.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtName.getText().isEmpty() || txtAdress.getText().isEmpty() || txtPhone.getText().isEmpty()) {
					txtName.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtAdress.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtPhone.setBorder(BorderFactory.createLineBorder(Color.RED));

				} else {
					// validate phone naumber
					if (true) {
						/*
						 * boolean res =
						 * ManagerController.insertManager(txtFirstName.getText(
						 * ), txtName.getText(), txtEmail.getText(),
						 * String.valueOf(txtPassword.getPassword()),
						 * txtMobilePhone.getText(), file);
						 */

					} else {
						NotificationsManager.displayInputsErrorPopUp();
					}

				}
			}
		});
		btnSave.setBounds(225, 210, 91, 23);
		getContentPane().add(btnSave);
	}

}
