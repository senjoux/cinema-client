package com.tn.cinema.gui.superAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import com.alee.extended.image.WebDecoratedImage;
import com.alee.extended.painter.BorderPainter;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebTextField;
import com.alee.managers.style.skin.web.WebLabelPainter;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.controller.SuperAdminController;
import com.tn.cinema.model.ManagersModel;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.Utils;

public class ManagersPanel extends JPanel {

	private JTable table;
	private JScrollPane scrollPane;
	private WebTextField txtX;
	private WebButton btnSearch;
	private WebButton btnReload;
	private WebDecoratedImage profileImg;
	WebButton bntNew;
	private WebButton btnUpdate;
	private WebButton bntRemove;
	private WebLabel lblSelectedManagerContainer;
	private WebLabel lblUtilityContainer;

	@SuppressWarnings("rawtypes")
	public ManagersPanel() {
		setBounds(10, 11, 600, 384);
		setLayout(null);

		bntRemove = new WebButton(PropertyConstant.DELETE,
				new ImageIcon(getClass().getResource("/images/deleteuser.png")));
		bntRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					ManagersModel.setSelectedManager(table.getSelectedRow());
					boolean res=SuperAdminController.deleteManager(ManagersModel.getSelectedManager());
					if (res) {
						NotificationsManager.displayDeleteSuccessPopUp("Manager");
						SuperAdminController.loadManagers();
					}else {
						NotificationsManager.displayDeleteErrorPopUp("manager");
					}
				} else {
					NotificationsManager.displaySelectPopUp("manager");
				}
			}
		});
		
		bntNew = new WebButton(PropertyConstant.NEW, new ImageIcon(getClass().getResource("/images/newuser.png")));
		bntNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.showNewManagerFrame();
			}
		});
		bntNew.setBounds(323, 53, 91, 26);
		add(bntNew);
		bntRemove.setBounds(466, 243, 91, 26);
		add(bntRemove);

		btnUpdate = new WebButton(PropertyConstant.UPDATE, new ImageIcon(getClass().getResource("/images/tool.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					ManagersModel.setSelectedManager(table.getSelectedRow());
					SuperAdminController.showUpdateManagerFrame(ManagersModel.getSelectedManager());
				} else {
					NotificationsManager.displaySelectPopUp("manager");
				}
			}
		});
		btnUpdate.setBounds(466, 213, 91, 26);
		add(btnUpdate);

		ImageIcon defaultUserIcon = new ImageIcon(getClass().getResource("/images/defaultUser.png"));
		profileImg = new WebDecoratedImage(defaultUserIcon);
		profileImg.setBorderColor(Color.BLACK);
		profileImg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		profileImg.setShadeWidth(5);
		profileImg.setBounds(456, 102, 111, 105);
		add(profileImg);

		lblSelectedManagerContainer = new WebLabel();
		lblSelectedManagerContainer.setShadeColor(Color.DARK_GRAY);
		lblSelectedManagerContainer.setLocation(433, 90);
		lblSelectedManagerContainer.setSize(156, 206);
		lblSelectedManagerContainer.setPainter(new WebLabelPainter(new BorderPainter())).setMargin(10);
		add(lblSelectedManagerContainer);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 90, 403, 206);
		add(scrollPane);

		table = new JTable(new ManagersModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			private BufferedImage image = null;

			@Override
			public void mouseClicked(MouseEvent arg0) {
				ManagersModel.setSelectedManager(table.getSelectedRow());
				image = Utils.convertToImage(ManagersModel.getSelectedManager().getImage());
				profileImg.setImage(image.getScaledInstance(121, 117, Image.SCALE_DEFAULT));
			}
		});
		scrollPane.setViewportView(table);

		txtX = new WebTextField();
		txtX.setForeground(Color.BLACK);
		txtX.setBounds(128, 16, 128, 26);
		txtX.setInputPrompt("email, name ...");
		txtX.setInputPromptFont(txtX.getFont().deriveFont(Font.ITALIC));
		add(txtX);
		txtX.setColumns(10);

		btnSearch = new WebButton(PropertyConstant.SEARCH,
				new ImageIcon(getClass().getResource("/images/search-icon.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.loadManagers(txtX.getText());
			}
		});
		btnSearch.setBounds(32, 16, 91, 26);
		add(btnSearch);

		btnReload = new WebButton(PropertyConstant.RELOAD, new ImageIcon(getClass().getResource("/images/reload.png")));
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.loadManagers();
			}
		});
		btnReload.setBounds(32, 53, 91, 26);
		add(btnReload);

		lblUtilityContainer = new WebLabel();
		lblUtilityContainer.setLocation(20, 11);
		lblUtilityContainer.setSize(403, 73);
		lblUtilityContainer.setPainter(new WebLabelPainter(new BorderPainter())).setMargin(10);
		add(lblUtilityContainer);

	}

	public JTable getTable() {
		return table;
	}
}
