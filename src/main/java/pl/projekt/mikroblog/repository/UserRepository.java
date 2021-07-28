package pl.projekt.mikroblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByLogin(String login);
    User findByUsername(String username);
}
