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
import pl.projekt.mikroblog.post.model.PostDTO;
import pl.projekt.mikroblog.post.service.CommentService;
import pl.projekt.mikroblog.post.service.PostMapper;
import pl.projekt.mikroblog.post.service.PostService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class PostController {

    PostService postService;
    CommentService commentService;
    UserDAO userDAO;
    PostMapper postMapper;

    @Autowired
    public PostController(PostService postService, CommentService commentService, UserDAO userDAO, PostMapper postMapper) {
        this.postService = postService;
        this.commentService = commentService;
        this.userDAO = userDAO;
        this.postMapper = postMapper;
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
    public String redirectEntry(@Valid PostDTO postDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "post_creator";
        }
        postMapper.createNewPost(postDTO);
        return "redirect:/posts";
    }

    @PostMapping("posts/updatepost")
    public String updatePost(PostDTO postDTO) {
        postMapper.updatePost(postDTO);
        return "redirect:/posts";
    }

    @GetMapping("posts/delete/{id}")//post mozna usunąć tylko w tedy gdy nie ma komentarzy, trzeba dodać opcjęusuwania komantarzy
    public String deletePost(@PathVariable long id){
        commentService.deleteCommentByPostID(id);
        postService.deletePost(id);
        return "redirect:/posts";
    }


}
