package pl.larys.prestige.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.domain.entity.Presence;
import pl.larys.prestige.domain.entity.Student;
import pl.larys.prestige.domain.json.AjaxPresence;
import pl.larys.prestige.repository.PresenceRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by piotr on 15.08.16.
 */
@Service
public class PresenceService {

    @Autowired
    private PresenceRepository presenceRepository;

    @Autowired
    private StudentService studentService;

    public void maintainPresence(AjaxPresence ajaxPresence) {
        List<Presence> presences = findAllPresencesWithStudent(studentService.findStudentById(ajaxPresence.getId()));

        if (presences.isEmpty())
            save(ajaxPresence);

        presences
                .forEach(it -> {
                    if ((it.getDate()).equals(ajaxPresence.getDate())) {
                        if (it.isPresence()) {
                            it.setPresence(false);
                            presenceRepository.save(it);
                        } else presenceRepository.delete(it.getId());
                    }
                });
    }

    private void save(AjaxPresence ajaxPresence) {
        Student student = studentService.findStudentById(ajaxPresence.getId());
        Presence presence = new Presence();
        presence.setDate(ajaxPresence.getDate());
        presence.setPresence(true);
        presence.setStudent(student);
        presenceRepository.save(presence);
    }

//    public void delete(AjaxPresence ajaxPresence) {
//        List<Presence> presences = findAllPresencesWithStudent(studentService.findStudentById(ajaxPresence.getId()));
//        presences.stream().filter(p -> p
//                .getDate().equals(ajaxPresence.getDate()))
//                .forEach(p -> presenceRepository.delete(p.getId()));
//    }

    private List<Presence> findAllPresencesWithStudent(Student student) {
        return presenceRepository.findPresencesByStudent(student);
    }


}
