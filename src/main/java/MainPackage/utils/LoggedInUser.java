package MainPackage.utils;

import MainPackage.models.User;

public class LoggedInUser {


    private static User loggedInUser;

    public static void setLoggedInUser(User user) {
        if (loggedInUser != null) {
            loggedInUser = null;
        }
        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }
}
