package com.tigapanah.booking.controller;

import com.tigapanah.booking.model.Booking;
import com.tigapanah.booking.model.BookingResponse;
import com.tigapanah.booking.service.BookingDataService;
import com.tigapanah.booking.service.BookingDataServiceImpl;
import com.tigapanah.product.controller.ProductDataController;
import com.tigapanah.user.controller.UserDataController;
import com.tigapanah.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BookingDataControllerImpl implements BookingDataController{

  private BookingDataService bookingDataService;

  public BookingDataControllerImpl(BookingDataServiceImpl bookingDataService) {
    this.bookingDataService = bookingDataService;
  }

  @Override
  public boolean isBookingExists(long id) throws Exception {
    return bookingDataService.isBookingExists(id);
  }

  @Override
  public BookingResponse getBooking(long id) throws Exception {
    return bookingDataService.getBooking(id);
  }

  @Override
  public boolean addBooking(Booking booking) throws Exception {
    return bookingDataService.addBooking(booking);
  }

  @Override
  public boolean updateBooking(Booking booking) throws Exception {
    return bookingDataService.updateBooking(booking);
  }

  @Override
  public boolean deleteBooking(long id) throws Exception {
    return bookingDataService.deleteBooking(id);
  }
}
