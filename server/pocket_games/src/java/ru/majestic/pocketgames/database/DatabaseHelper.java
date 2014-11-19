/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.majestic.pocketgames.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.majestic.pocketgames.database.dao.UserDAO;
import ru.majestic.pocketgames.database.exceptions.DatabaseAccessException;
import ru.majestic.pocketgames.database.hibernate.PocketGamesHibernateUtils;

/**
 *
 * @author azakharov
 */
public class DatabaseHelper {
    
    private static DatabaseHelper instance;
    
    private DatabaseHelper() {
        
    }
    
    public static DatabaseHelper getInstance() {
        if(instance == null) {
            instance = new DatabaseHelper();        
        }
        return instance;
    }
    
    public void addUser(UserDAO userDAO) throws DatabaseAccessException {
        final Session session = PocketGamesHibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(userDAO);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DatabaseAccessException(e.toString());
        }
    }
    
    public boolean hasUserWithSameMail(String mail) throws DatabaseAccessException {
        final Session session = PocketGamesHibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        try {            
            return !session.createQuery("FROM UserDAO u WHERE u.mail = :mail").setString("mail", mail).list().isEmpty();
        } catch (HibernateException e) {
            throw new DatabaseAccessException(e.toString());
        }
    }
    
}
