package com.tn.cinema.delegate;

import java.util.Date;
import java.util.List;

import com.tn.cinema.entities.Movie;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.entities.Session;
import com.tn.cinema.entities.SessionID;
import com.tn.cinema.services.SessionServiceRemote;
import com.tn.cinema.utility.ServiceLocator;

public class SessionServiceDelegate {

	private static final String jndi = "cinema-ejb/SessionService!com.tn.cinema.services.SessionServiceRemote";
	
	public static SessionServiceRemote getProxy(){
		return (SessionServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public static boolean addSession(Session session){
		return getProxy().addSession(session);
	}
	
	public static Session findSessionByID(SessionID id){
		return getProxy().findSessionByID(id);
	}
	
	public static boolean updateSession(Session session){
		return getProxy().updateSession(session);
	}
	
	public static boolean deleteSession(Session session){
		return getProxy().deleteSession(session);
	}
	
	public static List<Session> findAllSessions(){
		return getProxy().findAllSessions();
	}
	
	public static List<Session> findAllSessionsByMovie(Movie movie){
		return getProxy().findAllSessionsByMovie(movie);
	}
	
	public static List<Session> findAllSessionsByMovieTheater(MovieTheater movieTheater){
		return getProxy().findAllSessionsByMovieTheater(movieTheater);
	}
	
	public static List<Session> findAllSessionsByDate(Date date){
		return getProxy().findAllSessionsByDate(date);
	}
	
}
