package com.tn.cinema.delegate;

import java.util.List;

import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities._3DMovieTheater;
import com.tn.cinema.services._3DMovieTheaterServiceRemote;
import com.tn.cinema.utility.ServiceLocator;

public class _3DMovieTheaterServiceDelegate {

	private static final String jndi = "cinema-ejb/_3DMovieTheaterService!com.tn.cinema.services._3DMovieTheaterServiceRemote";

	private static _3DMovieTheaterServiceRemote getProxy() {
		return (_3DMovieTheaterServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	
	public static boolean add_3DMovieTheater(_3DMovieTheater mt){
		return getProxy().add_3DMovieTheater(mt);
	}
	
	public static _3DMovieTheater find_3DMovieTheaterByID(Integer id){
		return getProxy().find_3DMovieTheaterByID(id);
	}
	
	public static boolean update_3DMovieTheater(_3DMovieTheater mt){
		return getProxy().update_3DMovieTheater(mt);
	}
	
	public static boolean delete_3DMovieTheater(_3DMovieTheater mt){
		return getProxy().delete_3DMovieTheater(mt);
	}
	
	public static List<_3DMovieTheater> getAll_3DMovieTheaters(){
		return getProxy().getAll_3DMovieTheaters();
	}
	
	public static List<_3DMovieTheater> get_3DMovieTheatersByManager(Manager m){
		return getProxy().get_3DMovieTheatersByManager(m);
	}
}
