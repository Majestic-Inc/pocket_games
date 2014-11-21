/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.majestic.pocketgames.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.majestic.pocketgames.database.DatabaseHelper;
import ru.majestic.pocketgames.database.dao.UserDAO;
import ru.majestic.pocketgames.database.exceptions.DatabaseAccessException;
import ru.majestic.pocketgames.database.utils.Encriptor;
import ru.majestic.pocketgames.forms.objects.UserRegistrationFormObject;
import ru.majestic.pocketgames.forms.validators.RegisterUserFormValidator;
import ru.majestic.pocketgames.forms.validators.ValidationStatus;

/**
 *
 * @author azakharov
 */
@Controller
@RequestMapping("/user")
public class RegisterUserController {
    
    @RequestMapping(method= RequestMethod.GET, value="/show_register_form.htm")
    public String showRegisterForm() {
        return "user/register_user_form";
    }
    
    @RequestMapping(method= RequestMethod.POST, value="/register.htm")
    public ModelAndView register(@ModelAttribute("user") UserRegistrationFormObject userRegistrationFormObject) {
        ModelAndView modelAndView;
        
        try {            
            final ValidationStatus validationStatus = RegisterUserFormValidator.validateUserRegistrationFormObject(userRegistrationFormObject);

            if(validationStatus.getValidationStatus() == ValidationStatus.Status.OK) {           
                DatabaseHelper.getInstance().addUser(convertFormDataToUserDAO(userRegistrationFormObject));

                modelAndView = new ModelAndView("user/registration_success");            
            } else {
                modelAndView = new ModelAndView("user/register_user_form");
                modelAndView.addObject("registration_error", validationStatus.getErrorMessage());
            }
        } catch (DatabaseAccessException e) {
            modelAndView = new ModelAndView("user/register_user_form");
            modelAndView.addObject("registration_error", e.toString());
        } catch (NoSuchAlgorithmException e) {
            modelAndView = new ModelAndView("user/register_user_form");
            modelAndView.addObject("registration_error", e.toString());
        }
        

        return modelAndView;
    }
    
    
    private UserDAO convertFormDataToUserDAO(UserRegistrationFormObject userRegistrationFormObject) throws NoSuchAlgorithmException {
        final UserDAO userDAO = new UserDAO();
        userDAO.setMail(userRegistrationFormObject.getMail());
        userDAO.setPassword(Encriptor.encriptPassword(userRegistrationFormObject.getPassword()));
        userDAO.setName(userRegistrationFormObject.getName());
        userDAO.setLastName(userRegistrationFormObject.getLastName());
        userDAO.setRegistrationDate(new Date());
        
        return userDAO;
    }
    
}
