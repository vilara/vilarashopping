package br.com.vilara.vilarashopping.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Private fields
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User_detail user;
	
	
	
	@Column(name="address_line_one")
	private String addressLineOne;
	
	@Column(name="address_line_two")
	private String addressLinetwo;
	
	
	
	public User_detail getUser() {
		return user;
	}

	public void setUser(User_detail user) {
		this.user = user;
	}

	private String city;
	
	private String state;
	
	private String country;
	
	@Column(name="postal_code")
	private String postalCode;
	
	private boolean shipping;
	
	private boolean billing;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLinetwo() {
		return addressLinetwo;
	}

	public void setAddressLinetwo(String addressLinetwo) {
		this.addressLinetwo = addressLinetwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	
	
	
	
	
	
}
