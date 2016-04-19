package com.tn.cinema.utility;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidatorsManager {

	public static boolean validateFields(String firstName, String name, String email, String password, String phone) {
		// check inputs length
		boolean c1 = (firstName.length()) < 30;
		boolean c2 = (name.length()) < 30;
		boolean c3 = (email.length()) < 30;
		boolean c5 = (password.length()) < 200;
		boolean c6 = (phone.length()) < 15;
		// check email
		boolean c4 = Utils.isValideEmail(email);
		// check phone
		boolean c7 = false;
		try {
			Long.parseLong(phone);
			c7 = true;
		} catch (NumberFormatException e) {
		}
		return c1 && c2 && c3 && c4 && c5 && c6 && c7;
	}
	
	public static boolean validateEmail(String email) {
		return EmailValidator.getInstance().isValid(email);
	}
	
	public static boolean checkPasswordsEqual(String pwd1, String pwd2) {
		return pwd1.equals(pwd2);
	}

	public static boolean validateLongAsString(String text) {
		boolean res = false;
		try {
			Long.parseLong(text);
			res = true;
		} catch (NumberFormatException e) {
		}
		return res;
	}
}
