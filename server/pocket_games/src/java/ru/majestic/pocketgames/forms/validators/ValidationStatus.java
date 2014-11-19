/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.majestic.pocketgames.forms.validators;

/**
 *
 * @author azakharov
 */
public class ValidationStatus {    
    
    public enum Status {OK, ERROR}
    
    private Status      validationStatus;
    private int         errorCode;
    private String      errorMessage;       
    
    public ValidationStatus(Status validationStatus, int errorCode, String errorMessage) {
        this.validationStatus   = validationStatus;
        this.errorCode          = errorCode;
        this.errorMessage       = errorMessage;
    }
    
    public ValidationStatus(Status validationStatus) {
        this(validationStatus, 0, "");
    }
    
    /**
     * @return the validationStatus
     */
    public Status getValidationStatus() {
        return validationStatus;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    
}
