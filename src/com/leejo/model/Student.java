package com.leejo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */

@Entity
@Table(name = "student_table")
public class Student {
	//spring 4 demo leejo jose
	Integer sid;
	String sname;
	String spassword;
	String semail;
	String sphone;
	Integer status;
    Address studentAddress;
    
    //here declaring trancient veriable for using this class as pojo in add new student form submit
    String street;
    String city;
    String country;
    //trancient veriable end
	
	
    List<Phone> phoneNumbers;
    
    
	@Id
	@GeneratedValue
	@Column(name = "student_id")
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	@Column(name = "sname")
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Column(name = "spassword")
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	
	@Column(name = "semail")
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	
	@Column(name = "sphone")
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/*OneToOne example mapping shows here @joincolumn have two parameters name and referencedColumnName, name shows the field name
	of address id in student and referencedColumnName shows the forign key of address table 
	
	
	-leejo*/
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="s_address_id",referencedColumnName = "address_id")
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	
	
	@Transient
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Transient
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Transient
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	
	public List<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	
	
}
