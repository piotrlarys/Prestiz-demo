package pl.larys.prestige.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.domain.entity.Presence;
import pl.larys.prestige.domain.entity.Student;
import pl.larys.prestige.domain.json.PresenceJsonResponse;
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

    public String save(String date, int id) {
        Student student = studentService.findStudentById(id);
        Presence presence = new Presence();
        presence.setDate(date);
        presence.isPresence();
        presence.setStudent(student);
        presenceRepository.save(presence);

        PresenceJsonResponse jsonResponse = new PresenceJsonResponse();
        jsonResponse.setId(id);
        jsonResponse.setDate(date);

        String json = new Gson().toJson(jsonResponse);
        return json;
    }

    public List<Presence> findAllPresencesWithStudent(Student student) {
        List<Presence> presences = presenceRepository.findPresencesByStudent(student);
        return presences;
    }



}
