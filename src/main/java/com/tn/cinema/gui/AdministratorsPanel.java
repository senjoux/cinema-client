package com.tn.cinema.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.alee.extended.image.WebDecoratedImage;
import com.alee.extended.painter.BorderPainter;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebTextField;
import com.alee.managers.style.skin.web.WebLabelPainter;
import com.tn.cinema.constant.PropertyConstant;
import com.tn.cinema.model.AdministratorsModel;
import com.tn.cinema.utility.Utils;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class AdministratorsPanel extends JPanel {

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
	private WebLabel lblUtilityContainer;
	
	@SuppressWarnings("rawtypes")
	public AdministratorsPanel() {
		setBounds(10, 11, 600, 384);
		setLayout(null);
		
		bntRemove = new WebButton(PropertyConstant.DELETE,new ImageIcon(getClass().getResource("/images/deleteuser.png")));
		bntRemove.setBounds(466, 243, 91, 26);
		add(bntRemove);
		
		btnUpdate = new WebButton(PropertyConstant.UPDATE,new ImageIcon(getClass().getResource("/images/tool.png")));
		btnUpdate.setBounds(466, 213, 91, 26);
		add(btnUpdate);
		
		ImageIcon defaultUserIcon = new ImageIcon(getClass().getResource("/images/defaultUser.png"));
		profileImg= new WebDecoratedImage ( defaultUserIcon );
		profileImg.setBorderColor(Color.BLACK);
		profileImg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		profileImg.setShadeWidth(5);
		profileImg.setBounds(456, 102, 111, 105);
		add(profileImg);
		
		lblSelectedAdminContainer = new WebLabel ();
		lblSelectedAdminContainer.setShadeColor(Color.DARK_GRAY);
		lblSelectedAdminContainer.setLocation(433, 90);
		lblSelectedAdminContainer.setSize(156, 206);
		lblSelectedAdminContainer.setPainter ( new WebLabelPainter ( new BorderPainter () ) ).setMargin ( 10 );
		add(lblSelectedAdminContainer);
		
		scrollPane=new JScrollPane();
		scrollPane.setBounds(20, 90, 403, 206);
		add(scrollPane);
		
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
		txtEmail.setBounds(128, 16, 128, 26);
		txtEmail.setInputPrompt("email, name ...");
		txtEmail.setInputPromptFont(txtEmail.getFont().deriveFont(Font.ITALIC));
		add(txtEmail);
		txtEmail.setColumns(10);
		
		btnSearch = new WebButton(PropertyConstant.SEARCH,new ImageIcon(getClass().getResource("/images/search-icon.png")));
		btnSearch.setBounds(32, 16, 91, 26);
		add(btnSearch);
		
		btnReload = new WebButton(PropertyConstant.RELOAD,new ImageIcon(getClass().getResource("/images/reload.png")));
		btnReload.setBounds(32, 53, 91, 26);
		add(btnReload);
		
		bntNew = new WebButton(PropertyConstant.NEW,new ImageIcon(getClass().getResource("/images/newuser.png")));
		bntNew.setBounds(320, 53, 91, 26);
		add(bntNew);
		
		lblUtilityContainer= new WebLabel ();
		lblUtilityContainer.setLocation(20, 11);
		lblUtilityContainer.setSize(403, 73);
		lblUtilityContainer.setPainter ( new WebLabelPainter ( new BorderPainter () ) ).setMargin ( 10 );
		add(lblUtilityContainer);
		
	}

}
