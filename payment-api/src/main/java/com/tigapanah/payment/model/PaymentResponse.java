package com.tigapanah.payment.model;

import com.tigapanah.booking.model.Booking;
import com.tigapanah.booking.model.BookingResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentResponse {
  private Payment payment;
  private BookingResponse bookingResponse;
}
