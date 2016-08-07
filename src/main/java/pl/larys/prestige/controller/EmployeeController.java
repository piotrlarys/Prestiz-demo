package pl.larys.prestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.larys.prestige.domain.entity.Employee;
import pl.larys.prestige.domain.entity.School;
import pl.larys.prestige.domain.json.AjaxPost;
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
        model.addAttribute("schools", schoolService.findAllFreeSchools());
        return "employees";
    }

    @RequestMapping("/instruktorzy/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("employee", employeeService.findOneWithSchools(id));
        model.addAttribute("schools", schoolService.findAllFreeSchools());
        System.out.println(schoolService.findAllFreeSchools());
        return "employee-detail";
    }

    @RequestMapping("/zajecia")
    public String activity(Model model, Principal principal) {
        model.addAttribute("employee", employeeService.findEmployeeWithActivities(principal.getName()));
        return "employee-detail";
    }

    @RequestMapping(value = "/instruktorzy", method = RequestMethod.POST)
    public String doAddEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/instruktorzy.html";
    }

    @RequestMapping(value = "/instruktorzy/addschool", method = RequestMethod.POST)
    @ResponseBody
    public String addSchoolToEmployee(@RequestBody AjaxPost postData) {
        schoolService.setSchoolToEmployee(postData.getSchoolId(), employeeService.findOne(postData.getEmployeeId()));
        return postData.getIndex();
    }


    @RequestMapping(value = "/instruktorzy/remove/{id}")
    public String removeEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/instruktorzy.html";
    }

    @RequestMapping(value = "/instruktorzy/przedszkole/remove/{id}")
    public String removeSchoolFromEmployee(@PathVariable int id) {
        schoolService.deleteSchoolFromEmployee(id);
        return "redirect:/instruktorzy.html";
    }

}
