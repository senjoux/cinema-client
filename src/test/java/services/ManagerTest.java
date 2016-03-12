package services;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.tn.cinema.delegate.ManagerServiceDelegate;
import com.tn.cinema.entities.Manager;

public class ManagerTest {

	@Test
	@Ignore
	public void addManager() {
		Manager m=new Manager();
		m.setFirstName("hassen");
		m.setName("hedhly");
		m.setEmail("x@x.com");
		m.setPassword("abc");	
		assertEquals(true, ManagerServiceDelegate.addManager(m));
	}
	
	@Test
	@Ignore
	public void findManagerByID(){
		assertEquals("hassen", ManagerServiceDelegate.findManagerByID(2).getFirstName());
	}
	
	@Test
	@Ignore
	public void updateManager(){
		Manager m=ManagerServiceDelegate.findManagerByID(2);
		m.setFirstName("hssouna");
		assertEquals(true, ManagerServiceDelegate.updateManager(m));
	}
	
	@Test
	@Ignore
	public void findAllManagers(){
		assertEquals(2,ManagerServiceDelegate.findAllManagers().size());
	}
	
	@Test
	@Ignore
	public void deleteManager(){
		Manager m=ManagerServiceDelegate.findManagerByID(3);
		assertEquals(true,ManagerServiceDelegate.deleteManager(m));
	}

	@Test
	@Ignore
	public void findManagerByEmail(){
		assertEquals("hssouna",ManagerServiceDelegate.findManagerByEmail("m@m.com").getFirstName());
	}

	@Test
	@Ignore
	public void findManagerByEmailAndPassword(){
		assertEquals("hssouna",ManagerServiceDelegate.findManagerByEmailAndPassword("m@m.com","abc").getFirstName());
	}
}
