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
import com.tn.cinema.model.MoviesModel;
import com.tn.cinema.utility.NotificationsManager;
import com.tn.cinema.utility.Utils;

public class MoviesPanel extends JPanel {

	private JTable table;
	private JScrollPane scrollPane;
	private WebTextField txtX;
	private WebButton btnSearch;
	private WebButton btnReload;
	private WebButton btnPoster;
	private WebButton bntNew;
	private WebButton btnUpdate;
	private WebButton bntRemove;
	private BufferedImage image = null;
	private WebLabel lblSelectedManagerContainer;
	private WebLabel lblUtilityContainer;

	@SuppressWarnings("rawtypes")
	public MoviesPanel() {
		setBounds(10, 11, 600, 384);
		setLayout(null);

		bntRemove = new WebButton(PropertyConstant.DELETE,
				new ImageIcon(getClass().getResource("/images/remove.png")));
		bntRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					MoviesModel.setSelectedMovie(table.getSelectedRow());
					boolean res=SuperAdminController.deleteMovie(MoviesModel.getSelectedMovie());
					if (res) {
						NotificationsManager.displayDeleteSuccessPopUp("Movie");
						SuperAdminController.loadMovies();
					}else {
						NotificationsManager.displayDeleteErrorPopUp("movie");
					}
				} else {
					NotificationsManager.displaySelectPopUp("movie");
				}
			}
		});
		
		bntNew = new WebButton(PropertyConstant.NEW, new ImageIcon(getClass().getResource("/images/create.png")));
		bntNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.showNewMovieFrame();
			}
		});
		
		btnPoster = new WebButton(PropertyConstant.COVER,new ImageIcon(getClass().getResource("/images/poster.png")));
				btnPoster.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {	
						if (table.getSelectedRow() >= 0) {
							MoviesModel.setSelectedMovie(table.getSelectedRow());
							image= Utils.convertToImage(MoviesModel.getSelectedMovie().getCover());
							SuperAdminController.showMovieCoverFrame(image);
						} else {
							NotificationsManager.displaySelectPopUp("movie");
						}
					}
				});
				btnPoster.setBottomBgColor(Color.YELLOW);
				btnPoster.setLocation(454, 100);
				btnPoster.setSize(118, 36);
				add(btnPoster);
		bntNew.setBounds(466, 221, 91, 26);
		add(bntNew);
		bntRemove.setBounds(466, 191, 91, 26);
		add(bntRemove);

		btnUpdate = new WebButton(PropertyConstant.UPDATE, new ImageIcon(getClass().getResource("/images/tool.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					MoviesModel.setSelectedMovie(table.getSelectedRow());
					SuperAdminController.showUpdateMovieFrame(MoviesModel.getSelectedMovie());
				} else {
					NotificationsManager.displaySelectPopUp("manager");
				}
			}
		});
		btnUpdate.setBounds(466, 159, 91, 26);
		add(btnUpdate);


		lblSelectedManagerContainer = new WebLabel();
		lblSelectedManagerContainer.setShadeColor(Color.DARK_GRAY);
		lblSelectedManagerContainer.setLocation(433, 90);
		lblSelectedManagerContainer.setSize(156, 206);
		lblSelectedManagerContainer.setPainter(new WebLabelPainter(new BorderPainter())).setMargin(10);
		add(lblSelectedManagerContainer);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 90, 403, 206);
		add(scrollPane);

		table = new JTable(new MoviesModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MoviesModel.setSelectedMovie(table.getSelectedRow());
				image = Utils.convertToImage(MoviesModel.getSelectedMovie().getCover());
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
				SuperAdminController.loadMovies(txtX.getText());
			}
		});
		btnSearch.setBounds(32, 16, 91, 26);
		add(btnSearch);

		btnReload = new WebButton(PropertyConstant.RELOAD, new ImageIcon(getClass().getResource("/images/reload.png")));
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperAdminController.loadMovies();
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
