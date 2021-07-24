package pl.projekt.mikroblog.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.post.entity.Comment;

import java.util.List;

@Repository
public interface CommentsRepo extends JpaRepository<Comment, Long> {


}
