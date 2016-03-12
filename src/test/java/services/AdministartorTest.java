package services;

import static org.junit.Assert.*;


import org.junit.Ignore;
import org.junit.Test;

import com.tn.cinema.delegate.AdministratorServiceDelegate;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.entities.User;

public class AdministartorTest {

	
	@Test
	@Ignore
	public void addAdministrator() {
		Administrator a=new Administrator();
		a.setPassword("esprit");
		a.setName("hedhly");
		a.setFirstName("hamza");
		a.setEmail("h@h.com");
		assertEquals(true, AdministratorServiceDelegate.addAdministrator(a)); 
	}

	@Test
	@Ignore
	public void findAdministratorByID() {
		assertEquals("hedhly", AdministratorServiceDelegate.findAdministratorByID(1).getName()); 
	}
	
	@Test
	@Ignore
	public void updateAdministrator() {
		Administrator a=AdministratorServiceDelegate.findAdministratorByID(1);
		a.setName("elhedhly");
		assertEquals(true, AdministratorServiceDelegate.updateAdministrator(a)); 
	}
	
	@Test
	@Ignore
	public void findAllAdministrators(){
		assertEquals(2, AdministratorServiceDelegate.findAllAdministrators().size());
	}
	
	@Test
	@Ignore
	public void deleteAdministrator(){
		Administrator a=AdministratorServiceDelegate.findAdministratorByID(2);
		assertEquals(true,AdministratorServiceDelegate.deleteAdministrator(a));
	}
	
	@Test
	@Ignore
	public void findAdministratorByEmail(){
		Administrator a=AdministratorServiceDelegate.findAdministratorByID(1);
		assertEquals(a.getName(),AdministratorServiceDelegate.findAdministratorByEmail("h@h.com").getName());
	}
	
	@Test
	@Ignore
	public void findAdministratorByEmailAndPassword(){
		User a=AdministratorServiceDelegate.findAdministratorByEmailAndPassword("h@h.com", "esprit");
		System.out.println(a.getClass());
		assertEquals((Integer)1, a.getId());
	}
	
	
}
