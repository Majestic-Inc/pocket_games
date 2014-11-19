/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.majestic.pocketgames.database.exceptions;

/**
 *
 * @author azakharov
 */
public class DatabaseAccessException extends Exception {
    
    private String errorMessage;
    
    public DatabaseAccessException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public String toString() {
        return errorMessage;
    }
    
    @Override
    public void printStackTrace() {
        System.out.println(errorMessage);
    }
    
}
