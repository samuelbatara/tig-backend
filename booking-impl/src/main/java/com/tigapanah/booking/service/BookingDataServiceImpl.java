package com.tigapanah.booking.service;

import com.tigapanah.booking.model.Booking;
import com.tigapanah.booking.model.BookingResponse;
import com.tigapanah.booking.repository.BookingDataRepository;
import com.tigapanah.product.controller.ProductDataController;
import com.tigapanah.product.model.Product;
import com.tigapanah.user.controller.UserDataController;
import com.tigapanah.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingDataServiceImpl implements BookingDataService {
  private Logger logger = LoggerFactory.getLogger(BookingDataServiceImpl.class);
  private BookingDataRepository bookingDataRepository;
  private UserDataController userDataController;
  private ProductDataController productDataController;

  public BookingDataServiceImpl(BookingDataRepository bookingDataRepository,
                                UserDataController userDataController,
                                ProductDataController productDataController) {
    this.bookingDataRepository = bookingDataRepository;
    this.userDataController = userDataController;
    this.productDataController = productDataController;
  }

  @Override
  public boolean isBookingExists(long id) throws Exception {
    boolean result = false;
    try {
      result = bookingDataRepository.existsById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to check booking with id=%s", id), e
      );
    }

    return result;
  }

  @Override
  public BookingResponse getBooking(long id) throws Exception {
    Optional<Booking> bookingOptional = null;
    try {
      bookingOptional = bookingDataRepository.findById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to find booking with id=%s", id), e
      );
    }

    if (bookingOptional.isEmpty()) {
      return null;
    }

    User user = null;
    try {
      user = userDataController.getUser(bookingOptional.get().getUserId());
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to get user with id=%s", bookingOptional.get().getUserId()),
          e
      );
    }

    Product product = null;
    try {
      product = productDataController.getProduct(bookingOptional.get().getProductId());
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to get product with id=%s", bookingOptional.get().getProductId()),
          e
      );
    }

    BookingResponse response = new BookingResponse();
    response.setBooking(bookingOptional.get());
    response.setUser(user);
    response.setProduct(product);

    return response;
  }

  @Override
  public boolean addBooking(Booking booking) throws Exception {
    try {
      if (!userDataController.isUserExists(booking.getUserId())) {
        logger.error("User id={} is not defined.", booking.getUserId());
        return false;
      }
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to get a user with id=%s", booking.getUserId()), e
      );
    }

    try {
      if (!productDataController.isProductExists(booking.getProductId())) {
        logger.error("Product id={} is not defined.", booking.getProductId());
        return false;
      }
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to get a product with id=%s", booking.getProductId()), e
      );
    }

    try {
      bookingDataRepository.save(booking);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to save a booking=%s", booking.toString()), e
      );
    }

    return true;
  }

  @Override
  public boolean updateBooking(Booking booking) throws Exception {
    try {
      bookingDataRepository.save(booking);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to update booking=%s", booking.toString()), e
      );
    }

    return true;
  }

  @Override
  public boolean deleteBooking(long id) throws Exception {
    try {
      bookingDataRepository.deleteById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to delete a booking with id=%s", id), e
      );
    }

    return true;
  }
}
