package com.tn.cinema.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import com.tn.cinema.delegate.AdministratorServiceDelegate;
import com.tn.cinema.delegate.ManagerServiceDelegate;
import com.tn.cinema.delegate.MovieServiceDelegate;
import com.tn.cinema.delegate.MovieTheaterServiceDelegate;
import com.tn.cinema.entities.Administrator;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities.Movie;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.entities._3DMovieTheater;
import com.tn.cinema.gui.ManagerDetailsFrame;
import com.tn.cinema.gui.MovieCoverFrame;
import com.tn.cinema.gui.NewAdminFrame;
import com.tn.cinema.gui.NewManagerFrame;
import com.tn.cinema.gui.NewMovieFrame;
import com.tn.cinema.gui.NewMovieTheaterFrame;
import com.tn.cinema.gui.UpdateAdminFrame;
import com.tn.cinema.gui.UpdateManagerFrame;
import com.tn.cinema.gui.UpdateMovieFrame;
import com.tn.cinema.gui.UpdateMovieTheaterFrame;
import com.tn.cinema.gui.superAdmin.AdministratorFrame;
import com.tn.cinema.model.AdministratorsModel;
import com.tn.cinema.model.ManagersModel;
import com.tn.cinema.model.MovieTheatersModel;
import com.tn.cinema.model.MoviesModel;
import com.tn.cinema.model.TheaterManagersModel;
import com.tn.cinema.utility.Utils;

// note : there r some repreated methods names, don t get upset :D i m just ensuring that the code is readable
public class SuperAdminController {

	private static AdministratorFrame sAdministratorFrame;
	private static NewAdminFrame newAdminFrame;
	private static UpdateAdminFrame updateAdminFrame;
	private static UpdateManagerFrame updateManagerFrame;
	private static NewManagerFrame newManagerFrame;
	private static NewMovieFrame newMovieFrame;
	private static MovieCoverFrame movieCoverFrame;
	private static UpdateMovieFrame updateMovieFrame;
	private static NewMovieTheaterFrame newMovieTheaterFrame;
	private static UpdateMovieTheaterFrame updateMovieTheaterFrame;
	private static ManagerDetailsFrame managerDetailsFrame;
	
	public SuperAdminController(Administrator a) {
		sAdministratorFrame = new AdministratorFrame(a);
		sAdministratorFrame.setVisible(true);
	}

	//******************** logout	*****************************
	public static void logout(){
		sAdministratorFrame.dispose();
		MainController.startTheApp();
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

	//
	public static void showUpdateManagerFrame(Manager m) {
		updateManagerFrame = new UpdateManagerFrame(m);
		updateManagerFrame.setVisible(true);
	}

	public static void diposeUpdateManagerFrame() {
		updateManagerFrame.dispose();
	}

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
	
	//
	public static void showNewMovieFrame() {
		if (newMovieFrame == null) {
			newMovieFrame = new NewMovieFrame();
			newMovieFrame.setVisible(true);
		} else {
			newMovieFrame.setVisible(true);
		}
	}
	
	public static void disposeNewMovieFrame() {
		newMovieFrame.dispose();
	}
	
	public static void showMovieCoverFrame(BufferedImage image) {
		movieCoverFrame=new MovieCoverFrame(image);
		movieCoverFrame.setVisible(true);
	}
	
	public static void showUpdateMovieFrame(Movie mv) {
		updateMovieFrame = new UpdateMovieFrame(mv);
		updateMovieFrame.setVisible(true);
	}
	
	public static void disposeUpdateMovieFrame() {
		updateMovieFrame.dispose();
	}
	
	//
	public static void showNewMovieTheaterFrame() {
		if (newMovieTheaterFrame == null) {
			newMovieTheaterFrame = new NewMovieTheaterFrame();
			newMovieTheaterFrame.setVisible(true);
		} else {
			newMovieTheaterFrame.setVisible(true);
		}
	}
	
	public static void disposeNewMovieTheaterFrame() {
		newMovieTheaterFrame.dispose();
	}
	
	public static void showUpdateMovieTheaterFrame(MovieTheater mt) {
		updateMovieTheaterFrame = new UpdateMovieTheaterFrame(mt);
		updateMovieTheaterFrame.setVisible(true);
	}
	public static void disposeUpdateMovieTheaterFrame() {
		updateMovieTheaterFrame.dispose();
	}
	
	public static void showManagerDetailsFrame(Manager m) {
		managerDetailsFrame=new ManagerDetailsFrame(m);
		managerDetailsFrame.setVisible(true);
	}
	
	public static void disposeManagerDetailsFrame() {
		managerDetailsFrame.dispose();
	}
	
	// ************************* admins & managers & movies **************************
	public static void loadAdmins(String s) {
		AdministratorFrame.getAdminsPanel().getTable().setModel(new AdministratorsModel(s));
	}

	public static void loadAdmins() {
		AdministratorFrame.getAdminsPanel().getTable().setModel(new AdministratorsModel());
	}

	//
	public static void loadManagers(String s) {
		AdministratorFrame.getManagersPanel().getTable().setModel(new ManagersModel(s));
	}

	public static void loadManagers() {
		AdministratorFrame.getManagersPanel().getTable().setModel(new ManagersModel());
	}
	
	//
	public static void loadMovies() {
		AdministratorFrame.getMoviesPanel().getTable().setModel(new MoviesModel());
	}
	
	public static void loadMovies(String s) {
		AdministratorFrame.getMoviesPanel().getTable().setModel(new MoviesModel(s));
	}
	
	//
	public static void loadMovieTheaters() {
		AdministratorFrame.getMovieTheatersPanel().getTable().setModel(new MovieTheatersModel());
	}
	
	public static void loadMovieTheaters(String s) {
		AdministratorFrame.getMovieTheatersPanel().getTable().setModel(new MovieTheatersModel(s));
	}
	
	//
	public static void loadTheaterManagers() {
		NewMovieTheaterFrame.getTable().setModel(new TheaterManagersModel());
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
			a.setSalt(Utils.generateSalt(5));
			a.setPassword(Utils.hashPassword(password, a.getSalt()));
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
			m.setSalt(Utils.generateSalt(5));
			m.setPassword(Utils.hashPassword(password, m.getSalt()));
		}
		if (imageChanged) {
			m.setImage(Utils.convertToBytes(profileImg));
		}
		return ManagerServiceDelegate.updateManager(m);
	}
	
