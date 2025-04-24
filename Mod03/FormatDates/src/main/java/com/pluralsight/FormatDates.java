package com.pluralsight;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        // Current local date/time
        LocalDateTime now = LocalDateTime.now();

        // Format 1: MM/dd/yyyy
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(fmt1));

        // Format 2: yyyy-MM-dd
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(fmt2));

        // Format 3: Month dd, yyyy
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(now.format(fmt3));

        // Format 4: Sunday, Sep 5, 2021 10:02 (GMT time)
        ZonedDateTime gmtNow = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        System.out.println(gmtNow.format(fmt4) + " GMT");

        // Challenge: 5:02 on 05-Sep-2021 (Local time)
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");
        System.out.println(now.format(fmt5));
    }
}
