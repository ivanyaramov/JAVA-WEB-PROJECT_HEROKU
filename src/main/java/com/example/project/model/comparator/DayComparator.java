package com.example.project.model.comparator;

import com.example.project.model.view.DayViewModel;

import java.util.Comparator;

public class DayComparator implements Comparator<DayViewModel> {

    @Override
    public int compare(DayViewModel o1, DayViewModel o2) {
        return o1.getNumberOfDay().compareTo(o2.getNumberOfDay());
    }
}
