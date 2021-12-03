package com.example.project.model.comparator;

import com.example.project.model.view.BookingExcursionViewModel;
import com.example.project.model.view.BookingHotelViewModel;

import java.util.Comparator;

public class BookingHotelComparator implements Comparator<BookingHotelViewModel> {
    @Override
    public int compare(BookingHotelViewModel o1, BookingHotelViewModel o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
