package utility;

import static org.junit.Assert.assertEquals;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Ignore;
import org.junit.Test;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class UtilityTest {

	//apache commons validator
	@Test
	@Ignore
	public void emailValidation_1() {
		String email = "x@dx.com";
		boolean valid = EmailValidator.getInstance().isValid(email);
		assertEquals(true, valid);
	}
	
	//mail api validator
	@Test
	@Ignore
	public void emailValidation_2() {
		assertEquals(true, validate("a@ea.com"));
	}
	

	private boolean validate(String email) {
		boolean isValid = false;
		try {
			
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			isValid = true;
		} catch (AddressException e) {
			System.out.println("invalide email " + email);
		}
		return isValid;
	}
	
	
	// my api key =  AIzaSyBNrMWXINCTgvQuygjhIZ4bydgJWhN5eLA 
	@Test
	public void geocodingAPITest(){
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBNrMWXINCTgvQuygjhIZ4bydgJWhN5eLA");
		GeocodingResult[] results=null;
		try {
			results = GeocodingApi.geocode(context,"Rue Jules Ferry, Bizerte").await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(results[0].formattedAddress);
		//System.out.println(results.length);
		
		/*
		for later use, i ll work with  GeocodingResult to get the "placeId" so that i can display in web site using google map 
		GeocodingResult x=new GeocodingResult();
		*/

	}

}
