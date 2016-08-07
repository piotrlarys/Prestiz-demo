package pl.larys.prestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.prestige.domain.entity.Activity;
import pl.larys.prestige.domain.entity.School;

import java.util.List;

/**
 * Created by piotr on 02.07.16.
 */
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    List<Activity> findBySchool(School school);

}
