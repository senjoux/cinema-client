package com.tn.cinema.gui.superAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.tabbedpane.WebTabbedPane;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.gui.ConnectedAdminDetailsPanel;
import com.tn.cinema.gui.xPanl;

public class AdministratorFrame extends JFrame {

	private WebPanel contentPane;

	static WebTabbedPane menuTPane;
	ConnectedAdminDetailsPanel userDetailsPanel;
	JLabel lblAdmins;
	JLabel lblManagers;
	JLabel lblMovies;
	JLabel lblTheaters;
	// JLabel lblSessions;
	JLabel lblStats;


	/**
	 * Create the frame.
	 */
	public AdministratorFrame(Administrator a) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(PropertyConstant.MALLA_CINEMA);
		setBounds(100, 100, 795, 549);
		ImageIcon frameIcon=new ImageIcon(getClass().getResource("/images/bobines-video-icon.png"));
		this.setIconImage(frameIcon.getImage());
		this.setResizable(false);
		contentPane = new WebPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// userDetailsPane
		userDetailsPanel = new ConnectedAdminDetailsPanel(a);
		userDetailsPanel.setBounds(5, 5, 777, 111);
		userDetailsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		contentPane.add(userDetailsPanel);
		// tabbedPanes
		menuTPane = new WebTabbedPane();
		menuTPane.setBounds(5, 127, 777, 384);
		menuTPane.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		menuTPane.setPreferredSize(new Dimension(170, 120));
		menuTPane.setTabPlacement(WebTabbedPane.LEFT);
		setupTabbedPane(menuTPane, a.isSuper());

		// admins pane
		if (a.isSuper()) {
			lblAdmins = new JLabel("Administrators");
			lblAdmins.setIcon(new ImageIcon(getClass().getResource("/images/admins.png")));
			lblAdmins.setPreferredSize(new Dimension(140, 58));
			menuTPane.setTabComponentAt(0, lblAdmins); // tab index, jLabel
			
			// managers pane
			lblManagers = new JLabel("Managers");
			lblManagers.setIcon(new ImageIcon(getClass().getResource("/images/managers.png")));
			lblManagers.setPreferredSize(new Dimension(140, 53));
			menuTPane.setTabComponentAt(1, lblManagers);

			// movies pane
			lblMovies = new JLabel("Movies");
			lblMovies.setIcon(new ImageIcon(getClass().getResource("/images/movies.png")));
			lblMovies.setPreferredSize(new Dimension(140, 55));
			menuTPane.setTabComponentAt(2, lblMovies);

			// movie theaters pane
			lblTheaters = new JLabel("Movie Theaters");
			lblTheaters.setIcon(new ImageIcon(getClass().getResource("/images/theaters.png")));
			lblTheaters.setPreferredSize(new Dimension(140, 53));
			menuTPane.setTabComponentAt(3, lblTheaters);

			// lblStats stats pane
			lblStats = new JLabel("Stats");
			lblStats.setIcon(new ImageIcon(getClass().getResource("/images/stats.png")));
			lblStats.setPreferredSize(new Dimension(140, 53));
			menuTPane.setTabComponentAt(4, lblStats);
		}else{
			// managers pane
			lblManagers = new JLabel("Managers");
			lblManagers.setIcon(new ImageIcon(getClass().getResource("/images/managers.png")));
			lblManagers.setPreferredSize(new Dimension(140, 53));
			menuTPane.setTabComponentAt(0, lblManagers);

			// movies pane
			lblMovies = new JLabel("Movies");
			lblMovies.setIcon(new ImageIcon(getClass().getResource("/images/movies.png")));
			lblMovies.setPreferredSize(new Dimension(140, 55));
			menuTPane.setTabComponentAt(1, lblMovies);

			// movie theaters pane
			lblTheaters = new JLabel("Movie Theaters");
			lblTheaters.setIcon(new ImageIcon(getClass().getResource("/images/theaters.png")));
			lblTheaters.setPreferredSize(new Dimension(140, 53));
			menuTPane.setTabComponentAt(2, lblTheaters);

			// lblStats stats pane
			lblStats = new JLabel("Stats");
			lblStats.setIcon(new ImageIcon(getClass().getResource("/images/stats.png")));
			lblStats.setPreferredSize(new Dimension(140, 53));
			menuTPane.setTabComponentAt(3, lblStats);
		}

		

		// sessions pane
		/*
		 * lblSessions = new JLabel("Movies Sessions "); lblSessions.setIcon(new
		 * ImageIcon(getClass().getResource("/images/sessions.png")));
		 * lblSessions.setPreferredSize(new Dimension(140, 53));
		 * menuTPane.setTabComponentAt(4, lblSessions);
		 */

		contentPane.add(menuTPane);
	}

	private static void setupTabbedPane(JTabbedPane tabbedPane, boolean isSuperAdmin) {
		if (isSuperAdmin) {
			tabbedPane.addTab("Administrators", new AdministratorsPanel());
			tabbedPane.addTab("Managers", new ManagersPanel());
			tabbedPane.addTab("Movies", new MoviesPanel());
			tabbedPane.addTab("MTH", new MovieTheatersPanel());
			tabbedPane.setSelectedIndex(2);
			tabbedPane.addTab("Normal 5", new xPanl());
		} else {
			tabbedPane.addTab("Managers", new ManagersPanel());
			tabbedPane.addTab("Movies", new MoviesPanel());
			tabbedPane.addTab("MTH", new MovieTheatersPanel());
			tabbedPane.setSelectedIndex(2);
			tabbedPane.addTab("Normal 5", new xPanl());
		}
	}

	public static AdministratorsPanel getAdminsPanel() {
		return (AdministratorsPanel) menuTPane.getComponent(0);
	}

	public static ManagersPanel getManagersPanel() {
		return (ManagersPanel) menuTPane.getComponent(1);
	}

	public static MoviesPanel getMoviesPanel() {
		return (MoviesPanel) menuTPane.getComponent(2);
	}

	public static MovieTheatersPanel getMovieTheatersPanel() {
		return (MovieTheatersPanel) menuTPane.getComponent(3);
	}
}
