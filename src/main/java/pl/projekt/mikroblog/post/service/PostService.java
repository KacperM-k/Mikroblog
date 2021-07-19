package pl.projekt.mikroblog.post.service;

import pl.projekt.mikroblog.post.entity.Post;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAllPosts();
    void addPost(Post entry);
    void deletePost(long id);
    Post editPost(long id, Post post);
    Post findPostById(long id);
    List<Post> findPostByTitle(String title);
    List<Post> findPostByPublicationDate(Date date);




}
