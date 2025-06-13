package com.fortuna.ProgettoTimeSheet;

public class LoginStatus {
    private boolean loggedIn;
    private String message;

    public LoginStatus(boolean loggedIn, String message) {
        this.loggedIn = loggedIn;
        this.message = message;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
