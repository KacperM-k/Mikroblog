package pl.projekt.mikroblog.entry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.projekt.mikroblog.entry.entity.Post;
import pl.projekt.mikroblog.entry.service.PostService;

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

    @PostMapping("posts/savepost")
    public String redirectEntry(Post entry){
        Date currentdate = new Date();
        entry.setPublicationDate(currentdate);
        entry.setUserId(1); //id musi być pobierane od użytkownika, który aktualnie jest zalogowany
        entryService.addPost(entry);
        return"redirect:/posts";
    }






}
