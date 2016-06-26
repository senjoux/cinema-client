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
import com.tn.cinema.entities._3DMovieTheater;
import com.tn.cinema.model.ManagersModel;
import com.tn.cinema.model.TheaterManagersModel;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.Utils;
import com.tn.cinema.utility.ValidatorsManager;

public class Update3DMovieTheaterFrame extends JFrame {

	private JPanel newMovieTheaterPanel;
	private WebTextField txtName;
	private WebTextField txtAdress;
	private WebTextField txtProjectionType;
	private WebSlider sliderCapacity;
	private WebTextField txtPhone;
	private WebSwitch wsIsLocked;
	private static JTable table;
	private WebButton btnCancel;
	private WebButton btnSave;
	private JLabel lbldProjection;
	private JLabel lblProjectionType;

	
	/**
	 * Create the frame.
	 */
	public Update3DMovieTheaterFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 518);
		ImageIcon frameIcon=new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		this.setResizable(false);
		newMovieTheaterPanel = new JPanel();
		newMovieTheaterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		newMovieTheaterPanel.setLayout(null);
		setContentPane(newMovieTheaterPanel);

		txtProjectionType = new WebTextField();
		txtProjectionType.setBounds(124, 227, 116, 23);
		txtProjectionType.setEnabled(false);
		getContentPane().add(txtProjectionType);
		txtProjectionType.setColumns(10);

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
		sliderCapacity.setBounds(114, 126, 284, 54);
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
				SuperAdminController.disposeNewMovieTheaterFrame();
			}
		});
		btnCancel.setBounds(282, 457, 91, 23);
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
						// 555555555555555555555555
						if (table.getSelectedRow() >= 0) {
							TheaterManagersModel.setSelectedManager(table.getSelectedRow());

							if (wsIsLocked.isSelected()) {
								// 3d movie theater
								boolean res = SuperAdminController.insert3DMovieTheater(txtName.getText(),
										txtAdress.getText(), txtPhone.getText(), sliderCapacity.getValue(),
										txtProjectionType.getText(), TheaterManagersModel.getSelectedManager());
								if (res) {
									NotificationsManager.displayInsertSuccessPopUp("3D Movie Theater");
									SuperAdminController.loadMovieTheaters();
									SuperAdminController.loadTheaterManagers();
								} else {
									NotificationsManager.displayInsertErrorPopUp("3D movie theater");
								}
							} else {
								// none 3d movie theater
								boolean res = SuperAdminController.insertMovieTheater(txtName.getText(),
										txtAdress.getText(), txtPhone.getText(), sliderCapacity.getValue(),
										TheaterManagersModel.getSelectedManager());
								if (res) {
									NotificationsManager.displayInsertSuccessPopUp("Movie Theater");
									SuperAdminController.loadMovieTheaters();
									SuperAdminController.loadTheaterManagers();
								} else {
									NotificationsManager.displayInsertErrorPopUp("movie theater");
								}
							}
						} else {
							NotificationsManager.displaySelectPopUp("manager");
						}
						// 555555555555555555555555555555
					} else {
						NotificationsManager.displayInputsErrorPopUp();
					}

				}
			}
		});
		btnSave.setBounds(175, 457, 91, 23);
		getContentPane().add(btnSave);

		wsIsLocked = new WebSwitch();
		wsIsLocked.setLocation(124, 193);
		wsIsLocked.setSize(65, 23);
		wsIsLocked.setRound(8);
		wsIsLocked
				.setLeftComponent(createSwitchIcon(new ImageIcon(getClass().getResource("/images/tiny_on.png")), 4, 0));
		wsIsLocked.setRightComponent(
				createSwitchIcon(new ImageIcon(getClass().getResource("/images/tiny_off.png")), 0, 4));
		wsIsLocked.setSelected(false);
		System.out.println(wsIsLocked.isSelected());
		wsIsLocked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtProjectionType.setEnabled(wsIsLocked.isSelected());
			}
		});
		getContentPane().add(wsIsLocked);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 301, 388, 145);
		newMovieTheaterPanel.add(scrollPane);
		table = new JTable(new TheaterManagersModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TheaterManagersModel.setSelectedManager(table.getSelectedRow());
			}
		});
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);

		JLabel lblManager = new JLabel("Manager");
		lblManager.setBounds(10, 276, 65, 14);
		newMovieTheaterPanel.add(lblManager);

		lbldProjection = new JLabel("3D Projection");
		lbldProjection.setBounds(10, 193, 83, 23);
		newMovieTheaterPanel.add(lbldProjection);

		lblProjectionType = new JLabel("Projection Type");
		lblProjectionType.setBounds(10, 228, 91, 23);
		newMovieTheaterPanel.add(lblProjectionType);
	}

	public static JTable getTable() {
		return table;
	}

	private WebLabel createSwitchIcon(ImageIcon icon, final int left, final int right) {
		final WebLabel rightComponent = new WebLabel(icon, WebLabel.CENTER);
		rightComponent.setMargin(2, left, 2, right);
		return rightComponent;
	}
}
