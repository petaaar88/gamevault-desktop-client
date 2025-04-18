package org.example.desktopclient.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CustomDateFormatter {
    public static String formatDateOfPattern(String dateString, String pattern){

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(dateString, inputFormatter);

        // "d. MMM yyyy"

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        String formattedDate = parsedDate.format(outputFormatter);

        return formattedDate;
    }

    public static String fomatDateTimeOfPattern(String dateTimeString, String pattern){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, inputFormatter);

        // "d. MMM yyyy"

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        String formattedDate = parsedDateTime.format(outputFormatter);

        return formattedDate;
    }

    public static String formatDateTimeOfPattern2(String dateTimeString, String pattern) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        return parsedDateTime.format(outputFormatter);
    }

}
