package pl.projekt.mikroblog.post.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;



@Getter
@Setter
@ToString
public class PostDTO {

    long id;
    String userName;
    @NotNull
    @Size(min = 2, max = 160)
    String title;
    @NotNull
    @Size(min = 2, max = 1600)
    String description;
    Date publicationDate;
    Date editDate;

    public PostDTO() {
    }

    public PostDTO(String userName, String title, String description, Date publicationDate, Date editDate) {
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.editDate = editDate;
    }
}

