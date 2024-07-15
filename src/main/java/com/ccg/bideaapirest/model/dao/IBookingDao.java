package com.ccg.bideaapirest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccg.bideaapirest.model.Booking;

public interface IBookingDao extends JpaRepository<Booking, String>{

}
