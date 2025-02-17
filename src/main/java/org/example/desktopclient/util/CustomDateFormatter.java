package org.example.desktopclient.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CustomDateFormatter {
    public static String formatDateOfPattern(String dateString, String pattern){

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, inputFormatter);

        // "d. MMM yyyy"

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        String formattedDate = date.format(outputFormatter);

        return formattedDate;
    }
}
