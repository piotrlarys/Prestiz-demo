package pl.larys.prestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.larys.prestige.helper.DateConverter;
import pl.larys.prestige.service.ActivityService;
import pl.larys.prestige.service.SchoolService;

/**
 * Created by piotr on 03.07.16.
 */
@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SchoolService schoolService;

    //Employee activity page detail
    @RequestMapping("/zajecia/przedszkole/{id}")
    public String schoolActivityDetail(Model model, @PathVariable int id) {
        model.addAttribute("school", schoolService.findOneWithActivities(id));
        return "school-activity";
    }

    @RequestMapping("/zajecia/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("activity", activityService.findAllStudentsWithActivity(id));
        model.addAttribute("months", new DateConverter().getMonth(activityService.findAllAttendacesWithActivity(id)));

        return "activity-detail";
    }

}
