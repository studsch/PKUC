package main.controllers;

import main.User;
import main.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegistrationController {

    private final UserDao userDao;

    @Autowired
    public RegistrationController(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(@ModelAttribute("user") User user) {
        boolean check = this.userDao.createUser(user);
        if (check)
            return "redirect:/";
        else
            return "redirect:/registration";
    }

}
