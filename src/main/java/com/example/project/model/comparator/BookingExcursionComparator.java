package com.example.project.model.comparator;

import com.example.project.model.view.BookingExcursionViewModel;

import java.util.Comparator;

public class BookingExcursionComparator implements Comparator<BookingExcursionViewModel> {
    @Override
    public int compare(BookingExcursionViewModel o1, BookingExcursionViewModel o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
