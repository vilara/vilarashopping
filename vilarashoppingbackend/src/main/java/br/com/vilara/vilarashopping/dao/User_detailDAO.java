package br.com.vilara.vilarashopping.dao;

import org.h2.engine.User;

import br.com.vilara.vilarashopping.dto.Address;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.User_detail;

public interface User_detailDAO {
	
	// add an user
	boolean addUser(User_detail user);
	
	
	// add an address
	boolean addAddress(Address address);
	
	
	// add a cart
	boolean addCart(Cart cart);

}
