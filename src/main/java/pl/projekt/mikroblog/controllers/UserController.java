package pl.projekt.mikroblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.projekt.mikroblog.user.User;

import java.util.Date;

@Controller
public class UserController {

    @GetMapping("/users_details")
    public String getUsersDetails(Model model){
        User user = new User("email@wp.pl","userlogin","password","blogger for medicine", "like brake bones", new Date(2021-07-18), "active", "USER");
        model.addAttribute("users_details", user);
        return "user_details";
    }



}
