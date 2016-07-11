package pl.larys.prestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.larys.prestige.service.EmployeeService;
import pl.larys.prestige.service.SchoolService;

import java.security.Principal;

/**
 * Created by piotr on 02.07.16.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    SchoolService schoolService;

    @RequestMapping("/instruktorzy")
    public String employees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @RequestMapping("/instruktorzy/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("employee", employeeService.findOneWithSchools(id));
        return "employee-detail";
    }

    @RequestMapping("/zajecia")
    public String activity(Model model, Principal principal) {
        model.addAttribute("employee", employeeService.findEmployeeWithActivities(principal.getName().toString()));
        return "employee-detail";
    }

}
