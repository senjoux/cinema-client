package com.tn.cinema.utility;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.validator.routines.EmailValidator;

import com.tn.cinema.entities.Administrator;
import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities.Movie;
import com.tn.cinema.entities.MovieTheater;

public class Utils {
	public static byte[] convertToBytes(File file) {
		byte[] bFile = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}

	public static BufferedImage convertToImage(byte[] image) {
		BufferedImage result = null;
		try {
			result = ImageIO.read(new ByteArrayInputStream(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result.getWidth());
		return result;
	}

	public static boolean isValideEmail(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

	@SuppressWarnings("rawtypes")
	public static List mergeTwoLists(List lst1, List lst2) {
		Set set1 = new HashSet<Object>(lst1);
		Set set2 = new HashSet<Object>(lst2);
		set1.addAll(set2);
		List<Object> temp = new ArrayList<Object>();
		temp.addAll(set1);
		return temp;
	}

	public static List<Administrator> fetchAdminsByCriteria(List<Administrator> administrators, String X) {
		List<Administrator> res = new ArrayList<Administrator>();
		for (Administrator a : administrators) {
			if (a.getFirstName().toLowerCase().contains(X.toLowerCase())
					|| a.getName().toLowerCase().contains(X.toLowerCase())
					|| a.getEmail().toLowerCase().contains(X.toLowerCase())) {
				res.add(a);
			}
		}
		return res;
	}

	public static List<Manager> fetchManagersByCriteria(List<Manager> managers, String X) {
		List<Manager> res = new ArrayList<Manager>();
		for (Manager m : managers) {
			if (m.getFirstName().toLowerCase().contains(X.toLowerCase())
					|| m.getName().toLowerCase().contains(X.toLowerCase())
					|| m.getEmail().toLowerCase().contains(X.toLowerCase())) {
				res.add(m);
			}
		}
		return res;
	}

	public static List<Movie> fetchMoviesByCriteria(List<Movie> movies, String X) {
		List<Movie> res = new ArrayList<Movie>();
		for (Movie m : movies) {
			if (m.getTitle().toLowerCase().contains(X.toLowerCase())
					|| m.getType().toLowerCase().contains(X.toLowerCase())) {
				res.add(m);
			}
		}
		return res;
	}

	public static List<MovieTheater> fetchMovieTheatersByCriteria(List<MovieTheater> theaters, String X) {
		List<MovieTheater> res = new ArrayList<MovieTheater>();
		for (MovieTheater m : theaters) {
			if (m.getName().toLowerCase().contains(X.toLowerCase())
					|| m.getAdresse().toLowerCase().contains(X.toLowerCase())
					|| m.getTelephone().toString().toLowerCase().contains(X.toLowerCase())
					|| m.getManager().getFirstName().toLowerCase().contains(X.toLowerCase())
					|| m.getManager().getName().toLowerCase().contains(X.toLowerCase())
					) {
				res.add(m);
			}
		}
		return res;
	}

	// pwd hashing ....

	public static String generateSalt(int length) {
		String salt = "";
		for (int i = 0; i < length; i++) {
			salt += (char) (20 + Math.random() * 35);
		}
		return salt;
	}

	public static String hashPassword(String unhashedPassword, String salt) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		digest.update((unhashedPassword + salt).getBytes());
		return new String(digest.digest());
	}
	
	public static List<Manager> fetchManagersAreLocked(List<Manager> managers, boolean isLocked) {
		List<Manager> res = new ArrayList<Manager>();
		for (Manager m : managers) {
			if (m.isLocked()==isLocked && m.getMovieTheaters().size()==0)
			{
				res.add(m);
			}
		}
		return res;
	}
}
