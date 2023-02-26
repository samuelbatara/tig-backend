package com.tigapanah.payment.controller;

import com.tigapanah.payment.model.Payment;
import com.tigapanah.payment.model.PaymentResponse;
import com.tigapanah.payment.service.PaymentDataService;
import com.tigapanah.payment.service.PaymentDataServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentDataControllerImpl implements PaymentDataController {

  private PaymentDataService paymentDataService;

  public PaymentDataControllerImpl(PaymentDataServiceImpl paymentDataService) {
    this.paymentDataService = paymentDataService;
  }

  @Override
  public PaymentResponse getPayment(long id) throws Exception {
    return paymentDataService.getPayment(id);
  }

  @Override
  public boolean upsertPayment(Payment payment) throws Exception {
    return paymentDataService.upsertPayment(payment);
  }
}
