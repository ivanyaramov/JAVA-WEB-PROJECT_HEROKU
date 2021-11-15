package com.example.project.service.impl;

import com.example.project.model.binding.RatingBindingModel;
import com.example.project.model.entity.Rating;
import com.example.project.repository.RatingRepository;
import com.example.project.service.BookingExcursionService;
import com.example.project.service.RatingService;
import com.example.project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final UserService userService;
    private final BookingExcursionService bookingExcursionService;

    public RatingServiceImpl(RatingRepository ratingRepository, UserService userService, BookingExcursionService bookingExcursionService) {
        this.ratingRepository = ratingRepository;
        this.userService = userService;
        this.bookingExcursionService = bookingExcursionService;
    }

    @Override
    public void createRating(Long userid, Long bookingid, RatingBindingModel ratingBindingModel) {
        Rating rating = new Rating();
        rating.setRating(ratingBindingModel.getRating());
        rating.setUser(userService.findById(userid));
        rating.setBookingExcursion(bookingExcursionService.findById(bookingid));
        ratingRepository.save(rating);

    }
}
