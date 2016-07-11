package pl.larys.prestige.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by piotr on 23.06.16.
 */
@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "school")
    private List<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
