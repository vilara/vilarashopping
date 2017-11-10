package br.com.vilara.vilarashopping.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

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
	@NotBlank(message="Please enter address line")
	private String addressLineOne;
	
	@Column(name="address_line_two")
	@NotBlank(message="Please enter first name")
	private String addressLinetwo;
	
	@NotBlank(message="Please enter city")
	private String city;
	@NotBlank(message="Please enter the state")
	private String state;
	@NotBlank(message="Please enter the country name")
	private String country;
	@NotBlank(message="Please enter postal code")
	@Column(name="postal_code")
	private String postalCode;
	
	private boolean shipping;
	
	private boolean billing;

	public User_detail getUser() {
		return user;
	}
	
	public void setUser(User_detail user) {
		this.user = user;
	}
	
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
