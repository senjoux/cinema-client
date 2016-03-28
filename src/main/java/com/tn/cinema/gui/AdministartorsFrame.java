package com.tn.cinema.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.alee.extended.image.WebDecoratedImage;
import com.alee.extended.painter.BorderPainter;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebTextField;
import com.alee.managers.style.skin.web.WebLabelPainter;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.model.AdministratorsModel;
import com.tn.cinema.utility.Utils;

public class AdministartorsFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private WebTextField txtEmail;
	private WebButton btnSearch;
	private WebButton btnReload;
	private WebDecoratedImage profileImg;
	private WebButton btnUpdate;
	private WebButton bntRemove; 
	private WebButton bntNew;
	private WebLabel lblSelectedAdminContainer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				WebLookAndFeel.install ();
				try {
					AdministartorsFrame frame = new AdministartorsFrame();
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
	@SuppressWarnings({ "serial", "rawtypes" })
	public AdministartorsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel administartorsPanel = new JPanel();
		administartorsPanel.setBounds(10, 11, 611, 286);
		contentPane.add(administartorsPanel);
		administartorsPanel.setLayout(null);
		
		bntRemove = new WebButton(PropertyConstant.DELETE,new ImageIcon(getClass().getResource("/images/deleteuser.png")));
		bntRemove.setBounds(462, 224, 91, 23);
		administartorsPanel.add(bntRemove);
		
		btnUpdate = new WebButton(PropertyConstant.UPDATE,new ImageIcon(getClass().getResource("/images/tool.png")));
		btnUpdate.setBounds(462, 190, 91, 23);
		administartorsPanel.add(btnUpdate);
		
		ImageIcon defaultUserIcon = new ImageIcon(getClass().getResource("/images/defaultUser.png"));
		profileImg= new WebDecoratedImage ( defaultUserIcon );
		profileImg.setShadeWidth(5);
		profileImg.setBounds(462, 86, 104, 96);
		administartorsPanel.add(profileImg);
		
		lblSelectedAdminContainer = new WebLabel ();
		lblSelectedAdminContainer.setLocation(423, 73);
		lblSelectedAdminContainer.setSize(176, 187);
		lblSelectedAdminContainer.setPainter ( new WebLabelPainter ( new BorderPainter () ) ).setMargin ( 10 );
		administartorsPanel.add(lblSelectedAdminContainer);
		
		scrollPane=new JScrollPane();
		scrollPane.setBounds(10, 73, 403, 187);
		administartorsPanel.add(scrollPane);
		
		table = new JTable(new AdministratorsModel()){
            @SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			private BufferedImage image=null; 
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdministratorsModel.setSelectedAdministrator(table.getSelectedRow());
				System.out.println(AdministratorsModel.getSelectedAdministrator().getFirstName());
				image=Utils.convertToImage(AdministratorsModel.getSelectedAdministrator().getImage());
				profileImg.setImage(image.getScaledInstance(121, 117, Image.SCALE_DEFAULT));
			}
		});
		scrollPane.setViewportView(table);
		
		txtEmail = new WebTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setBounds(111, 11, 128, 21);
		txtEmail.setInputPrompt("email, name ...");
		txtEmail.setInputPromptFont(txtEmail.getFont().deriveFont(Font.ITALIC));
		administartorsPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		btnSearch = new WebButton(PropertyConstant.SEARCH,new ImageIcon(getClass().getResource("/images/search-icon.png")));
		btnSearch.setBounds(10, 11, 91, 23);
		administartorsPanel.add(btnSearch);
		
		btnReload = new WebButton(PropertyConstant.RELOAD,new ImageIcon(getClass().getResource("/images/reload.png")));
		btnReload.setBounds(10, 39, 91, 23);
		administartorsPanel.add(btnReload);
		
		bntNew = new WebButton(PropertyConstant.NEW,new ImageIcon(getClass().getResource("/images/newuser.png")));
		bntNew.setBounds(322, 39, 91, 23);
		administartorsPanel.add(bntNew);
		
	}
}
