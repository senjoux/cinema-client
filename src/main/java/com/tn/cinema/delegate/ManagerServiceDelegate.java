package com.tn.cinema.delegate;

import java.util.List;

import com.tn.cinema.entities.Manager;
import com.tn.cinema.services.ManagerServiceRemote;
import com.tn.cinema.utility.ServiceLocator;

public class ManagerServiceDelegate {

	private static final String jndi = "cinema-ejb/ManagerService!com.tn.cinema.services.ManagerServiceRemote";
	
	private static ManagerServiceRemote getProxy() {
		return (ManagerServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	
	public static boolean addManager(Manager m){
		return getProxy().addManager(m);
	}
	
	public static boolean updateManager(Manager m){
		return getProxy().updateManager(m);
	}
	
	public static boolean deleteManager(Manager m){
		return getProxy().deleteManager(m);
	}
	
	public static List<Manager> findAllManagers(){
		return getProxy().findAllManagers();
	}
	
	public static Manager findManagerByID(Integer id){
		return getProxy().findManagerByID(id);
	}
	
	public static Manager findManagerByEmail(String email){
		return getProxy().findManagerByEmail(email);
	}
	
	public static Manager findManagerByEmailAndPassword(String email,String password){
		return getProxy().findManagerByEmailAndPassword(email,password);
	}
	
	
}
