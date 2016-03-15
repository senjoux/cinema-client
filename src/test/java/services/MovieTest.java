package services;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.tn.cinema.delegate.MovieServiceDelegate;
import com.tn.cinema.entities.Movie;

public class MovieTest {

	@Test
	@Ignore
	public void addMovie() {
		Movie m=new Movie();
		m.setTitle("x-men");
		m.setLength(120L);
		m.setType("action, thriller");
		assertEquals(true,MovieServiceDelegate.addMovie(m));
	}
	
	@Test
	@Ignore
	public void findMovieByID() {
		assertEquals("LOTR", MovieServiceDelegate.findMovieByID(1).getTitle());
	}
	
	@Test
	@Ignore
	public void updateMovie() {
		Movie m=MovieServiceDelegate.findMovieByID(1);
		m.setLength(228L);
		assertEquals(true, MovieServiceDelegate.updateMovie(m));
	}

	@Test
	@Ignore
	public void findAllMovies() {
		assertEquals(2, MovieServiceDelegate.findAllMovies().size());
	}

	@Test
	@Ignore
	public void deleteMovie() {
		Movie m=MovieServiceDelegate.findMovieByID(2);
		assertEquals(true, MovieServiceDelegate.deleteMovie(m));
	}

	
}
