package pl.projekt.mikroblog.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.projekt.mikroblog.repository.UserRepository;
import pl.projekt.mikroblog.user.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> all = userRepo.findAll();
        return all;
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);

    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public void editUserDetails(User user, String login) {
        Optional<User> userByLoginOp = findByLogin(login);
        userByLoginOp.ifPresent(userByLogin -> {
            userByLogin.setLogin(user.getLogin());
            userByLogin.setDescription(user.getDescription());
            userByLogin.setUsername(user.getUsername());
            userByLogin.setDisplayName(user.getDisplayName());
            userByLogin.setPassword(user.getPassword());
            userRepo.save(userByLogin);
        });
    }

    // dopisanie metody do interface repo
    @Override
    public Optional<User> findByLogin(String login) {
        User byLogin = userRepo.findByLogin("user1");

        return Optional.ofNullable(byLogin);
    }

    //pobieranie danych o zalogowanym użytkowniku (dodane przez Kacper)
    public String getLoggedUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return username;
        } else {
            String username = principal.toString();
            return username;
        }
    }

    public User getActualLogged() {
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (logged instanceof UserDetails) {
            String username = ((UserDetails) logged).getUsername();
            User byUsername = userRepo.findByUsername(username);

            return byUsername;
        }
        return null;
    }
}
