package pl.larys.prestige.domain.entity;

import javax.persistence.*;

/**
 * Created by piotr on 15.08.16.
 */
@Entity
public class Presence {

    @Id
    @GeneratedValue
    private long id;

    private boolean presence;

    private String date;

    @ManyToOne
    @JoinColumn
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
