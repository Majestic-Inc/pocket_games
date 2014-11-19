/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.majestic.pocketgames.forms.validators;

import ru.majestic.pocketgames.forms.objects.UserRegistrationFormObject;

/**
 *
 * @author azakharov
 */
public class RegisterUserFormValidator {
    
    private static final int ERROR_CODE_E_MAIL_SHORT    = 100;
    private static final int ERROR_CODE_E_MAIL_LONG     = 101;
    
    private static final int ERROR_CODE_PASSWORD_SHORT      = 102;
    private static final int ERROR_CODE_PASSWORD_LONG       = 103;
    
    
    
    private static final int E_MAIL_MIN_LENGTH  = 3;
    private static final int E_MAIL_MAX_LENGTH  = 128;    
    
    private static final int PASSWORD_MIN_LENGTH  = 5;    
    private static final int PASSWORD_MAX_LENGTH  = 64;    
    
    public static ValidationStatus validateUserRegistrationFormObject(UserRegistrationFormObject userRegistrationFormObject) {
        if(userRegistrationFormObject.getMail().length() < E_MAIL_MIN_LENGTH) {
            return new ValidationStatus(ValidationStatus.Status.ERROR, ERROR_CODE_E_MAIL_SHORT, "E-mail слишком короткий. Минимальная длина " + E_MAIL_MIN_LENGTH);
        }
        
        if(userRegistrationFormObject.getMail().length() > E_MAIL_MAX_LENGTH) {
            return new ValidationStatus(ValidationStatus.Status.ERROR, ERROR_CODE_E_MAIL_LONG, "E-mail слишком длинный. Максимальная длина " + E_MAIL_MAX_LENGTH);
        }
        
        if(userRegistrationFormObject.getPassword().length() < PASSWORD_MIN_LENGTH) {
            return new ValidationStatus(ValidationStatus.Status.ERROR, ERROR_CODE_PASSWORD_SHORT, "Пароль слишком короткий. Минимальная длина " + PASSWORD_MIN_LENGTH);
        }
        
        if(userRegistrationFormObject.getPassword().length() > PASSWORD_MAX_LENGTH) {
            return new ValidationStatus(ValidationStatus.Status.ERROR, ERROR_CODE_PASSWORD_LONG, "Пароль слишком длинный. Максимальная длина " + PASSWORD_MAX_LENGTH);
        }
        
        return new ValidationStatus(ValidationStatus.Status.OK);
    }
    
}
