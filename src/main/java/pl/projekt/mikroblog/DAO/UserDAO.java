package pl.projekt.mikroblog.DAO;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.user.User;

import javax.persistence.EntityManager;
import java.sql.*;

@Repository
public class UserDAO {

    private EntityManager entityManager;

    public User getUserByLogin(String login) throws SQLException {
        User userByLogin = entityManager.find(User.class, login);
        return userByLogin;
    }



    //pobieranie danych o zalogowanym użytkowniku (dodane przez Kacper)
    public String getLoggedUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return username;
        } else{
            String username = principal.toString();
            return username;
        }
    }

}
