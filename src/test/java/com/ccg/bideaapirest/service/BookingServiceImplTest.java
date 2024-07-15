package com.ccg.bideaapirest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ccg.bideaapirest.model.Booking;
import com.ccg.bideaapirest.model.dao.IBookingDao;
import com.ccg.bideaapirest.service.impl.BookingServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {
	
	@Mock
	private IBookingDao bookingDao;
	
	@InjectMocks
	private BookingServiceImpl bookingService;
	
	Booking book ;
	
	  @BeforeEach
	    public void setup(){
	 		book.setId("14564088-5");
	 		book.setName("Gonzalo");
	 		book.setLastname("Perez");
	 		book.setAge(37);
	 		book.setPhoneNumber("56988123222");
	 		book.setStartDate("2022-03-04");
	 		book.setEndDate("2022-03-04");
	 		book.setHouseId("213132");
	    }
	
	@Test
    public void saveBookingTest() { 

     	given(bookingDao.save(book)).willReturn(book);
		Booking saveBook = bookingService.saveBooking(book);
		assertThat(saveBook).isNotNull();

    }
}

