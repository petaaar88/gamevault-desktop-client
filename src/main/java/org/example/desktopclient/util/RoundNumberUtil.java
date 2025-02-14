package org.example.desktopclient.util;

public class RoundNumberUtil {
    public static double roundDecimals(double number) {
        return Math.round(number * 10.0) / 10.0;
    }
}
