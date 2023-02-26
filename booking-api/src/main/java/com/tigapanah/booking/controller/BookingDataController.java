package com.tigapanah.booking.controller;

import com.tigapanah.booking.model.Booking;
import com.tigapanah.booking.model.BookingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "tigbook")
public interface BookingDataController {
  @GetMapping("/booking-exists/{id}")
  boolean isBookingExists(@PathVariable long id) throws Exception;
  @GetMapping("/booking/{id}")
  BookingResponse getBooking(@PathVariable long id) throws Exception;

  @PostMapping("/booking")
  boolean addBooking(@RequestBody Booking booking) throws Exception;

  @PutMapping("/booking")
  boolean updateBooking(@RequestBody Booking booking) throws Exception;

  @DeleteMapping("/booking")
  boolean deleteBooking(@PathVariable long id) throws Exception;
}
