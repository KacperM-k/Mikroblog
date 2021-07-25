package pl.projekt.mikroblog.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.projekt.mikroblog.post.repository.CommentsRepo;
import pl.projekt.mikroblog.post.service.CommentService;

@Controller
public class CommentsController {

    CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("comments/delete/{id}")
    public String deletePost(@PathVariable long id){
        commentService.deleteCommentByID(id);
        return "redirect:/posts";
    }
}
