package com.tn.cinema.model;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import com.tn.cinema.delegate.AdministratorServiceDelegate;
import com.tn.cinema.entities.Administrator;

public class AdministratorsModel extends AbstractTableModel {

	private static List<Administrator> administrators;
	private final String[] headers = { "First name", "Name", "Email", "Phone", "Locked" };
	private static Administrator selectedAdministrator;

	public AdministratorsModel() {
		administrators = AdministratorServiceDelegate.findAllAdministrators();
		System.out.println(administrators.size() + " administartors");

	}

	@Override
	public int getRowCount() {
		return administrators.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	public String getColumnName(int columnIndex) {
		return headers[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return administrators.get(rowIndex).getFirstName();
		case 1:
			return administrators.get(rowIndex).getName();
		case 2:
			return administrators.get(rowIndex).getEmail();
		case 3:
			return administrators.get(rowIndex).getMobilePhone().toString();
		case 4:
			return administrators.get(rowIndex).isLocked()
					? new ImageIcon(getClass().getResource("/images/tiny_on.png"))
					: new ImageIcon(getClass().getResource("/images/tiny_off.png"));
		default:
			return null;
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public static Administrator getSelectedAdministrator() {
		return selectedAdministrator;
	}

	public static void setSelectedAdministrator(int rowIndex) {
		if (rowIndex >= 0 && rowIndex < administrators.size()) {
			selectedAdministrator = administrators.get(rowIndex);
		}
	}

}
