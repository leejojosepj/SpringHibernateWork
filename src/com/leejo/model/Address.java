package com.leejo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */

@Entity
@Table(name = "address")
public class Address {
	
	private Integer addressId;
	private String street;
	private String city;
	private String country;
	
	private Student sudent;
	
	@Id
	@GeneratedValue
	@Column(name = "address_id")
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	@Column(name = "street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	//
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
//	@JoinColumn(name = "student_id")
	@JoinColumn(name="address_id",referencedColumnName = "s_address_id")
	public Student getSudent() {
		return sudent;
	}
	public void setSudent(Student sudent) {
		this.sudent = sudent;
	}
	
	
	
	

}
