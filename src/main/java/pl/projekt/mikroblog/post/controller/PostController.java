package pl.projekt.mikroblog.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pl.projekt.mikroblog.post.entity.Post;
import pl.projekt.mikroblog.post.service.PostService;

import java.util.Date;

@Controller
public class PostController {

    PostService entryService;

    @Autowired
    public PostController(PostService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("posts")
    public String showAllEntries(Model model) {
        model.addAttribute("allPosts", entryService.findAllPosts());
        return "all_posts";
    }

    @GetMapping("posts/{id}")
    public String getPost(@PathVariable long id, Model model) {
        model.addAttribute("post", entryService.findPostById(id));
        return "post_details";
    }

    @PostMapping("posts/savepost")
    public String redirectEntry(Post post) {
        Date currentdate = new Date();
        post.setPublicationDate(currentdate);
        post.setUserId(1); //id musi być pobierane od użytkownika, który aktualnie jest zalogowany
        entryService.addPost(post);
        return "redirect:/posts";
    }

    @PostMapping("posts/updatepost")
    public String updatePost(Post post) {
        Date currentdate = new Date();
        post.setPublicationDate(post.getPublicationDate());
        post.setEditDate(currentdate);
        entryService.addPost(post);
        return "redirect:/posts";
    }


}
