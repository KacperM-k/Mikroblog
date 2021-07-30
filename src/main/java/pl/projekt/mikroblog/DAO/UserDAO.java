package pl.projekt.mikroblog.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.controllers.UserController;
import pl.projekt.mikroblog.repository.UserRepository;
import pl.projekt.mikroblog.user.User;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.Collection;

@Repository
public class UserDAO {

    UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
