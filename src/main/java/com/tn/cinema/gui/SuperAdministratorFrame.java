package com.tn.cinema.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.tabbedpane.WebTabbedPane;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;

public class SuperAdministratorFrame extends JFrame {

	private WebPanel contentPane;

	WebTabbedPane menuTPane;
	JPanel userDetailsPanel;
	JLabel lblAdmins;
	JLabel lblManagers;
	JLabel lblMovies;
	JLabel lblTheaters;
	JLabel lblSessions;
	JLabel lblStats;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				WebLookAndFeel.install ();
				try {
					SuperAdministratorFrame frame = new SuperAdministratorFrame();
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
	public SuperAdministratorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 516);
		contentPane = new WebPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// userDetailsPane
		userDetailsPanel = new JPanel();
		userDetailsPanel.setBounds(5, 5, 777, 93);
		userDetailsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		contentPane.add(userDetailsPanel);
		// tabbedPanes
		menuTPane = new WebTabbedPane();
		menuTPane.setBounds(5, 103, 777, 383);
		menuTPane.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		menuTPane.setPreferredSize(new Dimension(170, 120));
		menuTPane.setTabPlacement(WebTabbedPane.LEFT);
		setupTabbedPane(menuTPane);
		
		// admins pane
		lblAdmins = new JLabel("Administrators");
		lblAdmins.setIcon(new ImageIcon(getClass().getResource("/images/admins.png")));
		lblAdmins.setPreferredSize(new Dimension(140, 53));
		menuTPane.setTabComponentAt(0, lblAdmins); // tab index, jLabel

		// managers pane
		lblManagers = new JLabel("Managers");
		lblManagers.setIcon(new ImageIcon(getClass().getResource("/images/managers.png")));
		lblManagers.setPreferredSize(new Dimension(140, 53));
		menuTPane.setTabComponentAt(1, lblManagers);

		// movies pane
		lblMovies = new JLabel("Movies");
		lblMovies.setIcon(new ImageIcon(getClass().getResource("/images/movies.png")));
		lblMovies.setPreferredSize(new Dimension(140, 53));
		menuTPane.setTabComponentAt(2, lblMovies);

		// movie theaters pane
		lblTheaters = new JLabel("Movie Theaters");
		lblTheaters.setIcon(new ImageIcon(getClass().getResource("/images/theaters.png")));
		lblTheaters.setPreferredSize(new Dimension(140, 53));
		menuTPane.setTabComponentAt(3, lblTheaters);
		
		//sessions pane
		lblSessions = new JLabel("Movies Sessions ");
		lblSessions.setIcon(new ImageIcon(getClass().getResource("/images/sessions.png")));
		lblSessions.setPreferredSize(new Dimension(140, 53));
        menuTPane.setTabComponentAt(4, lblSessions);
        //lblStats stats pane
        lblStats = new JLabel("Stats");
        lblStats.setIcon(new ImageIcon(getClass().getResource("/images/stats.png")));
        lblStats.setPreferredSize(new Dimension(140, 53));
        menuTPane.setTabComponentAt(5, lblStats);
        
		contentPane.add(menuTPane);

	}

	private static void setupTabbedPane(JTabbedPane tabbedPane) {
		// AdministratorsPanel administratorsPanel = new AdministratorsPanel();
		tabbedPane.addTab("Normal 1", new AdministratorsPanel());
		// tabbedPane.addTab ( "Normal 1", new WebLabel () );
		// tabbedPane.addTab ( "Disabled 2", new WebLabel () );
		// tabbedPane.setEnabledAt ( 1, false );
		tabbedPane.addTab("Disabled 2", new xPanl());
		tabbedPane.addTab("Selected 3", new WebLabel());
		tabbedPane.setSelectedIndex(2);

		tabbedPane.addTab("Colored 4", new WebLabel());
		tabbedPane.setBackgroundAt(3, new Color(255, 212, 161));
		tabbedPane.addTab("Normal 4", new xPanl());
		tabbedPane.addTab("Normal 5", new xPanl());
		
	}
}
