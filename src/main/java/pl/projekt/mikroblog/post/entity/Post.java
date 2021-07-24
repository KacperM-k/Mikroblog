package pl.projekt.mikroblog.post.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "user_name")
    String userName;
    @Column(name = "title")
    @NotNull
    @Size(min = 2, max = 160)
    String title;
    @Column(name = "description")
    @NotNull
    @Size(min = 2, max = 1600)
    String description;
    @Column(name = "publication_date")
    Date publicationDate;
    @Column(name = "edit_date")
    Date editDate;
    // lista komentarzy 1-to-many
    @OneToMany
    List<Comment> commentsList;

    public Post() {
    }

    public Post(String userId, String title, String description, Date publicationDate, Date editDate, List commentsList) {
        this.userName = userId;
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.editDate = editDate;
        this.commentsList = commentsList;
    }

}
