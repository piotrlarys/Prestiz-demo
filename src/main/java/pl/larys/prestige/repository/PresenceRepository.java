package pl.larys.prestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.prestige.domain.entity.Presence;
import pl.larys.prestige.domain.entity.Student;

import java.util.List;

/**
 * Created by piotr on 02.07.16.
 */
public interface PresenceRepository extends JpaRepository<Presence, Long> {

    List<Presence> findPresencesByStudent(Student student);

    Presence findPresenceByDate(String date);

}
