package pl.larys.prestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.prestige.model.Employee;
import pl.larys.prestige.model.School;

import java.util.List;

/**
 * Created by piotr on 02.07.16.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByEmail(String email);


    //Employee findByEmployee(School school);
}
