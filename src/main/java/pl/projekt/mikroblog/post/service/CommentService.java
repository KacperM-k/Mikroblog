package pl.projekt.mikroblog.post.service;

import org.springframework.stereotype.Controller;
import pl.projekt.mikroblog.post.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAllCommentsByPost(long id);

}
