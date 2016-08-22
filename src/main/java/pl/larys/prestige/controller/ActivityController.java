package pl.larys.prestige.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.larys.prestige.domain.entity.Activity;
import pl.larys.prestige.domain.entity.Presence;
import pl.larys.prestige.domain.entity.Student;
import pl.larys.prestige.domain.json.AjaxPresence;
import pl.larys.prestige.helper.DateConverter;
import pl.larys.prestige.service.ActivityService;
import pl.larys.prestige.service.PresenceService;
import pl.larys.prestige.service.SchoolService;
import pl.larys.prestige.service.StudentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by piotr on 03.07.16.
 */
@Controller
@EnableWebMvc
public class ActivityController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private PresenceService presenceService;

    //Employee activity page detail
    @RequestMapping("/zajecia/przedszkole/{id}")
    public String schoolActivityDetail(Model model, @PathVariable int id) {
        model.addAttribute("school", schoolService.findOneWithActivities(id));
        return "school-activity";
    }

    @RequestMapping("/zajecia/{id}")
    public String detail(Model model, @PathVariable int id) {

        Activity allStudentsWithActivity = activityService.findAllStudentsWithActivity(id);
        List<Student> students = allStudentsWithActivity.getStudents();


//        for (Student student : students) {
//
//            List<Presence> allPresencesWithStudent = presenceService.findAllPresencesWithStudent(student);
//            System.out.println(allPresencesWithStudent);
//            //System.out.println(student.getPresences());
//        }
        //model.addAttribute("presences", presenceService)
        model.addAttribute("activity", activityService.findAllStudentsWithActivity(id));
        model.addAttribute("months", new DateConverter().getMonth(activityService.findAllAttendacesWithActivity(id)));

        return "activity-detail";
    }

    @RequestMapping(value = "/zajecia/addpresence", method = RequestMethod.POST)
    public @ResponseBody String addPresence(@RequestBody AjaxPresence ajaxPresence) {
        //presenceService.save(ajaxPresence.getDate(), ajaxPresence.getId());
        //List<Presence> strings = studentService.findPresencesWithStudent(ajaxPresence.getId());



        return presenceService.save(ajaxPresence.getDate(), ajaxPresence.getId());
    }

}
