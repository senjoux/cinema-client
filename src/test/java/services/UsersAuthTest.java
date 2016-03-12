package services;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.tn.cinema.delegate.UsersServiceDelegate;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.entities.Manager;

public class UsersAuthTest {

	@Test
	@Ignore
	public void authenticateUserAdmin() {
		assertEquals(Administrator.class,UsersServiceDelegate.authenticate("h@h.com", "esprit").getClass());
	}
	
	@Test
	@Ignore
	public void authenticateUserManager() {
		assertEquals(Manager.class,UsersServiceDelegate.authenticate("x@x.com", "abc").getClass());
	}
}
