package pl.projekt.mikroblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.projekt.mikroblog.service.UserService;
import pl.projekt.mikroblog.user.User;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class UserCreatorController {

    UserService userService;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserCreatorController(UserService userService,PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder=passwordEncoder;
    }

    @GetMapping("/account/new")
    public String addNewUser(Model model, User user) {
        model.addAttribute("newUser", new User());
        return "user_creator";
    }

    @PostMapping("/new_user")
    public String addNewUserAccount(@Valid User user) {
        for (User user1 : userService.findAllUsers()) {
            if (user.getLogin().equals(user1.getLogin()))
                return "User is not unique!";
        } // do poprawki

        Date date = new Date();
        user.setCreateAccountDate(date);
        user.setStatus("Active");
        user.setTyp("user");
     //   user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/login";
    }
}
