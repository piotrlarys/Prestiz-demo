package pl.larys.prestige.helper;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import pl.larys.prestige.domain.entity.Attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by piotr on 07.07.16.
 */
public class DateConverter {

    private ActivityInMonth st;
    private ActivityInMonth lut;
    private ActivityInMonth mar;
    private ActivityInMonth kw;
    private ActivityInMonth maj;
    private ActivityInMonth czw;
    private ActivityInMonth lip;
    private ActivityInMonth sier;
    private ActivityInMonth wrz;
    private ActivityInMonth paz;
    private ActivityInMonth lis;
    private ActivityInMonth gru;

    public Date convertDate(String dateString) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dateFormat.parse(dateString);

        return date;
    }

    public List<ActivityInMonth> getAllMonthsNames(List<Attendance> attendances) {

        List<ActivityInMonth> allMonthsName = new ArrayList<>();

        List<LocalDate> allMonths = new ArrayList<>();

        for (Attendance attendance : attendances)
            allMonths.add(new LocalDate(attendance.getDate()));

        LocalDate min = Collections.min(allMonths);
        LocalDate max = Collections.max(allMonths);

        while(min.isBefore(max)){

            if (min.toString("MM").equals("09")) {
                wrz = new ActivityInMonth("Wrzesień");
                allMonthsName.add(wrz);
            }

            if (min.toString("MM").equals("01")) {
                st = new ActivityInMonth("Styczeń");
                allMonthsName.add(st);
            }

            if (min.toString("MM").equals("02")) {
                lut = new ActivityInMonth("Luty");
                allMonthsName.add(lut);
            }

            if (min.toString("MM").equals("03")) {
                mar = new ActivityInMonth("Marzec");
                allMonthsName.add(mar);
            }

            if (min.toString("MM").equals("04")) {
                kw = new ActivityInMonth("Kwiecień");
                allMonthsName.add(kw);
            }

            if (min.toString("MM").equals("05")) {
                maj = new ActivityInMonth("Maj");
                allMonthsName.add(maj);
            }

            if (min.toString("MM").equals("06")) {
                czw = new ActivityInMonth("Czerwiec");
                allMonthsName.add(czw);
            }

            if (min.toString("MM").equals("07")) {
                //lip = new ActivityInMonth("Lipiec");
                //allMonthsName.add(lip);
            }

            if (min.toString("MM").equals("08")) {
                //sier = new ActivityInMonth("Sierpień");
                //allMonthsName.add(sier);
            }



            if (min.toString("MM").equals("10")) {
                paz = new ActivityInMonth("Październik");
                allMonthsName.add(paz);
            }

            if (min.toString("MM").equals("11")) {
                lis = new ActivityInMonth("Listopad");
                allMonthsName.add(lis);
            }

            if (min.toString("MM").equals("12")) {
                gru = new ActivityInMonth("Grudzień");
                allMonthsName.add(gru);
            }
            min = min.plus(Period.months(1));
        }

        return allMonthsName;
    }

    public List<ActivityInMonth> getMonth(List<Attendance> attendances) {

        List<ActivityInMonth> activityInMonths = getAllMonthsNames(attendances);
        List<String> dayWrz = new ArrayList<>();
        List<String> dayPaz = new ArrayList<>();
        List<String> dayLis = new ArrayList<>();
        List<String> dayGru = new ArrayList<>();
        List<String> daySt = new ArrayList<>();
        List<String> dayLu = new ArrayList<>();
        List<String> dayMar = new ArrayList<>();
        List<String> dayKw = new ArrayList<>();
        List<String> dayMaj = new ArrayList<>();
        List<String> dayCz = new ArrayList<>();
        List<String> dayLip = new ArrayList<>();
        List<String> daySier = new ArrayList<>();

        TreeMap<Integer, String> test = new TreeMap<>();

        int month = 0;

        for (Attendance attendance : attendances) {

            DateTime dateTime = new DateTime(attendance.getDate());
            month = dateTime.getMonthOfYear();
            //System.out.println(dateTime.toString("MM"));

            if (month == 1) {
                daySt.add(dateTime.toString("dd"));
                st.setDay(daySt);
            }
            if (month == 2) {
                dayLu.add(dateTime.toString("dd"));
                lut.setDay(dayLu);
            }
            if (month == 3) {
                dayMar.add(dateTime.toString("dd"));
                mar.setDay(dayMar);
            }
            if (month == 4) {
                dayKw.add(dateTime.toString("dd"));
                kw.setDay(dayKw);
            }
            if (month == 5) {
                dayMaj.add(dateTime.toString("dd"));
                maj.setDay(dayMaj);
            }
            if (month == 6) {
                dayCz.add(dateTime.toString("dd"));
                czw.setDay(dayCz);
            }
            if (month == 7) {
                dayLip.add(dateTime.toString("dd"));
                lip.setDay(dayLip);
            }
            if (month == 8) {
                daySier.add(dateTime.toString("dd"));
                sier.setDay(daySier);
            }
            if (month == 9) {
                test.put(dateTime.getDayOfMonth(), dateTime.toString("dd.MM.yyyy"));
                dayWrz.add(dateTime.toString("dd"));
                wrz.setDay(dayWrz);
                wrz.setMapDays(test);
                //wrz.setFullDate(dateTime.toString("dd.MM.yyyy"));
            }
            if (month == 10) {
                dayPaz.add(dateTime.toString("dd"));
                paz.setDay(dayPaz);
            }
            if (month == 11) {
                dayLis.add(dateTime.toString("dd"));
                lis.setDay(dayLis);
            }
            if (month == 12) {
                dayGru.add(dateTime.toString("dd"));
                gru.setDay(dayGru);
            }

        }
        return activityInMonths;
    }



}
