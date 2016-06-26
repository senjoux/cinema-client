package com.tn.cinema.model;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import com.tn.cinema.delegate.MovieServiceDelegate;
import com.tn.cinema.entities.Movie;
import com.tn.cinema.utility.Utils;

public class MoviesModel extends AbstractTableModel {
	private static List<Movie> movies;
	private final String[] headers = { "Title", "Length", "Type", "Approved" };
	private static Movie selectedMovie;

	public MoviesModel() {
		movies = MovieServiceDelegate.findAllMovies();
		fireTableDataChanged();
	}

	public MoviesModel(String X) {
		movies = Utils.fetchMoviesByCriteria(MovieServiceDelegate.findAllMovies(), X);
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return movies.size();
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
			return movies.get(rowIndex).getTitle();
		case 1:
			return movies.get(rowIndex).getLength();
		case 2:
			return movies.get(rowIndex).getType();
		case 3:
			return movies.get(rowIndex).isApproved() ? new ImageIcon(getClass().getResource("/images/tiny_on.png"))
					: new ImageIcon(getClass().getResource("/images/tiny_off.png"));
		default:
			return null;
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public static Movie getSelectedMovie() {
		return selectedMovie;
	}

	public static void setSelectedMovie(int rowIndex) {
		if (rowIndex >= 0 && rowIndex < movies.size()) {
			selectedMovie = movies.get(rowIndex);
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

}
