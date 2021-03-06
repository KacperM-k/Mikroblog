package pl.projekt.mikroblog.post.service;

import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.post.entity.Post;
import pl.projekt.mikroblog.post.repository.PostRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostServiceImpl implements PostService {

    PostRepo postRepo;

    public PostServiceImpl(PostRepo entryRepo) {
        this.postRepo = entryRepo;
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public void addPost(Post entry) {
        postRepo.save(entry);
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Post editPost(long id, Post post) {
        findPostById(id).setDescription(post.getDescription());
        findPostById(id).setTitle(post.getTitle());
        return findPostById(id);
    }

    @Override
    public Post findPostById(long id) {
        Optional<Post> postOptional = postRepo.findById(id);
        return postOptional.get();
    }

    @Override
    public List<Post> findPostByTitle(String title) {
        List<Post> allEntries = findAllPosts();
        return allEntries.stream().filter(entry -> entry.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<Post> findPostByPublicationDate(Date date) {
        List<Post> allEntries = findAllPosts();
        return allEntries.stream().filter(entry -> entry.getPublicationDate() == date).collect(Collectors.toList());
    }
}
