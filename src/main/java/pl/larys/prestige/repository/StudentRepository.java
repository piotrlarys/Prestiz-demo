package pl.larys.prestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.prestige.domain.entity.Activity;
import pl.larys.prestige.domain.entity.Student;

import java.util.List;

/**
 * Created by piotr on 02.07.16.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByActivity(Activity activity);
    Student findById(int id);

}

