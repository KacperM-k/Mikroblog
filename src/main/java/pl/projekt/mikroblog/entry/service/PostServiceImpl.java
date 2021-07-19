package pl.projekt.mikroblog.entry.service;

import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.entry.entity.Post;
import pl.projekt.mikroblog.entry.repository.PostRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostServiceImpl implements PostService {

    PostRepo entryRepo;

    public PostServiceImpl(PostRepo entryRepo) {
        this.entryRepo = entryRepo;
    }

    @Override
    public List<Post> findAllPosts() {
        return entryRepo.findAll();
    }

    @Override
    public void addPost(Post entry) {
        entryRepo.save(entry);
    }

    @Override
    public void deletePost(long id) {
        entryRepo.deleteById(id);
    }

    @Override
    public Post editPost(long id) {
        return null;
    }

    @Override
    public Optional<Post> findPostById(long id) {
        return entryRepo.findById(id);
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
