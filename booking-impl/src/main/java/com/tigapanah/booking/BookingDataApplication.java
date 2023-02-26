package com.tigapanah.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
    "com.tigapanah.booking",
    "com.tigapanah.user",
    "com.tigapanah.product"})
//@EnableFeignClients
public class BookingDataApplication {
  public static void main(String[] args) {
    SpringApplication.run(BookingDataApplication.class, args);
  }
}