	public static boolean updateMovie(Movie mv,String title, String length, String type,File coverImg,boolean coverChanged) {
		mv.setTitle(title);
		mv.setLength(Long.parseLong(length));
		mv.setType(type);
		if (coverChanged) {
			mv.setCover(Utils.convertToBytes(coverImg));
		}
		return MovieServiceDelegate.updateMovie(mv);
	}
	
	public static boolean updateMovieTheater(MovieTheater mt,String name, String address, String phone,int capacity) {
		mt.setName(name);
		mt.setAdresse(address);
		mt.setTelephone(Long.parseLong(phone));
		mt.setCapacity(Long.valueOf(capacity));
		return MovieTheaterServiceDelegate.updateMovieTheater(mt);
	}
	// **********************delete admin, manager,movie, movie theater
	// ************************************************
	public static boolean deleteAdmin(Administrator a) {
		return AdministratorServiceDelegate.deleteAdministrator(a);
	}

	public static boolean deleteManager(Manager m) {
		return ManagerServiceDelegate.deleteManager(m);
	}
	
	public static boolean deleteMovie(Movie mv) {
		return MovieServiceDelegate.deleteMovie(mv);
	}
	
	public static boolean deleteMovieTheater(MovieTheater mt) {
		return MovieTheaterServiceDelegate.deleteMovieTheater(mt);
	}

	// **********************new movie
	// ************************************************
	public static boolean insertMovie(String title,String length,String type,File coverImg) {
		Movie m=new Movie();
		m.setTitle(title);
		m.setLength(Long.parseLong(length));
		m.setType(type);
		m.setApproved(true);
		m.setCover(Utils.convertToBytes(coverImg));
		return MovieServiceDelegate.addMovie(m);
	}
	
	// **********************new movie theater
		// ************************************************
		public static boolean insertMovieTheater(String name,String adress,String phone,int capacity, Manager manager) {
			MovieTheater m=new MovieTheater();
			m.setName(name);
			m.setAdresse(adress);
			m.setTelephone(Long.parseLong(phone));
			m.setCapacity(Long.valueOf(capacity));
			m.setManager(manager);
			return MovieTheaterServiceDelegate.addMovieTheater(m);
		}
		
		public static boolean insert3DMovieTheater(String name,String adress,String phone,int capacity,String projectionType, Manager manager) {
			_3DMovieTheater m=new _3DMovieTheater();
			m.setName(name);
			m.setAdresse(adress);
			m.setTelephone(Long.parseLong(phone));
			m.setCapacity(Long.valueOf(capacity));
			m.setProjectionType(projectionType);
			m.setManager(manager);
			return MovieTheaterServiceDelegate.addMovieTheater(m);
		}
		
		
}
