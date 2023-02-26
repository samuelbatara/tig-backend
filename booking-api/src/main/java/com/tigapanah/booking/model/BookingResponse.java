package com.tigapanah.booking.model;

import com.tigapanah.product.model.Product;
import com.tigapanah.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BookingResponse {
  private Booking booking;
  private User user;
  private Product product;

  @Override
  public String toString() {
    return "BookingResponse{" +
        "booking=" + booking +
        ", user=" + user +
        ", product=" + product +
        '}';
  }
}
