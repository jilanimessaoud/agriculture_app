package com.example.dellpc.project_pfe.Model;

import java.text.DateFormat;
import java.util.Calendar;

public class Date {
    String date ;

    public Date() {
    }
    /// retourner date de system
    public String getDate () {
        Calendar calender = Calendar.getInstance();
        date = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        return  date.toString() ;
    }
}
