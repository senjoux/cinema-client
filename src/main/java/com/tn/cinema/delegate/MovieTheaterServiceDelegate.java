package com.tn.cinema.delegate;

import java.util.List;

import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.services.MovieTheaterServiceRemote;
import com.tn.cinema.utility.ServiceLocator;

public class MovieTheaterServiceDelegate {

	public static final String jndi = "cinema-ejb/MovieTheaterService!com.tn.cinema.services.MovieTheaterServiceRemote";

	private static MovieTheaterServiceRemote getProxy() {
		return (MovieTheaterServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static boolean addMovieTheater(MovieTheater mt) {
		return getProxy().addMovieTheater(mt);
	}

	public static MovieTheater findMovieTheaterByID(Integer id) {
		return getProxy().findMovieTheaterByID(id);
	}

	public static boolean updateMovieTheater(MovieTheater mt) {
		return getProxy().updateMovieTheater(mt);
	}

	public static boolean deleteMovieTheater(MovieTheater mt){
		return getProxy().deleteMovieTheater(mt);
	}
	
	public static List<MovieTheater> getAllMovieTheaters(){
		return getProxy().getAllMovieTheaters();
	}
	
	public static List<MovieTheater> getMovieTheatersByManager(Manager m){
		return getProxy().getMovieTheatersByManager(m);
	}

	public static List<MovieTheater> getMovieTheatersByAddressLike(String address){
		return getProxy().getMovieTheatersByAddressLike(address);
	}
	
}
