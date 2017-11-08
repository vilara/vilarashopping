package br.com.vilara.vilarashopping.dao;

import java.util.List;

import br.com.vilara.vilarashopping.dto.Address;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.User_detail;

public interface User_detailDAO {
	
	// add an user
	boolean addUser(User_detail user);
	User_detail getByEmail(String email);
	
	
	// add an address
	boolean addAddress(Address address);
	Address getBillingsAddress(User_detail user);
	List<Address> listshippingAddresses(User_detail user);
	
	
	// update a cart
	boolean updateCart(Cart cart);

}
