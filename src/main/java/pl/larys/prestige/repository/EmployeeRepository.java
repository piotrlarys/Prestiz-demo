package pl.larys.prestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.prestige.model.Employee;

/**
 * Created by piotr on 02.07.16.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
