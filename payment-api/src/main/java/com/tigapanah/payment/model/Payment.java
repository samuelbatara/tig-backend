package com.tigapanah.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
  @Id
  @SequenceGenerator(
      name = "payment_sequence",
      sequenceName = "payment_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "payment_sequence"
  )
  private long id;
  private long bookingId;
  private PaymentType type;
  private LocalDate paidDate;
  private PaymentStatus status;

  @Override
  public String toString() {
    return "Payment{" +
        "id=" + id +
        ", bookingId=" + bookingId +
        ", type=" + type +
        ", paidDate=" + paidDate +
        ", status=" + status +
        '}';
  }
}
