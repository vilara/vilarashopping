package br.com.vilara.vilarashopping.model;

import java.io.Serializable;

import br.com.vilara.vilarashopping.dto.Address;
import br.com.vilara.vilarashopping.dto.User_detail;

public class RegisterModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User_detail user;
	private Address billing;
	public User_detail getUser() {
		return user;
	}
	public void setUser(User_detail user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address address) {
		this.billing = address;
	}
	
	
}
