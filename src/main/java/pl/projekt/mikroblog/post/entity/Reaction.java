package pl.projekt.mikroblog.post.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long amount;
    @Column(name = "user_name")
    String userName;

    public Reaction() {
    }
}
