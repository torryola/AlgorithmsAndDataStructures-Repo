package net.torrypubrepo.DataStructures.IntegerLinkedList;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Status_DateTime_Util
{
    private static SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy MM dd hh:mm:s");
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args)
    {
       System.out.println(" Format "+LocalDateTime.parse("2020-11-30 10:54:46", dateTimeFormatter));
        System.out.println(" Format "+(LocalDateTime.of(LocalDate.now(), LocalTime.now()).
                format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))));
        System.out.println(" Seconds "+LocalTime.now().getSecond());
    }

}//End Status_DateTime_Util
