package services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import com.tn.cinema.delegate.MovieServiceDelegate;
import com.tn.cinema.delegate.MovieTheaterServiceDelegate;
import com.tn.cinema.delegate.SessionServiceDelegate;
import com.tn.cinema.entities.Movie;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.entities.Session;
import com.tn.cinema.entities.SessionID;

public class SessionTest {

	@Test
	@Ignore
	public void addSession() {
		Movie m = MovieServiceDelegate.findMovieByID(4);
		MovieTheater t = MovieTheaterServiceDelegate.findMovieTheaterByID(4);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String ch = "15/03/2016";
		Date date = null;
		try {

			date = formatter.parse(ch);
			//System.out.println(date);
			// System.out.println(formatter.format(date));

		} catch (ParseException e) {e.printStackTrace();}

		Session s = new Session(260L, m, t, 14L, date);
		assertEquals(true,SessionServiceDelegate.addSession(s));
		
	}

	@Test
	@Ignore
	public void findSessionByID() {
		Movie m = MovieServiceDelegate.findMovieByID(1);
		MovieTheater t = MovieTheaterServiceDelegate.findMovieTheaterByID(1);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String ch = "15/03/2016";
		Date date = null;
		try { date = formatter.parse(ch); } catch (ParseException e) {e.printStackTrace();}
	
		SessionID id=new SessionID();
		id.setDate(date);
		id.setMovieID(m.getId());
		id.setTheaterID(t.getId());
		id.setStartTime(16L);
		
		assertEquals(Long.valueOf(300),SessionServiceDelegate.findSessionByID(id).getNbrSpectators());
	}
	
	@Test
	@Ignore
	public void updateSession() {
		Movie m = MovieServiceDelegate.findMovieByID(1);
		MovieTheater t = MovieTheaterServiceDelegate.findMovieTheaterByID(1);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String ch = "15/03/2016";
		Date date = null;
		try {date = formatter.parse(ch); } catch (ParseException e) {e.printStackTrace();}
		
		SessionID id=new SessionID();
		id.setDate(date);
		id.setMovieID(m.getId());
		id.setTheaterID(t.getId());
		id.setStartTime(16L);
		Session s=SessionServiceDelegate.findSessionByID(id);
		s.setNbrSpectators(260L);
		assertEquals(true,SessionServiceDelegate.updateSession(s));
	}
	
	@Test
	@Ignore
	public void findAllSessions(){
		assertEquals(2,SessionServiceDelegate.findAllSessions().size());
	}
	
	@Test
	@Ignore
	public void findAllSessionsByMovie(){
		assertEquals(2,SessionServiceDelegate.findAllSessionsByMovie(MovieServiceDelegate.findMovieByID(1)).size());
	}
	
	@Test
	@Ignore
	public void findAllSessionsByMovieTheater(){
		assertEquals(1,SessionServiceDelegate.findAllSessionsByMovieTheater(MovieTheaterServiceDelegate.findMovieTheaterByID(2)).size());
	}
	
	@Test
	@Ignore
	public void findAllSessionsByDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String ch = "15/03/2016";
		Date date = null;
		try { date = formatter.parse(ch); } catch (ParseException e) {e.printStackTrace();}
		assertEquals(3,SessionServiceDelegate.findAllSessionsByDate(date).size());
	}
	
	@Test
	@Ignore
	public void deleteSession() {
		Movie m = MovieServiceDelegate.findMovieByID(4);
		MovieTheater t = MovieTheaterServiceDelegate.findMovieTheaterByID(4);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String ch = "15/03/2016";
		Date date = null;
		try {date = formatter.parse(ch); } catch (ParseException e) {e.printStackTrace();}
		
		SessionID id=new SessionID();
		id.setDate(date);
		id.setMovieID(m.getId());
		id.setTheaterID(t.getId());
		id.setStartTime(14L);
		Session s=SessionServiceDelegate.findSessionByID(id);
		
		assertEquals(true,SessionServiceDelegate.deleteSession(s));
	}
	
	
}
