package com.tn.cinema.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.tn.cinema.delegate.MovieTheaterServiceDelegate;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.entities._3DMovieTheater;
import com.tn.cinema.utility.Utils;

public class MovieTheatersModel extends AbstractTableModel {
	private static List<MovieTheater> theaters;
	private final String[] headers = { "Name", "Address", "Capacity", "Phone", "P-Type" };
	private static MovieTheater selectedMovieTheater;

	public MovieTheatersModel() {
		theaters = MovieTheaterServiceDelegate.getAllMovieTheaters();
		fireTableDataChanged();
	}

	public MovieTheatersModel(String X) {
		theaters = Utils.fetchMovieTheatersByCriteria(MovieTheaterServiceDelegate.getAllMovieTheaters(), X);
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return theaters.size();
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
			return theaters.get(rowIndex).getName();
		case 1:
			return theaters.get(rowIndex).getAdresse();
		case 2:
			return theaters.get(rowIndex).getCapacity().toString();
		case 3:
			return theaters.get(rowIndex).getTelephone().toString();
		case 4:
			return theaters.get(rowIndex).getClass().equals(_3DMovieTheater.class)
					? ((_3DMovieTheater) theaters.get(rowIndex)).getProjectionType() : "-";
		default:
			return null;
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public static MovieTheater getSelectedMovieTheater() {
		return selectedMovieTheater;
	}

	public static void setSelectedMovieTheater(int rowIndex) {
		if (rowIndex >= 0 && rowIndex < theaters.size()) {
			selectedMovieTheater = theaters.get(rowIndex);
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

}
