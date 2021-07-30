package pl.projekt.mikroblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.projekt.mikroblog.DAO.UserDAO;
import pl.projekt.mikroblog.service.UserService;
import pl.projekt.mikroblog.user.User;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    //    @Autowired
    UserService userService;
    UserDAO userDAO;

    @Autowired
    public UserController(UserService userService, UserDAO userDAO) {
        this.userService = userService;
        this.userDAO = userDAO;
    }

    @GetMapping("/users_details")
    public String getUsersDetails(Model model) {  // , @RequestParam String login
        // Optional<User> user = userService.findByLogin(login);
        User user = new User("email@wp.pl", "userlogin", "password", "blogger for medicine", "like brake bones", new Date(2021 - 07 - 18), "active", "USER");
        model.addAttribute("usersDetails", user);
        return "user_details";
    }

    @GetMapping("find_by_login")
    public String findUserByLogin(@RequestParam("login") String login, Model model) {
        Optional<User> byLogin = userService.findByLogin(login);
        model.addAttribute("userByLogin", byLogin);
        return "user_by_login";
    }

    @GetMapping("/all_users")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allUsersList", allUsers);
        return "users_list";
    }

    @GetMapping("/edit_form/{login}")
    public String editUserDetails(@PathVariable String login, Model model) {
        User actualLogged = userService.getActualLogged();
       //   model.getAttribute("actualLogged", actualLogged);
        Optional<User> byLogin = userService.findByLogin(login);
        // sposób 1
        byLogin.ifPresent(user -> model.addAttribute("userEdited", user));
        // sposób 2
//        User user = byLogin.orElse(new User());
//        model.addAttribute("userEdited", user);
//        // sposób 3
//        User user1 = byLogin.orElseThrow(()->new RuntimeException());
//        model.addAttribute("userEdited", user1);
        return "edit_user_form";
    }

    @PostMapping("/correct_user")
    public String editedDetailsFromForm(@Valid User user, BindingResult result) {
// bindingResult jest do obsługi errorów
        //   user.setCreateAccountDate(user.getCreateAccountDate());
        userService.addUser(user);
        return "redirect:/users_details";
    }

    @GetMapping("/my_account")
    public String myAccount(Model model) {
        User actualLogged = userService.getActualLogged();
        model.addAttribute("myUserAccount", actualLogged);
        return "user_account";
    }
}
