package pl.larys.prestige.helper;

import java.util.List;

/**
 * Created by piotr on 08.07.16.
 */
public class ActivityInMonth {

    private String name;

    private List<Integer> day;

    public ActivityInMonth() {

    }

    public ActivityInMonth(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDay() {
        return day;
    }

    public void setDay(List<Integer> day) {
        this.day = day;
    }
}
