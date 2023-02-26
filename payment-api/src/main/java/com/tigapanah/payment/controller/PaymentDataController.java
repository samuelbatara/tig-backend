package com.tigapanah.payment.controller;

import com.tigapanah.payment.model.Payment;
import com.tigapanah.payment.model.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Path;

@FeignClient(name = "tigpay")
public interface PaymentDataController {
  @GetMapping("/payment/{id}")
  PaymentResponse getPayment(@PathVariable("id") long id) throws Exception;
  @PostMapping("/payment")
  boolean upsertPayment(@RequestBody Payment payment) throws Exception;
}
