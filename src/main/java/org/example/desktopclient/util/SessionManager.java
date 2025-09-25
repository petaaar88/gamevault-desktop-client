package org.example.desktopclient.util;

public class SessionManager {
    private static String jwtToken;

    public static void setToken(String token) {
        jwtToken = token;
    }

    public static String getToken() {
        return jwtToken;
    }

    public static void clearToken() {
        jwtToken = null;
    }
}
