package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.domain.entity.Presence;
import pl.larys.prestige.domain.entity.Student;
import pl.larys.prestige.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 03.07.16.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findStudentById(int id) {
        return studentRepository.findById(id);
    }

    public List<Presence> findPresencesWithStudent(int id) {
        Student student = studentRepository.findById(id);
        List<Presence> presences = student.getPresences();
//        List<String> responsePresences = new ArrayList<>();
//        for (Presence presence : presences) {
//            responsePresences.add(presence.getDate());
//        }
        return presences;
    }

}
