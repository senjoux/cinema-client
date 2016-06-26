package services;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.tn.cinema.delegate.ManagerServiceDelegate;
import com.tn.cinema.delegate.MovieTheaterServiceDelegate;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities.MovieTheater;

public class MovieTheaterTest {

	@Test
	@Ignore
	public void addMovieTheater() {
		MovieTheater mt = new MovieTheater();
		Manager m = ManagerServiceDelegate.findManagerByID(13);
		mt.setManager(m);
		mt.setAdresse("bizerte, rue xx");
		mt.setName("CCC");
		mt.setCapacity(300L);
		assertEquals(true, MovieTheaterServiceDelegate.addMovieTheater(mt));
	}

	@Test
	@Ignore
	public void findMovieTheaterByID() {
		assertEquals(Long.valueOf(300), MovieTheaterServiceDelegate.findMovieTheaterByID(1).getCapacity());
	}

	@Test
	@Ignore
	public void updateMovieTheater() {
		MovieTheater mt = MovieTheaterServiceDelegate.findMovieTheaterByID(1);
		mt.setCapacity(325L);
		assertEquals(true, MovieTheaterServiceDelegate.updateMovieTheater(mt));
	}

	@Test
	@Ignore
	public void getAllMovieTheaters() {
		assertEquals(2, MovieTheaterServiceDelegate.getAllMovieTheaters().size());
	}

	@Test
	@Ignore
	public void getMovieTheatersByManager() {
		Manager m = ManagerServiceDelegate.findManagerByID(3);
		assertEquals(2, MovieTheaterServiceDelegate.getMovieTheatersByManager(m).size());
		// assertEquals(Long.valueOf(400),MovieTheaterServiceDelegate.getMovieTheatersByManager(m).get(0).getCapacity());
	}
	
	@Test
	@Ignore
	public void deleteMovieTheater() {
		MovieTheater mt = MovieTheaterServiceDelegate.findMovieTheaterByID(1);
		assertEquals(true,MovieTheaterServiceDelegate.deleteMovieTheater(mt));
	}
	
	@Test
	@Ignore
	public void getMovieTheatersByAddressLikeTest(){
		System.out.println(MovieTheaterServiceDelegate.getMovieTheatersByAddressLike("m").get(0).getAdresse());
	}
}
