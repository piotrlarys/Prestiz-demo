package pl.larys.prestige.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by piotr on 27.06.16.
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
