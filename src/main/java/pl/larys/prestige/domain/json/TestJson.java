package pl.larys.prestige.domain.json;

import java.util.List;

/**
 * Created by piotr on 24.08.16.
 */
public class TestJson {

    private int studentId;

    private List<String> dates;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }
}
