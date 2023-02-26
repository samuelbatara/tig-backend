package com.tigapanah.user.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @SequenceGenerator(
      name = "user_sequence",
      sequenceName = "user_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "user_sequence"
  )
  private long id;
  private String fullName;
  private LocalDate birthDate;
  private Gender gender;
  private String address;

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", birthDate=" + birthDate +
        ", gender=" + gender +
        ", address='" + address + '\'' +
        '}';
  }
}
