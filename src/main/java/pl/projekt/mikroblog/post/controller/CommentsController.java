package pl.projekt.mikroblog.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.projekt.mikroblog.DAO.UserDAO;
import pl.projekt.mikroblog.post.entity.Comment;
import pl.projekt.mikroblog.post.entity.Post;
import pl.projekt.mikroblog.post.repository.CommentsRepo;
import pl.projekt.mikroblog.post.service.CommentService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class CommentsController {

    CommentService commentService;
    UserDAO userDAO;

    public CommentsController(CommentService commentService, UserDAO userDAO) {
        this.commentService = commentService;
        this.userDAO = userDAO;
    }

    @GetMapping("comments/delete/{id}")
    public String deletePost(@PathVariable long id){
        commentService.deleteCommentByID(id);
        return "redirect:/posts";
    }

    @PostMapping("/comment/savecomment")
    public String saveComment(Comment comment) {
        Date currentDate = new Date();
        comment.setCommentDate(currentDate);
        comment.setCommentAuthor(userDAO.getLoggedUsername());
        commentService.addComment(comment);
        return "redirect:/posts/"+comment.getPostID();
    }

//    @PostMapping("posts/savepost")
//    public String redirectEntry(@Valid Post post, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "post_creator";
//        }
//        Date currentdate = new Date();
//        post.setPublicationDate(currentdate);
////        post.setUserName(userDAO.getLoggedUsername());
//        postService.addPost(post);
//        return "redirect:/posts";
//    }

}
