package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.larys.prestige.model.*;
import pl.larys.prestige.repository.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 02.07.16.
 */
@Transactional
@Service
public class InitDBService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void init() {

        Role roleEmployee = new Role();
        roleEmployee.setName("ROLE_EMPLOYEE");
        //roleRepository.save(roleEmployee);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        //roleRepository.save(roleAdmin);

        Employee employee = new Employee();
        employee.setFirstName("Piotr");
        employee.setLastName("Larys");
        employee.setEmail("piotr.larys@gmail.com");
        employee.setPhone("795030797");
        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleEmployee);
        //employee.setRoles(roles);
        employeeRepository.save(employee);

        School school1 = new School();
        school1.setName("Przedszkole nr 1");
        school1.setAddress("ul. Prosta 21");
        school1.setEmployee(employee);
        schoolRepository.save(school1);

        Activity activity1 = new Activity();
        activity1.setName("Grupa 15:30");
        activity1.setSchool(school1);
        activityRepository.save(activity1);

        Activity activity2 = new Activity();
        activity2.setName("Grupa 16:30");
        activity2.setSchool(school1);
        activityRepository.save(activity1);

        School school2 = new School();
        school2.setName("Przedszkole nr 2");
        school2.setAddress("ul. Krzywa 13");
        school2.setEmployee(employee);
        schoolRepository.save(school2);

        Student student1 = new Student();
        student1.setFirstName("Artur");
        student1.setLastName("Sieczka");
        student1.setStudentClass("3");
        student1.setActivity(activity1);
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setFirstName("Oskar");
        student2.setLastName("Zbroja");
        student2.setStudentClass("2");
        student2.setActivity(activity1);
        studentRepository.save(student2);

    }


}
