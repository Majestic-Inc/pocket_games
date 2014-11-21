/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.majestic.pocketgames.database.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author azakharov
 */
public class Encriptor {

    public static String encriptPassword(String password) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes()); 
        byte byteData[] = md.digest();
                
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
    }
    
}
