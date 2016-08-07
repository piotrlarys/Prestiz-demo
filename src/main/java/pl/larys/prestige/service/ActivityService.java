package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.larys.prestige.domain.entity.Activity;
import pl.larys.prestige.domain.entity.Attendance;
import pl.larys.prestige.domain.entity.Student;
import pl.larys.prestige.repository.ActivityRepository;
import pl.larys.prestige.repository.AttendanceRepository;
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

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Activity findOne(int id) {
        return activityRepository.findOne(id);
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Transactional
    public Activity findAllStudentsWithActivity(int id) {
        Activity activity = findOne(id);
        List<Student> students = studentRepository.findByActivity(activity);
        activity.setStudents(students);
        return activity;
    }

    @Transactional
    public List<Attendance> findAllAttendacesWithActivity(int id) {
        Activity activity = findOne(id);
        List<Attendance> attendances = attendanceRepository.findByActivity(activity);

        return attendances;
    }
}
