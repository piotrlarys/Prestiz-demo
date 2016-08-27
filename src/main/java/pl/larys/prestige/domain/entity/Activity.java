package pl.larys.prestige.domain.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by piotr on 23.06.16.
 */
@Entity
public class Activity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "activity")
    private List<Student> students;

    @OneToMany(mappedBy = "activity")
    private List<Attendance> attendances;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }
}
