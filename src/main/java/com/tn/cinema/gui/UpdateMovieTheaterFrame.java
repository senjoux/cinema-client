package com.tn.cinema.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.alee.extended.button.WebSwitch;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.slider.WebSlider;
import com.alee.laf.text.WebTextField;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.controller.SuperAdminController;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.entities._3DMovieTheater;
import com.tn.cinema.model.ManagersModel;
import com.tn.cinema.model.TheaterManagersModel;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.Utils;
import com.tn.cinema.utility.ValidatorsManager;

public class UpdateMovieTheaterFrame extends JFrame {

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
	public UpdateMovieTheaterFrame(MovieTheater mt) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon frameIcon=new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		this.setResizable(false);
		setBounds(100, 100, 416, 256);
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

		txtName = new WebTextField(mt.getName());
		txtName.setBounds(124, 24, 116, 23);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAdress = new WebTextField(mt.getAdresse());
		txtAdress.setBounds(124, 58, 116, 23);
		getContentPane().add(txtAdress);
		txtAdress.setColumns(10);

		sliderCapacity = new WebSlider();
		sliderCapacity.setBounds(114, 126, 284, 54);
		sliderCapacity.setMinimum(0);
		sliderCapacity.setMaximum(1000);
		sliderCapacity.setMinorTickSpacing(50);
		sliderCapacity.setMajorTickSpacing(100);
		sliderCapacity.setPaintTicks(true);
		sliderCapacity.setPaintLabels(true);
		sliderCapacity.setValue(mt.getCapacity().intValue());
		getContentPane().add(sliderCapacity);

		txtPhone = new WebTextField(mt.getTelephone().toString());
		txtPhone.setBounds(124, 92, 116, 23);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);

		btnCancel = new WebButton(PropertyConstant.CANCEL,
				new ImageIcon(getClass().getResource("/images/Cancel-icon.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.disposeUpdateMovieTheaterFrame();
			}
		});
		btnCancel.setBounds(307, 191, 91, 23);
		getContentPane().add(btnCancel);

		btnSave = new WebButton(PropertyConstant.SAVE, new ImageIcon(getClass().getResource("/images/Ok-icon.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtName.getText().isEmpty() || txtAdress.getText().isEmpty() || txtPhone.getText().isEmpty()) {
					txtName.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtAdress.setBorder(BorderFactory.createLineBorder(Color.RED));
					txtPhone.setBorder(BorderFactory.createLineBorder(Color.RED));

				} else {
					// validate phone number
					if (ValidatorsManager.validateStringAsLong(txtPhone.getText())) {
						// 555555555555555555555555555555555555555555555555555555555555555555555
						boolean res = SuperAdminController.updateMovieTheater(mt, txtName.getText(),
								txtAdress.getText(), txtPhone.getText(), sliderCapacity.getValue());
						if (res) {
							NotificationsManager.displayUpdateSuccessPopUp("Movie Theater");
							SuperAdminController.loadMovieTheaters();
							
						} else {
							NotificationsManager.displayUpdateErrorPopUp("movie Theater");
						}

					} else {
						NotificationsManager.displayInputsErrorPopUp();
					}

				}
			}
		});
		btnSave.setBounds(206, 191, 91, 23);
		getContentPane().add(btnSave);

	}

}
