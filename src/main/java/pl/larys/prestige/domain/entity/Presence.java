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

    //@Column(unique = true)
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

    @Override
    public String toString() {
        return "Presence{" +
                "id=" + id +
                ", presence=" + presence +
                ", date='" + date + '\'' +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Presence presence1 = (Presence) o;

        if (id != presence1.id) return false;
        if (presence != presence1.presence) return false;
        if (!date.equals(presence1.date)) return false;
        return student.equals(presence1.student);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (presence ? 1 : 0);
        result = 31 * result + date.hashCode();
        result = 31 * result + student.hashCode();
        return result;
    }
}
