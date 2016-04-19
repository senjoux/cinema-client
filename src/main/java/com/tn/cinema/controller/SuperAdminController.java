package com.tn.cinema.controller;

import java.io.File;

import com.tn.cinema.delegate.AdministratorServiceDelegate;
import com.tn.cinema.delegate.ManagerServiceDelegate;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.gui.NewAdminFrame;
import com.tn.cinema.gui.UpdateAdminFrame;
import com.tn.cinema.gui.superAdmin.SuperAdministratorFrame;
import com.tn.cinema.gui.xx.UpdateManagerFrame;
import com.tn.cinema.model.AdministratorsModel;
import com.tn.cinema.model.ManagersModel;
import com.tn.cinema.utility.Utils;

// note : there r some repreated methods, don t get upset :D i m just ensuring that the code is readable
public class SuperAdminController {

	private static SuperAdministratorFrame sAdministratorFrame;
	private static NewAdminFrame newAdminFrame;
	private static UpdateAdminFrame updateAdminFrame;
	private static UpdateManagerFrame updateManagerFrame;
	
	public SuperAdminController() {
		sAdministratorFrame = new SuperAdministratorFrame();
		sAdministratorFrame.setVisible(true);
	}

	// ******************* navigation *******************************
	public static void showNewAdminFrame() {
		if (newAdminFrame == null) {
			newAdminFrame = new NewAdminFrame();
			newAdminFrame.setVisible(true);
		} else {
			newAdminFrame.setVisible(true);
		}
	}

	public static void disposeNewAdminFrame() {
		newAdminFrame.dispose();
	}

	public static void showUpdateAdminFrame(Administrator a) {
		updateAdminFrame = new UpdateAdminFrame(a);
		updateAdminFrame.setVisible(true);
	}

	public static void diposeUpdateAdminFrame() {
		updateAdminFrame.dispose();
	}


	public static void showUpdateManagerFrame(Manager m) {
		updateManagerFrame = new UpdateManagerFrame(m);
		updateManagerFrame.setVisible(true);
	}

	public static void diposeUpdateManagerFrame() {
		updateManagerFrame.dispose();
	}

	// ************************* admins & managers **************************
	public static void loadAdmins(String s) {
		SuperAdministratorFrame.getAdminsPanel().getTable().setModel(new AdministratorsModel(s));
	}

	public static void loadAdmins() {
		SuperAdministratorFrame.getAdminsPanel().getTable().setModel(new AdministratorsModel());

	}

	public static void loadManagers(String s) {
		SuperAdministratorFrame.getManagersPanel().getTable().setModel(new ManagersModel(s));
	}

	public static void loadManagers() {
		SuperAdministratorFrame.getManagersPanel().getTable().setModel(new ManagersModel());

	}
	
	// **********************new admin
	// ************************************************

	public static boolean insertAdmin(String firstName, String name, String email, String password, String phone,
			File profileImg) {
		Administrator a = new Administrator();
		a.setFirstName(firstName);
		a.setName(name);
		a.setEmail(email);
		a.setPassword(password);
		a.setMobilePhone(Long.parseLong(phone));
		a.setImage(Utils.convertToBytes(profileImg));
		return AdministratorServiceDelegate.addAdministrator(a);
	}

	

	// **********************update admin, manager
	// ************************************************

	public static boolean updateAdmin(Administrator a, String firstName, String name, String email, String password,
			String phone, File profileImg, boolean imageChanged, boolean isLocked) {
		a.setFirstName(firstName);
		a.setName(name);
		a.setEmail(email);
		a.setMobilePhone(Long.parseLong(phone));
		a.setLocked(isLocked);
		if (!password.isEmpty()) {
			a.setPassword(password);
		}
		if (imageChanged) {
			a.setImage(Utils.convertToBytes(profileImg));
		}
		return AdministratorServiceDelegate.updateAdministrator(a);
	}

	public static boolean updateManager(Manager m, String firstName, String name, String email, String password,
			String phone, File profileImg, boolean imageChanged, boolean isLocked) {
		m.setFirstName(firstName);
		m.setName(name);
		m.setEmail(email);
		m.setMobilePhone(Long.parseLong(phone));
		m.setLocked(isLocked);
		if (!password.isEmpty()) {
			m.setPassword(password);
		}
		if (imageChanged) {
			m.setImage(Utils.convertToBytes(profileImg));
		}
		return ManagerServiceDelegate.updateManager(m);
	}
	

	// **********************delete admin, manager
	// ************************************************
	public static boolean deleteAdmin(Administrator a) {
		return AdministratorServiceDelegate.deleteAdministrator(a);
	}

	public static boolean deleteManager(Manager m) {
		return ManagerServiceDelegate.deleteManager(m);
	}
	

}
