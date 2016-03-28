package services;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

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
		a.setFirstName("foulen");
		a.setEmail("f@f.com");
		a.setMobilePhone(12345678L);
		a.setImage(convertToBytes(loadFile("defaultUser.png")));
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
		//a.setLocked(false);
		a.setImage(convertToBytes(loadFile("hamza.jpg")));
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
	
	public File loadFile(String path){
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(path).getFile());
	}
	
	public byte[] convertToBytes(File file){
		 byte[] bFile = new byte[(int) file.length()];
	        
	        try {
		     FileInputStream fileInputStream = new FileInputStream(file);
		     //convert file into array of bytes
		     fileInputStream.read(bFile);
		     fileInputStream.close();
	        } catch (Exception e) {
		     e.printStackTrace();
	        }
	     return bFile;   
	}
	
}
