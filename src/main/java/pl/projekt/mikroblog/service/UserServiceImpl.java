package pl.projekt.mikroblog.service;

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
            userByLogin.setEmail(user.getEmail());
            userByLogin.setDisplayName(user.getDisplayName());
            userByLogin.setPassword(user.getPassword());
            userRepo.save(userByLogin);
        });
    }


    // dopisanie metody do interface repo
    @Override
    public Optional<User> findByLogin(String login) {
        User byLogin = userRepo.findByLogin("user1");
        //findByLogin(login);

        return Optional.ofNullable(byLogin);
    }
}
