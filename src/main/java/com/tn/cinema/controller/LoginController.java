package com.tn.cinema.controller;

import org.apache.commons.validator.routines.EmailValidator;

import com.alee.managers.notification.NotificationIcon;
import com.alee.managers.notification.NotificationManager;
import com.alee.managers.notification.WebNotificationPopup;
import com.tn.cinema.delegate.UsersServiceDelegate;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.entities.User;
import com.tn.cinema.gui.LoginFrame;

public class LoginController {

	public LoginFrame loginFrame;
	
	public void startTheApp(){
		loginFrame=new LoginFrame();
		loginFrame.setVisible(true);
	}
	
	public static boolean validateEmail(String email){
		return EmailValidator.getInstance().isValid(email);
	}
	
	public static User checkCredits(String email,String password){
		return UsersServiceDelegate.authenticate(email, password);
	}
	
	public static void loginDispatcher(String email,String password){
		User u=checkCredits(email, password);
		if (u==null) {
			displayWrongCreditsPopUp();
		} else {
			if (u.getClass()==Administrator.class) {
				System.out.println("admin");
			} else{
				System.out.println("manager");
			}
		}
	}
	
	public static void displayWrongCreditsPopUp(){
		WebNotificationPopup notificationPopup = new WebNotificationPopup ();
        notificationPopup.setIcon( NotificationIcon.error);
        notificationPopup.setContent("Something wrong, please verify the email & password ");
        notificationPopup.setSize(120, 120);
        notificationPopup.setDisplayTime ( 4000 );
		NotificationManager.showNotification(notificationPopup);
	}
	
	
	
}
