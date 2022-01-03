package org.uoc.pds.alpha.cultureindahouse.ejb.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static LocalDate parse (String date){
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }


    public static String toString(LocalDate date){
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
