package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.model.Activity;
import pl.larys.prestige.model.School;
import pl.larys.prestige.repository.ActivityRepository;
import pl.larys.prestige.repository.SchoolRepository;

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

    public School findOne(int id) {
        return schoolRepository.findOne(id);
    }

    public School findOneWithActivities(int id) {
        School school = findOne(id);
        List<Activity> activities = activityRepository.findBySchool(school);
        school.setActivities(activities);
        return school;
    }
}
