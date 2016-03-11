package com.tn.cinema.delegate;

import java.util.List;

import com.tn.cinema.entities.Administrator;
import com.tn.cinema.services.AdministratorServiceRemote;
import com.tn.cinema.utility.ServiceLocator;

public class AdministratorServiceDelegate {

	private static final String jndi = "cinema-ejb/AdministratorService!com.tn.cinema.services.AdministratorServiceRemote";

	private static AdministratorServiceRemote getProxy() {
		return (AdministratorServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static boolean addAdministrator(Administrator a) {
		return getProxy().addAdministrator(a);
	}

	public static boolean updateAdministrator(Administrator a) {
		return getProxy().updateAdministrator(a);
	}

	public static boolean deleteAdministrator(Administrator a) {
		return getProxy().deleteAdministrator(a);
	}

	public static List<Administrator> findAllAdministrators() {
		return getProxy().findAllAdministrators();
	}

	public static Administrator findAdministratorByID(Integer id) {
		return getProxy().findAdministratorByID(id);
	}

	public static Administrator findAdministratorByEmail(String email) {
		return getProxy().findAdministratorByEmail(email);
	}

	public static Administrator findAdministratorByEmailAndPassword(String email,String password) {
		return getProxy().findAdministratorByEmailAndPassword(email,password);
	}

}
