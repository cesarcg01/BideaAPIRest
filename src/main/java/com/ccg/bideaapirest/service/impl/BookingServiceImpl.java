package com.ccg.bideaapirest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccg.bideaapirest.model.Booking;
import com.ccg.bideaapirest.model.dao.IBookingDao;
import com.ccg.bideaapirest.service.IBookingService;

@Service
public class BookingServiceImpl implements IBookingService{
private final Logger log = LoggerFactory.getLogger(BookingServiceImpl.class); 
	
	@Autowired
	private IBookingDao bookingDao;

	@Override
	public Booking saveBooking(Booking booking) {
		log.info("inicio save ");
		Booking book = new Booking();
		bookingDao.save(booking);
		
		log.info("fin save ");
		return book;
	}
	


}
