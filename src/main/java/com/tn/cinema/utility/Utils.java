package com.tn.cinema.utility;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utils {
	public static byte[] convertToBytes(File file){
		 byte[] bFile = new byte[(int) file.length()];
	        
	        try {
		     FileInputStream fileInputStream = new FileInputStream(file);
		     //convert file into array of bytes
		     fileInputStream.read(bFile);
		     fileInputStream.close();
	        } catch (Exception e) {
		     e.printStackTrace();
	        }
	     return bFile;   
	}
	
	public static BufferedImage convertToImage(byte[] image){
		BufferedImage result=null;
		try {
			result=ImageIO.read(new ByteArrayInputStream(image));
		} catch (IOException e) { e.printStackTrace(); }
		System.out.println(result.getWidth());
		return result;
	}
}
