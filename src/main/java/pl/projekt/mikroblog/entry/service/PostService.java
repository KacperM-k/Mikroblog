package pl.projekt.mikroblog.entry.service;

import pl.projekt.mikroblog.entry.entity.Post;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAllPosts();
    void addPost(Post entry);
    void deletePost(long id);
    Post editPost(long id);
    Optional<Post> findPostById(long id);
    List<Post> findPostByTitle(String title);
    List<Post> findPostByPublicationDate(Date date);




}
