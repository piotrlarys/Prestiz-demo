package pl.larys.prestige.domain.entity;



import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by piotr on 23.06.16.
 */

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3)
    private String firstName;

    @Size(min = 3)
    private String lastName;

    private String studentClass;

    @Size(min = 1)
    @Email
    private String email;

    @Size(min = 6)
    private String password;

    @ManyToOne
    @JoinColumn(name = "activities_id")
    private Activity activity;


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

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
