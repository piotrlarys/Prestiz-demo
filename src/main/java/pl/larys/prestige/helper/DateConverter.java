package pl.larys.prestige.helper;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import pl.larys.prestige.domain.entity.Attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
        List<Integer> dayWrz = new ArrayList<>();
        List<Integer> dayPaz = new ArrayList<>();
        List<Integer> dayLis = new ArrayList<>();
        List<Integer> dayGru = new ArrayList<>();
        List<Integer> daySt = new ArrayList<>();
        List<Integer> dayLu = new ArrayList<>();
        List<Integer> dayMar = new ArrayList<>();
        List<Integer> dayKw = new ArrayList<>();
        List<Integer> dayMaj = new ArrayList<>();
        List<Integer> dayCz = new ArrayList<>();
        List<Integer> dayLip = new ArrayList<>();
        List<Integer> daySier = new ArrayList<>();

        int month = 0;

        for (Attendance attendance : attendances) {

            DateTime dateTime = new DateTime(attendance.getDate());
            month = dateTime.getMonthOfYear();
            //System.out.println(dateTime.toString("MM"));

            if (month == 1) {
                daySt.add(dateTime.getDayOfMonth());
                st.setDay(daySt);
            }
            if (month == 2) {
                dayLu.add(dateTime.getDayOfMonth());
                lut.setDay(dayLu);
            }
            if (month == 3) {
                dayMar.add(dateTime.getDayOfMonth());
                mar.setDay(dayMar);
            }
            if (month == 4) {
                dayKw.add(dateTime.getDayOfMonth());
                kw.setDay(dayKw);
            }
            if (month == 5) {
                dayMaj.add(dateTime.getDayOfMonth());
                maj.setDay(dayMaj);
            }
            if (month == 6) {
                dayCz.add(dateTime.getDayOfMonth());
                czw.setDay(dayCz);
            }
            if (month == 7) {
                dayLip.add(dateTime.getDayOfMonth());
                lip.setDay(dayLip);
            }
            if (month == 8) {
                daySier.add(dateTime.getDayOfMonth());
                sier.setDay(daySier);
            }
            if (month == 9) {
                dayWrz.add(dateTime.getDayOfMonth());
                wrz.setDay(dayWrz);
            }
            if (month == 10) {
                dayPaz.add(dateTime.getDayOfMonth());
                paz.setDay(dayPaz);
            }
            if (month == 11) {
                dayLis.add(dateTime.getDayOfMonth());
                lis.setDay(dayLis);
            }
            if (month == 12) {
                dayGru.add(dateTime.getDayOfMonth());
                gru.setDay(dayGru);
            }

        }
        return activityInMonths;
    }



}
