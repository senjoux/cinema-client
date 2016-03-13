package com.tn.cinema.delegate;

import java.util.List;

import com.tn.cinema.entities.Movie;
import com.tn.cinema.services.MovieServiceRemote;
import com.tn.cinema.utility.ServiceLocator;

public class MovieServiceDelegate {

	private static final String jndi = "cinema-ejb/MovieService!com.tn.cinema.services.MovieServiceRemote";

	private static MovieServiceRemote getProxy() {
		return (MovieServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static boolean addMovie(Movie m) {
		return getProxy().addMovie(m);
	}

	public static Movie findMovieByID(Integer id) {
		return getProxy().findMovieByID(id);
	}

	public static boolean updateMovie(Movie m) {
		return getProxy().updateMovie(m);
	}

	public static boolean deleteMovie(Movie m) {
		return getProxy().deleteMovie(m);
	}

	public static List<Movie> findAllMovies() {
		return getProxy().findAllMovies();
	}
}
