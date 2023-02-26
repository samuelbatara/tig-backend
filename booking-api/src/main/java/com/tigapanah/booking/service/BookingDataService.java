package com.tigapanah.booking.service;

import com.tigapanah.booking.model.Booking;
import com.tigapanah.booking.model.BookingResponse;

public interface BookingDataService {
  boolean isBookingExists(long id) throws Exception;
  BookingResponse getBooking(long id) throws Exception;
  boolean addBooking(Booking booking) throws Exception;
  boolean updateBooking(Booking booking) throws Exception;
  boolean deleteBooking(long id) throws Exception;
}
