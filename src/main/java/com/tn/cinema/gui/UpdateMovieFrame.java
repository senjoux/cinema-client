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

import com.alee.extended.image.WebDecoratedImage;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.filechooser.WebFileChooser;
import com.alee.laf.text.WebTextField;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.controller.SuperAdminController;
import com.tn.cinema.entities.Movie;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.Utils;
import com.tn.cinema.utility.ValidatorsManager;

@SuppressWarnings("serial")
public class UpdateMovieFrame extends JFrame {

	private JPanel contentPane;
	private WebTextField txtTitle;
	private WebTextField txtLength;
	private WebTextField txtType;
	
	private File file = null;
	private WebButton btnChoose;
	WebDecoratedImage coverImg;
	private WebButton btnCancel;
	private WebButton btnSave;
	private boolean coverChanged;


	/**
	 * Create the frame.
	 */
	public UpdateMovieFrame(Movie mv) {
		setBounds(100, 100, 447, 244);
		ImageIcon frameIcon=new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		this.setResizable(false);
		
		this.setIconImage(frameIcon.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		coverImg = new WebDecoratedImage();
		BufferedImage image = Utils.convertToImage(mv.getCover());
		coverImg.setImage(image.getScaledInstance(134, 122, Image.SCALE_DEFAULT));
		coverImg.setLocation(281, 29);
		coverImg.setSize(134, 122);
		contentPane.add(coverImg);

		JLabel lblTitle = new JLabel(PropertyConstant.TITLE);
		lblTitle.setBounds(10, 32, 65, 14);
		contentPane.add(lblTitle);

		JLabel lblLength = new JLabel(PropertyConstant.LENGTH+" (min)");
		lblLength.setBounds(10, 66, 83, 14);
		contentPane.add(lblLength);

		JLabel lblType = new JLabel(PropertyConstant.TYPE);
		lblType.setBounds(10, 97, 108, 14);
		contentPane.add(lblType);

		txtTitle = new WebTextField(mv.getTitle());
		txtTitle.setBounds(124, 29, 116, 23);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);

		txtLength = new WebTextField(mv.getLength().toString());
		txtLength.setBounds(124, 63, 116, 23);
		contentPane.add(txtLength);
		txtLength.setColumns(10);

		txtType = new WebTextField(mv.getType());
		txtType.setBounds(124, 94, 116, 23);
		contentPane.add(txtType);
		txtType.setColumns(10);

		btnChoose = new WebButton(PropertyConstant.UPLOAD + " Cover");
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
				if (imageChooser.showOpenDialog(UpdateMovieFrame.this) == WebFileChooser.APPROVE_OPTION) {
					file = imageChooser.getSelectedFile();

					// i ve choosen max size of file = 1024*1024*1.5 = 1572864 =
					// 1.5 mo
					if (file.length() > 1572864) {
						NotificationsManager.displayImageErrorPopUp();
					} else {
						image = new ImageIcon(file.getAbsolutePath());
						coverImg.setImage(image.getImage().getScaledInstance(134, 122, Image.SCALE_DEFAULT));
						coverChanged = true;
					}

				}
			}
		});

		btnChoose.setBounds(124, 128, 116, 23);
		contentPane.add(btnChoose);

		btnCancel = new WebButton(PropertyConstant.CANCEL,
				new ImageIcon(getClass().getResource("/images/Cancel-icon.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.disposeUpdateMovieFrame();
			}
		});
		btnCancel.setBounds(320, 181, 91, 23);
		contentPane.add(btnCancel);

		btnSave = new WebButton(PropertyConstant.SAVE, new ImageIcon(getClass().getResource("/images/Ok-icon.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
			if(txtTitle.getText().isEmpty() || txtLength.getText().isEmpty() || txtType.getText().isEmpty() ){
				txtTitle.setBorder(BorderFactory.createLineBorder(Color.RED));
				txtLength.setBorder(BorderFactory.createLineBorder(Color.RED));
				txtType.setBorder(BorderFactory.createLineBorder(Color.RED));
			}else {
				if(ValidatorsManager.validateStringAsLong(txtLength.getText())){
					boolean res=SuperAdminController.updateMovie(mv,txtTitle.getText(),  txtLength.getText(), txtType.getText(),
							file,coverChanged);
					if(res){
						NotificationsManager.displayUpdateSuccessPopUp("Movie");
						SuperAdminController.loadMovies();
					}else {
						NotificationsManager.displayUpdateErrorPopUp("movie");
					}
					
				} else {
					NotificationsManager.displayInputsErrorPopUp();
				}
				
			}
			}
		});
		btnSave.setBounds(219, 181, 91, 23);
		contentPane.add(btnSave);
		setResizable(false);
	}
}
