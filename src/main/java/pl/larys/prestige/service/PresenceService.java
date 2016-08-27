package pl.larys.prestige.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.domain.entity.Presence;
import pl.larys.prestige.domain.entity.Student;
import pl.larys.prestige.domain.json.AjaxPresence;
import pl.larys.prestige.repository.PresenceRepository;

import java.util.List;

/**
 * Created by piotr on 15.08.16.
 */
@Service
public class PresenceService {

    @Autowired
    private PresenceRepository presenceRepository;

    @Autowired
    private StudentService studentService;

    public String save(AjaxPresence ajaxPresence) {
        Student student = studentService.findStudentById(ajaxPresence.getId());
        Presence presence = new Presence();
        presence.setDate(ajaxPresence.getDate());
        presence.setPresence(true);
        presence.setStudent(student);
        presenceRepository.save(presence);
        return new Gson().toJson(ajaxPresence);
    }

    public String delete(AjaxPresence ajaxPresence) {
        List<Presence> presences = findAllPresencesWithStudent(studentService.findStudentById(ajaxPresence.getId()));
        presences.stream().filter(p -> p
                .getDate().equals(ajaxPresence.getDate()))
                .forEach(p -> presenceRepository.delete(p.getId()));
        return new Gson().toJson(ajaxPresence);
    }

    public List<Presence> findAllPresencesWithStudent(Student student) {
        return presenceRepository.findPresencesByStudent(student);
    }


}
