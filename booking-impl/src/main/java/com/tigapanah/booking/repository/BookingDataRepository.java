package com.tigapanah.booking.repository;

import com.tigapanah.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDataRepository extends JpaRepository<Booking, Long> {

}
