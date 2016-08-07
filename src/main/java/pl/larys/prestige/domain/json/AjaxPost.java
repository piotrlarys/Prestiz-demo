package pl.larys.prestige.domain.json;

/**
 * Created by piotr on 07.08.16.
 */
public class AjaxPost {

    private int employeeId;

    private int schoolId;

    private String index;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }
}
