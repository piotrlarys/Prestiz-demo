package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.prestige.model.Employee;
import pl.larys.prestige.model.School;
import pl.larys.prestige.repository.EmployeeRepository;
import pl.larys.prestige.repository.SchoolRepository;

import java.util.List;

/**
 * Created by piotr on 02.07.16.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findOne(int id) {
        return employeeRepository.findOne(id);
    }

    public Employee findOneWithSchools(int id) {
        Employee employee = findOne(id);
        List<School> schools = schoolRepository.findByEmployee(employee);
        employee.setSchools(schools);
        return employee;
    }
}
