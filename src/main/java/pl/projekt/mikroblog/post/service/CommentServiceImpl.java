package pl.projekt.mikroblog.post.service;

import org.springframework.stereotype.Controller;
import pl.projekt.mikroblog.post.entity.Comment;
import pl.projekt.mikroblog.post.entity.Post;
import pl.projekt.mikroblog.post.repository.CommentsRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CommentServiceImpl implements CommentService {

    CommentsRepo commentsRepo;

    public CommentServiceImpl(CommentsRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    @Override
    public List<Comment> findAllCommentsByPost(long id) {
        List<Comment> all = commentsRepo.findAll();
        return all.stream().filter(comment -> comment.getPostID() == id).collect(Collectors.toList());
    }

//    @Override
//    public List<Comment> findAllCommentsByPost(long id) {
//        Optional<Comment> commentOptional = commentsRepo.findById(id);
//        return commentOptional.get();
//    }

    @Override
    public void deleteCommentByPostID(long id) {
        List<Comment> all = commentsRepo.findAll();
        commentsRepo.deleteAllInBatch(all.stream().filter(comment -> comment.getPostID() == id).collect(Collectors.toList()));
    }
}
