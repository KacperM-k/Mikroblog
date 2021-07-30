package pl.projekt.mikroblog.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.projekt.mikroblog.DAO.UserDAO;
import pl.projekt.mikroblog.post.entity.Post;
import pl.projekt.mikroblog.post.model.PostDTO;
import pl.projekt.mikroblog.service.UserService;

import java.util.Date;

@Component
public class PostMapper {

    PostService postService;
    UserService userService;
    UserDAO userDAO;

    @Autowired
    public PostMapper(PostService postService, UserDAO userDAO) {
        this.postService = postService;
        this.userDAO = userDAO;
    }

    public Post createNewPost(PostDTO postDTO){
        Post post = new Post();
        Date currentdate = new Date();
        post.setPublicationDate(currentdate);
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setUserName(postDTO.getUserName());
        post.setUserName(userService.getLoggedUsername());
        postService.addPost(post);
        return post;
    }

    public Post updatePost(PostDTO postDTO){
        Post post = new Post();
        Date currentdate = new Date();
        post.setId(postDTO.getId());
        post.setUserName(postDTO.getUserName());
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setPublicationDate(postDTO.getPublicationDate());
        post.setEditDate(currentdate);
        postService.addPost(post);
        return post;
    }

}
