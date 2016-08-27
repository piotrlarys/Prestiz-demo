package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.domain.entity.Student;
import pl.larys.prestige.repository.StudentRepository;

/**
 * Created by piotr on 03.07.16.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private PresenceService presenceService;

    public Student findStudentById(int id) {
        return studentRepository.findById(id);
    }




}
