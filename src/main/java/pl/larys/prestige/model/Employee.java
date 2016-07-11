package pl.larys.prestige.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by piotr on 02.07.16.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3)
    private String firstName;

    @Size(min = 3)
    private String lastName;

    @Size(min = 1)
    @Email
    private String email;

    @Size(min = 6)
    private String password;

    private String phone;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    @OneToMany(mappedBy = "employee")
    private List<School> schools;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

}
