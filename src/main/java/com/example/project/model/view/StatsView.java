package com.example.project.model.view;

public class StatsView {

    private final int authRequests;
    private final int anonRequests;
    private final int userRequests;
    private final int moderRequests;
    private final int adminRequests;

    public StatsView(int authRequests, int anonRequests, int userRequests, int moderRequests, int adminRequests) {
        this.authRequests = authRequests;
        this.anonRequests = anonRequests;
        this.userRequests = userRequests;
        this.moderRequests = moderRequests;
        this.adminRequests = adminRequests;
    }

    public int getTotalRequests() {
        return anonRequests + authRequests;
    }

    public int getAuthRequests() {
        return authRequests;
    }


    public int getAnonRequests() {
        return anonRequests;
    }

    public int getUserRequests() {
        return userRequests;
    }

    public int getModerRequests() {
        return moderRequests;
    }

    public int getAdminRequests() {
        return adminRequests;
    }
}
