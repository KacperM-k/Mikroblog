package pl.projekt.mikroblog.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    PostService postService;
    CommentService commentService;
    UserDAO userDAO;

    @Autowired
    public PostController(PostService postService, CommentService commentService, UserDAO userDAO) {
        this.postService = postService;
        this.commentService = commentService;
        this.userDAO = userDAO;
    }

    @GetMapping("posts")
    public String showAllEntries(Model model) {
        model.addAttribute("allPosts", postService.findAllPosts());
        return "home_screen";
    }

    @GetMapping("posts/{id}")
    public String getPost(@PathVariable long id, Model model) {
        model.addAttribute("comments", commentService.findAllCommentsByPost(id));
        model.addAttribute("post", postService.findPostById(id));
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
        postService.addPost(post);
        return "redirect:/posts";
    }

    @PostMapping("posts/updatepost")
    public String updatePost(Post post) {
        Date currentdate = new Date();
        post.setEditDate(currentdate);
        postService.addPost(post);
        return "redirect:/posts";
    }

    @GetMapping("posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postService.deletePost(id);
        return "redirect:/posts";
    }


}
