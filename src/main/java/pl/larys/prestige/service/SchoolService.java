package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.domain.entity.Activity;
import pl.larys.prestige.domain.entity.Employee;
import pl.larys.prestige.domain.entity.School;
import pl.larys.prestige.repository.ActivityRepository;
import pl.larys.prestige.repository.SchoolRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 03.07.16.
 */
@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public List<School> findAllFreeSchools() {

        List<School> schools = schoolRepository.findAll();
        List<School> freeSchoolList = new ArrayList<>();

        for (School school: schools) {
            if (school.getEmployee() == null)
                freeSchoolList.add(school);
        }
        return freeSchoolList;
    }

    public School findOne(int id) {
        return schoolRepository.findOne(id);
    }

    public School findOneWithActivities(int id) {
        School school = findOne(id);
        List<Activity> activities = activityRepository.findBySchool(school);
        school.setActivities(activities);
        return school;
    }

    public void save(School school) {
        schoolRepository.save(school);
    }

    public void deleteSchoolFromEmployee(int id) {
        School school = schoolRepository.findOne(id);
        school.setEmployee(null);
        schoolRepository.save(school);
    }

    public void setSchoolToEmployee(int id, Employee employee) {
        School school = schoolRepository.findOne(id);
        school.setEmployee(employee);
        schoolRepository.save(school);
    }
}
