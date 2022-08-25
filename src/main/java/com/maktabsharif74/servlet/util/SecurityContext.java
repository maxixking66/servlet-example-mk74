package com.maktabsharif74.servlet.util;

import com.maktabsharif74.servlet.domain.User;

public class SecurityContext {

    private static User currentUser;

    private SecurityContext() {

    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static void logout() {
        currentUser = null;
    }
}
