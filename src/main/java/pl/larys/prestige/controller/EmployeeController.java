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

    @ModelAttribute("employee")
    public Employee constructEmployee() {
        return new Employee();
    }

    @ModelAttribute("school")
    public School constructSchool() {
        return new School();
    }

    @RequestMapping("/instruktorzy")
    public String employees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @RequestMapping("/instruktorzy/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("employee", employeeService.findOneWithSchools(id));
        model.addAttribute("schools", schoolService.findAll());
        return "employee-detail";
    }

    @RequestMapping("/zajecia")
    public String activity(Model model, Principal principal) {
        model.addAttribute("employee", employeeService.findEmployeeWithActivities(principal.getName().toString()));
        return "employee-detail";
    }

    @RequestMapping(value = "/instruktorzy", method = RequestMethod.POST)
    public String doAddEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/instruktorzy.html";
    }

//    @RequestMapping(value = "/instruktorzy/{id}", method = RequestMethod.POST)
//    public String doAddSchool(@ModelAttribute("school") School school) {
//        //employeeService.save(employee);
//        return "redirect:/instruktorzy/{id}.html";
//    }

    @RequestMapping(value = "/instruktorzy/remove/{id}")
    public String removeEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/instruktorzy.html";
    }

}
