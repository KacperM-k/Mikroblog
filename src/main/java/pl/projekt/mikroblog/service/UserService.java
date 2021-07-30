package pl.projekt.mikroblog.service;

import org.springframework.stereotype.Service;
import pl.projekt.mikroblog.user.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> findAllUsers();
    void addUser(User user);
    void deleteUser(User user);
    void editUserDetails(User user, String login);
    Optional<User> findByLogin(String login);
    User getActualLogged();
    String getLoggedUsername();



}
