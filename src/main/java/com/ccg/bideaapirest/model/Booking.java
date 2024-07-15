package com.ccg.bideaapirest.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "booking", schema = "public")
public class Booking implements Serializable {
	
	private static final long serialVersionUID = 4285177853055256800L;
	
	@Id
	@Column(name="id",unique=true , nullable = false)
	@Size(min = 9, max = 10)
	private String id;

	@NotNull(message = "Campo requerido name")
	@Size(min = 2, max = 50, message = "El campo name debe de tener entre 2 y 50 caracteres .")
	@Column(name="name", nullable = false )
	private String name;

	@NotNull(message = "Campo requerido lastname")
	@Size(min = 2, max = 50, message = "El campo lastname debe de tener entre 2 y 50 caracteres .")
	@Column(name="lastname", nullable = false)
	private String lastname;

	@NotNull(message = "Campo requerido age")
	@Min(value = 18, message = "La edad no debe ser menor de 18 años.")
	@Max(value = 100, message = "La edad no debe ser mayor de 100 años.")
	@Column(name="age",unique=true , nullable = false)
	private int age;

	@NotNull(message = "Campo requerido phoneNumber")
	@Size(min = 9, max = 20 , message = "El campo phoneNumber debe de tener entre 9 y 20 caracteres .")
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	@NotNull(message = "Campo requerido startDate")
	@Column(name = "start_date", nullable = false)
	private String startDate;

	@NotNull(message = "Campo requerido endDate")
	@Column(name = "end_date", nullable = false)
	private String endDate;

	@NotNull(message = "Campo requerido houseId")
	@Size(min = 6, max = 15 , message = "El campo houseId debe de tener entre 6 y 15 caracteres .")
	@Column(name = "house_id", nullable = false)
	private String houseId;

	@Column(name = "discount_code")
	private String discountCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	
}