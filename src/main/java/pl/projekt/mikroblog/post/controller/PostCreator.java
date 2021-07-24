package pl.projekt.mikroblog.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.projekt.mikroblog.DAO.UserDAO;
import pl.projekt.mikroblog.post.entity.Post;
import pl.projekt.mikroblog.post.service.PostService;

@Controller
public class PostCreator {

    PostService entryService;
    UserDAO userDAO;

    public PostCreator(PostService entryService, UserDAO userDAO) {
        this.entryService = entryService;
        this.userDAO = userDAO;
    }

    @GetMapping("/post/addpost")
    public String addPost(Model model) {
        model.addAttribute("newPost", new Post());
        model.addAttribute("loggedUsername", userDAO);
        return "post_creator";
    }

    @GetMapping("/post/updatepost/{id}")
    public String editPost(@PathVariable long id, Model model) {
        model.addAttribute("post", entryService.findPostById(id));
        model.addAttribute("newPost", new Post());
        return "post_editor";
    }
}

