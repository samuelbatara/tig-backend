package com.tigapanah.payment.service;

import com.tigapanah.payment.model.Payment;
import com.tigapanah.payment.model.PaymentResponse;

public interface PaymentDataService {
  PaymentResponse getPayment(long id) throws Exception;
  boolean upsertPayment(Payment payment) throws Exception;
}
