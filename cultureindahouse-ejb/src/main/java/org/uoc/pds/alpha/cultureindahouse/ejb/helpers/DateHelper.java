package org.uoc.pds.alpha.cultureindahouse.ejb.helpers;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static LocalDate parse (String date){
        if(StringUtils.isEmpty(date)){
            return null;
        }
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }


    public static String toString(LocalDate date){
        if(date == null){
            return null;
        }
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
