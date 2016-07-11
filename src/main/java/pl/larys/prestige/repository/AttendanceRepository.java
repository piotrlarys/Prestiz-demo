package pl.larys.prestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.prestige.model.Activity;
import pl.larys.prestige.model.Attendance;

import java.util.List;

/**
 * Created by piotr on 07.07.16.
 */
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findByActivity(Activity activity);

}
