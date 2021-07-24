package pl.projekt.mikroblog.post.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Table(name = "comments")
@Entity
@Getter
@Setter
@ToString
public class Comment {
    // wartości jak w db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;
    @Column(name = "post_id")
    private int postID;
    @Column(name = "comment_author")
    private String commentAuthor;
    @Column(name = "comment_date")
    private Date commentDate;
    @Column(name = "comment_text")
    private String commentText;

    public Comment() {

    }

    public Comment(long id, int postID, String commentAuthor, Date commentDate, String commentText) {
        this.id = id;
        this.postID = postID;
        this.commentAuthor = commentAuthor;
        this.commentDate = commentDate;
        this.commentText = commentText;
    }
}
