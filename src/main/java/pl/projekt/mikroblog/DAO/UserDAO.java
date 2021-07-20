package pl.projekt.mikroblog.DAO;

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


}
