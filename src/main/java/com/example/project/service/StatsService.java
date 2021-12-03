package com.example.project.service;

import com.example.project.model.view.StatsView;

public interface StatsService {
    void onRequest();
    StatsView getStats();
}
