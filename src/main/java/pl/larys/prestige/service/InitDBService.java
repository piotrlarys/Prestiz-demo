package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.larys.prestige.domain.entity.*;
import pl.larys.prestige.helper.DateConverter;
import pl.larys.prestige.repository.*;

import javax.annotation.PostConstruct;
import java.text.ParseException;
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

    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostConstruct
    public void init() throws ParseException {



        Role roleEmployee = new Role();
        roleEmployee.setName("ROLE_EMPLOYEE");
        roleRepository.save(roleEmployee);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        Employee employee = new Employee();
        employee.setFirstName("Piotr");
        employee.setLastName("Larys");
        employee.setEmail("piotr.larys@gmail.com");
        employee.setPhone("795030797");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        employee.setPassword("welcome");
        List<Role> roles = new ArrayList<>();
        //roles.add(roleAdmin);
        roles.add(roleEmployee);
        employee.setRoles(roles);
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Justin");
        employee2.setLastName("Case");
        employee2.setEmail("justin.case@gmail.com");
        employee2.setPhone("795030797");
        BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
        employee2.setPassword("admin");
        List<Role> roles1 = new ArrayList<>();
        roles1.add(roleAdmin);
        employee2.setRoles(roles1);
        employeeRepository.save(employee2);

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


        Attendance wt7 = new Attendance();
        wt7.setDate(new DateConverter().convertDate("07.09.2015"));
        wt7.setActivity(activity1);
        attendanceRepository.save(wt7);

        Attendance wt14 = new Attendance();
        wt14.setDate(new DateConverter().convertDate("14.09.2015"));
        wt14.setActivity(activity1);
        attendanceRepository.save(wt14);

        Attendance wt21 = new Attendance();
        wt21.setDate(new DateConverter().convertDate("21.09.2015"));
        wt21.setActivity(activity1);
        attendanceRepository.save(wt21);

        Attendance wt28 = new Attendance();
        wt28.setDate(new DateConverter().convertDate("28.09.2015"));
        wt28.setActivity(activity1);
        attendanceRepository.save(wt28);



        Attendance paz02 = new Attendance();
        paz02.setDate(new DateConverter().convertDate("02.10.2015"));
        paz02.setActivity(activity1);
        attendanceRepository.save(paz02);

        Attendance paz11 = new Attendance();
        paz11.setDate(new DateConverter().convertDate("11.10.2015"));
        paz11.setActivity(activity1);
        attendanceRepository.save(paz11);

        Attendance paz18 = new Attendance();
        paz18.setDate(new DateConverter().convertDate("18.10.2015"));
        paz18.setActivity(activity1);
        attendanceRepository.save(paz18);

        Attendance lis03 = new Attendance();
        lis03.setDate(new DateConverter().convertDate("03.11.2015"));
        lis03.setActivity(activity1);
        attendanceRepository.save(lis03);

        Attendance lis10 = new Attendance();
        lis10.setDate(new DateConverter().convertDate("10.11.2015"));
        lis10.setActivity(activity1);
        attendanceRepository.save(lis10);

        Attendance gru04 = new Attendance();
        gru04.setDate(new DateConverter().convertDate("04.12.2015"));
        gru04.setActivity(activity1);
        attendanceRepository.save(gru04);

        Attendance gru11 = new Attendance();
        gru11.setDate(new DateConverter().convertDate("11.12.2015"));
        gru11.setActivity(activity1);
        attendanceRepository.save(gru11);

        Attendance gru18 = new Attendance();
        gru18.setDate(new DateConverter().convertDate("18.12.2015"));
        gru18.setActivity(activity1);
        attendanceRepository.save(gru18);

        Attendance st05 = new Attendance();
        st05.setDate(new DateConverter().convertDate("05.01.2016"));
        st05.setActivity(activity1);
        attendanceRepository.save(st05);

        Attendance st18 = new Attendance();
        st18.setDate(new DateConverter().convertDate("18.01.2016"));
        st18.setActivity(activity1);
        attendanceRepository.save(st18);

        Attendance lut20 = new Attendance();
        lut20.setDate(new DateConverter().convertDate("20.02.2016"));
        lut20.setActivity(activity1);
        attendanceRepository.save(lut20);

        Attendance mar10 = new Attendance();
        mar10.setDate(new DateConverter().convertDate("10.03.2016"));
        mar10.setActivity(activity1);
        attendanceRepository.save(mar10);

        Attendance mar17 = new Attendance();
        mar17.setDate(new DateConverter().convertDate("17.03.2016"));
        mar17.setActivity(activity1);
        attendanceRepository.save(mar17);

        Attendance mar25 = new Attendance();
        mar25.setDate(new DateConverter().convertDate("25.03.2016"));
        mar25.setActivity(activity1);
        attendanceRepository.save(mar25);

        Attendance kw12 = new Attendance();
        kw12.setDate(new DateConverter().convertDate("12.04.2016"));
        kw12.setActivity(activity1);
        attendanceRepository.save(kw12);

        Attendance kw20 = new Attendance();
        kw20.setDate(new DateConverter().convertDate("20.04.2016"));
        kw20.setActivity(activity1);
        attendanceRepository.save(kw20);

        Attendance kw25 = new Attendance();
        kw25.setDate(new DateConverter().convertDate("25.04.2016"));
        kw25.setActivity(activity1);
        attendanceRepository.save(kw25);

        Attendance kw29 = new Attendance();
        kw29.setDate(new DateConverter().convertDate("29.04.2016"));
        kw29.setActivity(activity1);
        attendanceRepository.save(kw29);

        Attendance maj01 = new Attendance();
        maj01.setDate(new DateConverter().convertDate("01.05.2016"));
        maj01.setActivity(activity1);
        attendanceRepository.save(maj01);

        Attendance maj13 = new Attendance();
        maj13.setDate(new DateConverter().convertDate("13.05.2016"));
        maj13.setActivity(activity1);
        attendanceRepository.save(maj13);

        Attendance maj24 = new Attendance();
        maj24.setDate(new DateConverter().convertDate("24.05.2016"));
        maj24.setActivity(activity1);
        attendanceRepository.save(maj24);

        Attendance cz01 = new Attendance();
        cz01.setDate(new DateConverter().convertDate("01.06.2016"));
        cz01.setActivity(activity1);
        attendanceRepository.save(cz01);

        Attendance cz12 = new Attendance();
        cz12.setDate(new DateConverter().convertDate("12.06.2016"));
        cz12.setActivity(activity1);
        attendanceRepository.save(cz12);

        Attendance cz19 = new Attendance();
        cz19.setDate(new DateConverter().convertDate("19.06.2016"));
        cz19.setActivity(activity1);
        attendanceRepository.save(cz19);




    }


}
