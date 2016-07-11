package pl.larys.prestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.larys.prestige.service.ActivityService;

/**
 * Created by piotr on 03.07.16.
 */
@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/zajecia/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("activity", activityService.findAllStudentsWithActivity(id));
        return "activity-detail";
    }

}
