package com.tigapanah.payment.service;

import com.tigapanah.booking.controller.BookingDataController;
import com.tigapanah.booking.controller.BookingDataControllerImpl;
import com.tigapanah.booking.model.BookingResponse;
import com.tigapanah.payment.model.Payment;
import com.tigapanah.payment.model.PaymentResponse;
import com.tigapanah.payment.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentDataServiceImpl implements PaymentDataService {
  private Logger logger = LoggerFactory.getLogger(PaymentDataServiceImpl.class);

  private PaymentRepository paymentRepository;
  private BookingDataController bookingDataController;

  public PaymentDataServiceImpl(PaymentRepository paymentRepository,
                                BookingDataControllerImpl bookingDataController) {
    this.paymentRepository = paymentRepository;
    this.bookingDataController = bookingDataController;
  }

  @Override
  public PaymentResponse getPayment(long id) throws Exception{
    Optional<Payment> optionalPayment = null;
    try {
      optionalPayment = paymentRepository.findById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to find a payment with id=%s", id), e
      );
    }

    if (optionalPayment.isEmpty()) {
      return null;
    }

    BookingResponse bookingResponse = null;
    try {
      bookingResponse = bookingDataController.getBooking(
          optionalPayment.get().getBookingId());
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to get booking response for booking-id=%s",
              optionalPayment.get().getBookingId()), e
      );
    }
    PaymentResponse paymentResponse = new PaymentResponse();
    paymentResponse.setPayment(optionalPayment.get());
    paymentResponse.setBookingResponse(bookingResponse);
    return paymentResponse;
  }

  @Override
  public boolean upsertPayment(Payment payment) throws Exception{
    try {
      if (!bookingDataController.isBookingExists(payment.getBookingId())) {
        logger.error("Booking with id={} is not registered.", payment.getBookingId());
        return false;
      }
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to check booking with id=%s", payment.getBookingId()),
          e
      );
    }

    try {
      paymentRepository.save(payment);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to upsert a payment=%s", payment.toString()),
          e
      );
    }

    return true;
  }
}
