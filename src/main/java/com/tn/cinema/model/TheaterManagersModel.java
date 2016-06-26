package com.tn.cinema.model;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import com.tn.cinema.delegate.ManagerServiceDelegate;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.utility.Utils;

public class TheaterManagersModel extends AbstractTableModel {

	private static List<Manager> managers;
	private final String[] headers = { "First name", "Name", "Email"};
	private static Manager selectedManager;

	public TheaterManagersModel() {
		managers = Utils.fetchManagersAreLocked(ManagerServiceDelegate.findAllManagers(), false);
		fireTableDataChanged();
	}

	public TheaterManagersModel(String X) {
		managers = Utils.fetchManagersByCriteria(Utils.fetchManagersAreLocked(ManagerServiceDelegate.findAllManagers(), false), X);
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return managers.size();
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
			return managers.get(rowIndex).getFirstName();
		case 1:
			return managers.get(rowIndex).getName();
		case 2:
			return managers.get(rowIndex).getEmail();
		default:
			return null;
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public static Manager getSelectedManager() {
		return selectedManager;
	}

	public static void setSelectedManager(int rowIndex) {
		if (rowIndex >= 0 && rowIndex < managers.size()) {
			selectedManager = managers.get(rowIndex);
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
}
