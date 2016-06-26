package com.tn.cinema.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alee.extended.image.WebDecoratedImage;

import javax.swing.JLabel;

public class MovieCoverFrame extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MovieCoverFrame(BufferedImage image) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, image.getWidth()+5, image.getHeight()+5);
		ImageIcon frameIcon=new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		this.setResizable(false);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
	
		WebDecoratedImage lblCover = new WebDecoratedImage();
		lblCover.setBounds(0, 0, image.getWidth(), image.getHeight());
		lblCover.setImage(image.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
		contentPane.add(lblCover);
	}
}
