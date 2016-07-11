package pl.larys.prestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.larys.prestige.model.Employee;
import pl.larys.prestige.model.School;
import pl.larys.prestige.service.ActivityService;
import pl.larys.prestige.service.EmployeeService;
import pl.larys.prestige.service.SchoolService;

/**
 * Created by piotr on 03.07.16.
 */
@Controller
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("school")
    public School constructSchool() {
        return new School();
    }


    //Admin page school list
    @RequestMapping("/przedszkola")
    public String allSchools(Model model) {
        model.addAttribute("schools", schoolService.findAll());
        return "school";
    }

    @RequestMapping("/przedszkola/{id}")
    public String schoolDetail(Model model, @PathVariable int id) {
        model.addAttribute("employee", employeeService.findOneWithSchools(id));
        model.addAttribute("school", schoolService.findOne(id));
        return "school-detail";
    }

    @RequestMapping(value = "/przedszkola", method = RequestMethod.POST)
    public String doAddSchool(@ModelAttribute("school") School school) {
        schoolService.save(school);
        return "redirect:/przedszkola.html";
    }



}
