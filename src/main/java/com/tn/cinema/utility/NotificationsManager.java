package com.tn.cinema.utility;

import com.alee.managers.notification.NotificationIcon;
import com.alee.managers.notification.NotificationManager;
import com.alee.managers.notification.WebNotificationPopup;

public class NotificationsManager {

	
	public static void displayWrongCreditsPopUp() {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.error);
		notificationPopup.setContent("Something wrong, please verify the email & password ");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(4000);
		NotificationManager.showNotification(notificationPopup);
	}

	public static void displayAccountLockedPopUp() {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.error);
		notificationPopup.setContent("Sorry, your account is locked ");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(4000);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displayPasswordsNotMatchingPopUp() {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.error);
		notificationPopup.setContent("Passwords does not match ");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}

	public static void displayInputsErrorPopUp() {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.error);
		notificationPopup.setContent("Please insert some valide data (Email, Phone number ..)");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}

	public static void displayImageErrorPopUp() {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.error);
		notificationPopup.setContent("Image size must not exceed 1.5 mo");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displayInsertErrorPopUp(String object) {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.error);
		notificationPopup.setContent("Cannot insert the "+object);
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}

	public static void displayInsertSuccessPopUp(String object) {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.plus);
		notificationPopup.setContent(object+" inserted with success");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displaySelectPopUp(String object) {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.information);
		notificationPopup.setContent("Please choose the "+object );
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(1500);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displayUpdateErrorPopUp(String object) {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.plus);
		notificationPopup.setContent("Cannot update the "+object);
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}

	public static void displayUpdateSuccessPopUp(String object) {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.plus);
		notificationPopup.setContent(object+" updated with success");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displayDeleteErrorPopUp(String object) {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.plus);
		notificationPopup.setContent("Cannot delete the "+object);
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}

	public static void displayDeleteSuccessPopUp(String object) {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.plus);
		notificationPopup.setContent(object+" deleted with success");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displayAccountSuccessPopUp() {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.plus);
		notificationPopup.setContent("Account created with success, we will contact you soon");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displayAccountErrorPopUp() {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.error);
		notificationPopup.setContent("Oops somethin' went wrong ");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displaySignUpSuccessPopUp() {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.information);
		notificationPopup.setContent("Your account has been created, we'll contact you soon !");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}
	
	public static void displayCreatedSuccessPopUp(String object) {
		WebNotificationPopup notificationPopup = new WebNotificationPopup();
		notificationPopup.setIcon(NotificationIcon.plus);
		notificationPopup.setContent(object+" created with success");
		notificationPopup.setSize(120, 120);
		notificationPopup.setDisplayTime(3000);
		NotificationManager.showNotification(notificationPopup);
	}
}
