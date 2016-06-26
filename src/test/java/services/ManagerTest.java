package services;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

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
		m.setEmail("s@s.com");
		m.setPassword("esprit");
		m.setMobilePhone(55539159L);
		m.setImage(convertToBytes(loadFile("defaultUser.png")));
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
	public void deleteManager(){
		Manager m=ManagerServiceDelegate.findManagerByID(13);
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
