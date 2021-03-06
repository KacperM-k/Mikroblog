package pl.projekt.mikroblog.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    String email; // email wyorzystany do komunikacji i powiadoień
    String login;
    String password;
    @Column(name = "display_name")
    String displayName;
    String description; // wyswietlana w opisie uzytkownika
    @Column(name="create_account_date")
    Date createAccountDate;
    String status;      // active, inactive, blocked
    //  File avatar;
    String typ; // public, private lub admin, user

    public User(String email, String login, String password, String displayName, String description, Date createAccountDate, String status, String typ) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.displayName = displayName;
        this.description = description;
        this.createAccountDate = createAccountDate;
        this.status = status;
        //   this.avatar = avatar;
        this.typ = typ;
    }

    public User() {
    }

}

