package com.tn.cinema.controller;


import com.tn.cinema.delegate.UsersServiceDelegate;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.entities.User;
import com.tn.cinema.gui.LoginFrame;
import com.tn.cinema.utility.NotificationsManager;

public class MainController {

	private static LoginFrame loginFrame;
	private static SuperAdminController sAdminController;
	private static ManagerController managerController;

	public static void startTheApp() {
		loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
	}


	public static User checkCredits(String email, String password) {
		return UsersServiceDelegate.authenticate(email, password);
	}

	public static void loginDispatcher(String email, String password) {
		User u = checkCredits(email, password);
		if (u == null) {
			NotificationsManager.displayWrongCreditsPopUp();
		} else {
			if (!u.isLocked()) {
				NotificationsManager.displayAccountLockedPopUp();
			} else {
				if (u.getClass() == Administrator.class) {
					System.out.println("admin");
					if (((Administrator) u).isSuper()) {
						loginFrame.dispose();
						sAdminController = new SuperAdminController();
					} else {
						System.out.println("admin --not--> super");
					}

				} else {
					System.out.println("manager ");
				}

			}
		}
	}

	

}
