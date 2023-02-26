package com.tigapanah.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {
  @Id
  @SequenceGenerator(
      name = "booking_sequence",
      sequenceName = "booking_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "booking_sequence"
  )
  private long id;
  private long userId;
  private long productId;
  private LocalDate bookedDate;

  @Override
  public String toString() {
    return "Booking{" +
        "id=" + id +
        ", userId=" + userId +
        ", productId=" + productId +
        ", bookedDate=" + bookedDate +
        '}';
  }
}
