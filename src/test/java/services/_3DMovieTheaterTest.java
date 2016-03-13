package services;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.tn.cinema.delegate.ManagerServiceDelegate;
import com.tn.cinema.delegate.MovieTheaterServiceDelegate;
import com.tn.cinema.delegate._3DMovieTheaterServiceDelegate;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities._3DMovieTheater;

public class _3DMovieTheaterTest {

	@Test
	@Ignore
	public void add_3DMovieTheater() {
		_3DMovieTheater mt = new _3DMovieTheater();
		Manager m = ManagerServiceDelegate.findManagerByID(2);
		mt.setManager(m);
		mt.setAdresse("AAA, aa");
		mt.setName("mmm");
		mt.setCapacity(10L);
		assertEquals(true, _3DMovieTheaterServiceDelegate.add_3DMovieTheater(mt));
	}

	@Test
	@Ignore
	public void find_3DMovieTheaterByID() {
		assertEquals(Long.valueOf(500),  _3DMovieTheaterServiceDelegate.find_3DMovieTheaterByID(4).getCapacity());
	}
	
	@Test
	@Ignore
	public void update_3DMovieTheater() {
		_3DMovieTheater mt = _3DMovieTheaterServiceDelegate.find_3DMovieTheaterByID(4);
		mt.setCapacity(450L);
		assertEquals(true, MovieTheaterServiceDelegate.updateMovieTheater(mt));
	}
	
	@Test
	@Ignore
	public void getAll_3DMovieTheaters() {
		assertEquals(2, _3DMovieTheaterServiceDelegate.getAll_3DMovieTheaters().size());
	}
	
	@Test
	@Ignore
	public void get_3DMovieTheatersByManager() {
		Manager m = ManagerServiceDelegate.findManagerByID(2);
		//System.out.println(_3DMovieTheaterServiceDelegate.get_3DMovieTheatersByManager(m).size());
		assertEquals(Long.valueOf(10),_3DMovieTheaterServiceDelegate.get_3DMovieTheatersByManager(m).get(0).getCapacity());
	}
	
	@Test
	@Ignore
	public void delete_3DMovieTheater() {
		add_3DMovieTheater();
		_3DMovieTheater mt = _3DMovieTheaterServiceDelegate.find_3DMovieTheaterByID(6);
		assertEquals(true,_3DMovieTheaterServiceDelegate.delete_3DMovieTheater(mt));
	}
}
