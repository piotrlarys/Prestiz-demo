package pl.larys.prestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.larys.prestige.domain.entity.Employee;
import pl.larys.prestige.security.SecurityUser;


/**
 * Created by piotr on 09.07.16.
 */
@Component
public class CustomEmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Employee employee = employeeService.findEmployeeByEmail(userName);

        if (employee == null) {
            throw new UsernameNotFoundException("Employee " + userName + " not found");
        }

        return new SecurityUser(employee);
    }
}
