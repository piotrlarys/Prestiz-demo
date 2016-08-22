package pl.larys.prestige.helper;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by piotr on 08.07.16.
 */
public class ActivityInMonth {

    private String name;

    private List<String> day;

    private List<String> fullDay;

    private TreeMap<Integer, String> mapDays = new TreeMap<>();


    private String fullDate;

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

    public List<String> getDay() {
        return day;
    }

    public void setDay(List<String> day) {
        this.day = day;
    }

    public String getFullDate() {
        return fullDate;
    }

    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }

    public List<String> getFullDay() {
        return fullDay;
    }

    public void setFullDay(List<String> fullDay) {
        this.fullDay = fullDay;
    }

    public TreeMap<Integer, String> getMapDays() {
        return mapDays;
    }

    public void setMapDays(TreeMap<Integer, String> mapDays) {
        this.mapDays = mapDays;
    }
}
