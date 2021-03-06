package com.tn.cinema.controller;

import java.io.File;

import com.tn.cinema.delegate.ManagerServiceDelegate;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.gui.NewManagerFrame;
import com.tn.cinema.gui.NewMovieTheaterFrame;
import com.tn.cinema.utility.Utils;

public class ManagerController {

	private static NewManagerFrame newManagerFrame;
	private static NewMovieTheaterFrame newMovieTheaterFrame;
	
	public ManagerController() {
	
	}
	
	// ******************* navigation *******************************
	public static void showNewManagerFrame() {
		if (newManagerFrame == null) {
			newManagerFrame = new NewManagerFrame();
			newManagerFrame.setVisible(true);
		} else {
			newManagerFrame.setVisible(true);
		}
	}
	
	public static void disposeNewManagerFrame() {
		newManagerFrame.dispose();
	}
	
	// **********************new manager
		// ************************************************

		//to delete later ...
		public static boolean insertManager(String firstName, String name, String email, String password, String phone,
				File profileImg) {
			Manager m = new Manager();
			m.setFirstName(firstName);
			m.setName(name);
			m.setEmail(email);
			m.setPassword(password);
			m.setMobilePhone(Long.parseLong(phone));
			m.setImage(Utils.convertToBytes(profileImg));
			return ManagerServiceDelegate.addManager(m);
		}
		
		public static Manager prepareManager(String firstName, String name, String email, String password, String phone,
				File profileImg) {
			Manager m = new Manager();
			m.setFirstName(firstName);
			m.setName(name);
			m.setEmail(email);
			m.setPassword(password);
			m.setMobilePhone(Long.parseLong(phone));
			m.setImage(Utils.convertToBytes(profileImg));
			return m;
		}
		
		
		
}
