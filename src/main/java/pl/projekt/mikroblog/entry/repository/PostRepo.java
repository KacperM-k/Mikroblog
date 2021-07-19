package pl.projekt.mikroblog.entry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.entry.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
