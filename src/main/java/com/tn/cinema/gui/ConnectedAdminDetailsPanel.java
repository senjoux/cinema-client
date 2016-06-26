package com.tn.cinema.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.alee.extended.image.WebDecoratedImage;
import com.alee.laf.button.WebButton;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.controller.SuperAdminController;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.utility.Utils;
import java.awt.Font;

public class ConnectedAdminDetailsPanel extends JPanel {
	private WebDecoratedImage profileImg;
	private WebButton btnLogout;

	/**
	 * Create the panel.
	 */
	public ConnectedAdminDetailsPanel(Administrator a) {
		setLayout(null);

		JLabel lblAdminName = new JLabel("[ "+a.getName() + " "
				+ a.getFirstName()+" ]");
		lblAdminName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAdminName.setBounds(111, 11, 170, 14);
		add(lblAdminName);

		BufferedImage image = null;
		image = Utils.convertToImage(a.getImage());

		profileImg = new WebDecoratedImage();
		profileImg.setBounds(10, 11, 91, 93);
		profileImg.setImage(image.getScaledInstance(91, 93, Image.SCALE_DEFAULT));
		add(profileImg);

		btnLogout = new WebButton(PropertyConstant.LOGOUT, new ImageIcon(getClass().getResource("/images/logout.png")));
		btnLogout.setBounds(635, 74, 132, 26);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
					SuperAdminController.logout();
			}
		});
		add(btnLogout);
		
		JLabel lblAdminMail = new JLabel("[ "+a.getEmail()+" ]");
		lblAdminMail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAdminMail.setBounds(111, 36, 170, 14);
		add(lblAdminMail);

	}
}
