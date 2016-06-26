package com.tn.cinema.gui.superAdmin;

import java.awt.Color;
import java.awt.Font;
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

import com.alee.extended.painter.BorderPainter;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebTextField;
import com.alee.managers.style.skin.web.WebLabelPainter;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.controller.SuperAdminController;
import com.tn.cinema.model.MovieTheatersModel;
import com.tn.cinema.utility.NotificationsManager;

public class MovieTheatersPanel extends JPanel {

	private JTable table;
	private JScrollPane scrollPane;
	private WebTextField txtX;
	private WebButton btnSearch;
	private WebButton btnReload;
	private WebButton btnManagerDetails;
	private WebButton bntNew;
	private WebButton btnUpdate;
	private WebButton bntRemove;
	private BufferedImage image = null;
	private WebLabel lblSelectedMTheaterContainer;
	private WebLabel lblUtilityContainer;

	@SuppressWarnings("rawtypes")
	public MovieTheatersPanel() {
		setBounds(10, 11, 612, 384);
		setLayout(null);

		bntRemove = new WebButton(PropertyConstant.DELETE, new ImageIcon(getClass().getResource("/images/remove.png")));
		bntRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					MovieTheatersModel.setSelectedMovieTheater(table.getSelectedRow());
					boolean res = SuperAdminController.deleteMovieTheater(MovieTheatersModel.getSelectedMovieTheater());
					if (res) {
						NotificationsManager.displayDeleteSuccessPopUp("Movie Theater");
						SuperAdminController.loadMovieTheaters();
						;
					} else {
						NotificationsManager.displayDeleteErrorPopUp("movie theater");
					}
				} else {
					NotificationsManager.displaySelectPopUp("movie theater");
				}
			}
		});

		bntNew = new WebButton(PropertyConstant.NEW, new ImageIcon(getClass().getResource("/images/create.png")));
		bntNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.showNewMovieTheaterFrame();
			}
		});

		btnManagerDetails = new WebButton(PropertyConstant.MANAGER_DETAILS,
				new ImageIcon(getClass().getResource("/images/defaultUser_small.png")));
		btnManagerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.showManagerDetailsFrame(MovieTheatersModel.getSelectedMovieTheater().getManager());
			}
		});
		btnManagerDetails.setBottomBgColor(Color.YELLOW);
		btnManagerDetails.setLocation(333, 43);
		btnManagerDetails.setSize(133, 36);
		add(btnManagerDetails);
		bntNew.setBounds(496, 228, 91, 26);
		add(bntNew);
		bntRemove.setBounds(496, 191, 91, 26);
		add(bntRemove);

		btnUpdate = new WebButton(PropertyConstant.UPDATE, new ImageIcon(getClass().getResource("/images/tool.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					MovieTheatersModel.setSelectedMovieTheater(table.getSelectedRow());
					SuperAdminController.showUpdateMovieTheaterFrame(MovieTheatersModel.getSelectedMovieTheater());
				} else {
					NotificationsManager.displaySelectPopUp("movie theater");
				}
			}
		});
		btnUpdate.setBounds(496, 152, 91, 26);
		add(btnUpdate);

		ImageIcon defaultUserIcon = new ImageIcon(getClass().getResource("/images/defaultUser.png"));

		lblSelectedMTheaterContainer = new WebLabel();
		lblSelectedMTheaterContainer.setShadeColor(Color.DARK_GRAY);
		lblSelectedMTheaterContainer.setLocation(484, 90);
		lblSelectedMTheaterContainer.setSize(118, 206);
		lblSelectedMTheaterContainer.setPainter(new WebLabelPainter(new BorderPainter())).setMargin(10);
		add(lblSelectedMTheaterContainer);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 90, 454, 206);
		add(scrollPane);

		table = new JTable(new MovieTheatersModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MovieTheatersModel.setSelectedMovieTheater(table.getSelectedRow());
			}
		});
		scrollPane.setViewportView(table);

		txtX = new WebTextField();
		txtX.setForeground(Color.BLACK);
		txtX.setBounds(128, 16, 128, 26);
		txtX.setInputPrompt("name, @, manager ...");
		txtX.setInputPromptFont(txtX.getFont().deriveFont(Font.ITALIC));
		add(txtX);
		txtX.setColumns(10);

		btnSearch = new WebButton(PropertyConstant.SEARCH,
				new ImageIcon(getClass().getResource("/images/search-icon.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.loadMovieTheaters(txtX.getText());
			}
		});
		btnSearch.setBounds(32, 16, 91, 26);
		add(btnSearch);

		btnReload = new WebButton(PropertyConstant.RELOAD, new ImageIcon(getClass().getResource("/images/reload.png")));
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.loadMovieTheaters();
			}
		});
		btnReload.setBounds(32, 53, 91, 26);
		add(btnReload);

		lblUtilityContainer = new WebLabel();
		lblUtilityContainer.setLocation(20, 11);
		lblUtilityContainer.setSize(454, 73);
		lblUtilityContainer.setPainter(new WebLabelPainter(new BorderPainter())).setMargin(10);
		add(lblUtilityContainer);

	}

	public JTable getTable() {
		return table;
	}

}
