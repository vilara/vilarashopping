package br.com.vilara.vilarashopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vilara.vilarashopping.dao.User_detailDAO;
import br.com.vilara.vilarashopping.dto.Address;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.User_detail;
import br.com.vilara.vilarashopping.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private User_detailDAO userDao;

	public RegisterModel init() {

		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User_detail user) {

		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {

		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model) {
		
		String transitionValue = "success";
		
		// fetch the user
		
		User_detail user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);			
			user.setCart(cart);
		}
		
		// save the user
		userDao.addUser(user);
		
		// get the Adress
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		// save the address
		userDao.addAddress(billing);
		
		return transitionValue;
	}

}
