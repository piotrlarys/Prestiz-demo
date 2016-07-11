package pl.larys.prestige.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by piotr on 09.07.16.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {

        return "login";
    }

}
