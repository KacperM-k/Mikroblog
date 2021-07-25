package pl.projekt.mikroblog.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.projekt.mikroblog.DAO.UserDAO;
import pl.projekt.mikroblog.post.entity.Post;
import pl.projekt.mikroblog.post.service.CommentService;
import pl.projekt.mikroblog.post.service.PostService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class PostController {

    PostService entryService;
    CommentService commentService;
    UserDAO userDAO;

    @Autowired
    public PostController(PostService entryService, CommentService commentService, UserDAO userDAO) {
        this.entryService = entryService;
        this.commentService = commentService;
        this.userDAO = userDAO;

    @GetMapping("posts")
    public String showAllEntries(Model model) {
        model.addAttribute("allPosts", entryService.findAllPosts());
        return "home_screen";
    }

    @GetMapping("posts/{id}")
    public String getPost(@PathVariable long id, Model model) {
        model.addAttribute("post", entryService.findPostById(id));
        model.addAttribute("comments", commentService.findAllCommentsByPost(id));
        return "post_details";
    }

    @PostMapping("posts/savepost")
    public String redirectEntry(@Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "post_creator";
        }
        Date currentdate = new Date();
        post.setPublicationDate(currentdate);
//        post.setUserName(userDAO.getLoggedUsername());
        entryService.addPost(post);
        return "redirect:/posts";
    }

    @PostMapping("posts/updatepost")
    public String updatePost(Post post) {
        Date currentdate = new Date();
        post.setEditDate(currentdate);
        entryService.addPost(post);
        return "redirect:/posts";
    }

    @GetMapping("posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        entryService.deletePost(id);
        return "redirect:/posts";
    }


}
