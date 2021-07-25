package pl.projekt.mikroblog.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.post.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
