package pl.projekt.mikroblog.entry.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "entry")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "user_id")
    long userId;
    @Column(name = "title")
    String title;
    @Column(name = "description")
    String description;
    @Column(name = "publication_date")
    Date publicationDate;
    @Column(name = "edit_date")
    Date editDate;

    public Post() {
    }

    public Post(long userId, String title, String description, Date publicationDate, Date editDate) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.editDate = editDate;
    }

}
