package com.tn.cinema.delegate;

import com.tn.cinema.entities.User;
import com.tn.cinema.services.UsersFacadeRemote;
import com.tn.cinema.utility.ServiceLocator;

public class UsersServiceDelegate {

	private static final String jndi = "cinema-ejb/UsersFacade!com.tn.cinema.services.UsersFacadeRemote";
	
	private static UsersFacadeRemote getProxy() {
		return (UsersFacadeRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public static User authenticate(String email, String password){
		return getProxy().authenticate(email, password);
	}
}
