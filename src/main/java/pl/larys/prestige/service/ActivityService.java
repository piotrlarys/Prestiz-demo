package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.model.Activity;
import pl.larys.prestige.model.Student;
import pl.larys.prestige.repository.ActivityRepository;
import pl.larys.prestige.repository.StudentRepository;

import java.util.List;

/**
 * Created by piotr on 03.07.16.
 */
@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Activity findOne(int id) {
        return activityRepository.findOne(id);
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity findAllStudentsWithActivity(int id) {
        Activity activity = findOne(id);
        List<Student> students = studentRepository.findByActivity(activity);
        activity.setStudents(students);
        return activity;
    }
}
